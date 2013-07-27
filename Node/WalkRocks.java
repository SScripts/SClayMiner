package SClayMiner.Node;

import SClayMiner.Job;
import SClayMiner.Vars.Cons;
import SClayMiner.Vars.Vars;
import org.powerbot.script.methods.MethodContext;


public class WalkRocks extends Job {


    public WalkRocks(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !Vars.ctx.equipment.contains(Cons.Clay) && !Vars.ctx.bank.isOpen() && !Cons.areatwo.contains(Vars.ctx.players.local());
    }

    @Override
    public void execute() {
        Vars.ctx.movement.newTilePath(Cons.pathtwo).traverse();
        Vars.Status = "Walking to Clay";
    }

}
