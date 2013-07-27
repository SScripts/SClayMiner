package SClayMiner.Node;

import SClayMiner.Job;
import SClayMiner.Vars.Cons;
import SClayMiner.Vars.Vars;
import org.powerbot.script.methods.MethodContext;


public class WalkBank extends Job {
    public WalkBank(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Vars.ctx.equipment.select().size() == 28 && !Cons.area.contains(Vars.ctx.players.local());
    }

    @Override
    public void execute() {
        Vars.ctx.movement.newTilePath(Cons.path).traverse();
        Vars.Status = "Walking to Bank";
    }
}
