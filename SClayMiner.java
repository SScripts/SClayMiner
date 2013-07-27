package SClayMiner;


import SClayMiner.Node.Banking;
import SClayMiner.Node.Mining;
import SClayMiner.Node.WalkBank;
import SClayMiner.Node.WalkRocks;

import SClayMiner.Vars.*;
import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.methods.Skills;


import org.powerbot.script.PollingScript;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;


@Manifest(name = "SClayMiner", description = "Mines Clay in Varrock West", authors = {"SScripts"}, version = 1.5)

public class SClayMiner extends PollingScript implements PaintListener,MouseListener{


    public JobContainer container = null;

    public SClayMiner() {
        getExecQueue(State.START).add(new Runnable() {
            @Override
            public void run() {
                if (container == null) {
                    container = new JobContainer(new Job[]{
                            new Banking(getContext()), new Mining(getContext()), new WalkBank(getContext()), new WalkRocks(getContext())});

                }
            }
        });
    }

    @Override
    public int poll() {
        final Job job = container.get();
        if (job != null) {
            job.execute();
            return job.delay();
        }
        return 250;
    }
    @Override
    public void start() {
        Vars.StartEXP = ctx.skills.getExperience(Skills.MINING);

    }
    private final LinkedList<MousePathPoint> mousePath = new LinkedList<MousePathPoint>();

    @SuppressWarnings("serial")
    private class MousePathPoint extends Point { // All credits to Enfilade

        private long finishTime;
        private double lastingTime;

        public MousePathPoint(int x, int y, int lastingTime) {
            super(x, y);
            this.lastingTime = lastingTime;
            finishTime = System.currentTimeMillis() + lastingTime;
        }

        public boolean isUp() {
            return System.currentTimeMillis() > finishTime;
        }
    }

    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }

    private final Image img1 = getImage("http://i.imgur.com/9UiPNE9.png");
    boolean hide = false;
    Point p;
    Rectangle close = new Rectangle(500, 375, 25, 25);
    Rectangle open = new Rectangle(427, 405, 90, 90);
    Image button = getImage("http://i.imgur.com/H7UBt9i.png");

    @Override
    public void mouseClicked(MouseEvent e) {
        p = e.getPoint();
        if (close.contains(p) && !hide) {
            hide = true;
        } else if (open.contains(p) && hide) {
            hide = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void repaint(Graphics g) {

        if (ctx.game.getClientState()  == 11) {
            if (!hide) {

                g.drawImage(img1, 1, 380, null);
                g.setColor(Color.BLACK);
                g.setFont(Vars.font1);
                g.drawString("" + Vars.runTime.toElapsedString(), 150, 414);
                g.drawString("" + (ctx.skills.getExperience(Skills.MINING)-Vars.StartEXP)/5, 135, 468);

                g.drawString("" + ((ctx.skills.getExperience(Skills.MINING)-Vars.StartEXP)/5)*Vars.Gold, 145, 498);
                g.drawString("" + (ctx.skills.getExperience(Skills.MINING)-Vars.StartEXP) , 137, 442);


                g.setColor(Color.BLACK);
                g.setFont(Vars.font2);
                g.drawString("" + Vars.Status, 325, 496);

            }

            if (hide) {

                g.drawImage(button, 427, 405, null);
            }
        }

        g.setColor(Color.BLUE);
        g.drawLine(ctx.mouse.getLocation().x - 0, ctx.mouse.getLocation().x  - 0, ctx.mouse.getLocation().x  + 0, ctx.mouse.getLocation().x  + 900);
        g.drawLine(ctx.mouse.getLocation().x - 0, ctx.mouse.getLocation().x  + 0, ctx.mouse.getLocation().x  + 900, ctx.mouse.getLocation().x  - 0);
        g.drawLine(ctx.mouse.getLocation().x  - 900, ctx.mouse.getLocation().x  + 0, ctx.mouse.getLocation().x  + 0, ctx.mouse.getLocation().x  - 0);
        g.drawLine(ctx.mouse.getLocation().x  - 0, ctx.mouse.getLocation().x  + 0, ctx.mouse.getLocation().x  + 0, ctx.mouse.getLocation().x  - 900);
        g.setColor( ctx.mouse.isPressed() ? Color.PINK : Color.BLACK );

    }
}
