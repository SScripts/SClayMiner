package SClayMiner.Node;

import SClayMiner.Job;
import SClayMiner.Vars.Cons;
import SClayMiner.Vars.Vars;
import org.powerbot.script.methods.Bank;
import org.powerbot.script.methods.MethodContext;

public class Banking extends Job {

    public Banking(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.equipment.select().size() == 28 && Cons.area.contains(Vars.ctx.players.local());
    }

    @Override
    public void execute() {

        if (ctx.equipment.contains(Cons.Clay)) {
            Vars.Status = "Deposit";
            ctx.bank.deposit(Cons.CLAY_ID, Bank.Amount.ALL);
            if (!ctx.equipment.contains(Cons.Clay) && Vars.ctx.bank.isOpen()) {
                Vars.Status = "Closing Bank";
                ctx.bank.close();


            }else {

                Vars.Status = "Opening Bank";
                ctx.bank.open();
            }
        }
    }

}
