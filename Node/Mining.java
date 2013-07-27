package SClayMiner.Node;


import SClayMiner.Job;
import SClayMiner.Vars.*;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Delay;
import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.GameObject;


public  class Mining extends Job {

    public static GameObject rock = Vars.ctx.objects.select().id(Cons.rocks).nearest().iterator().next();

    public Mining(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {

        return Vars.ctx.backpack.isEmpty() && Cons.areatwo.contains(Vars.ctx.players.local());


    }
    @Override
    public void execute() {


        if(Cons.rock != null && Vars.ctx.backpack.isEmpty()){

            if(rock.isOnScreen()){
                if(Vars.ctx.players.local().equals(rock)) {
                    if(Vars.ctx.objects.equals(rock)){
                        rock.interact("Miner");
                        Vars.Status = "Mining";
                        Timer t = new Timer(3000);
                        while(t.isRunning()&&Cons.rock.isValid()){
                            Delay.sleep(100,150);
                        }
                    }





                }




            } else  {
                Vars.ctx.camera.turnTo(Cons.rock);
                Vars.Status = "Looking for the rock";
            }

    }
    }
}


