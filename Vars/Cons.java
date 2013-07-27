package SClayMiner.Vars;



import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.wrappers.Tile;


public class Cons {



    public static final int[] rocks = {15503,15505};
    public static final int CLAY_ID = 434;

    public static GameObject rock = Vars.ctx.objects.select().id(rocks).nearest().iterator().next();

    public static Item Clay = Vars.ctx.backpack.getItemAt(CLAY_ID);



    public static final Tile[] path = {
            new Tile(3184, 3379, 0), new Tile(3179, 3382, 0),
            new Tile(3176, 3386, 0), new Tile(3173, 3391, 0),
            new Tile(3171, 3396, 0), new Tile(3170, 3403, 0),
            new Tile(3169, 3408, 0), new Tile(3169, 3413, 0),
            new Tile(3169, 3419, 0), new Tile(3171, 3425, 0),
            new Tile(3175, 3428, 0), new Tile(3181, 3428, 0),
            new Tile(3185, 3429, 0), new Tile(3185, 3434, 0)
    };
    public static final Area areatwo = new Area(new Tile[] {
            new Tile(3170, 3384, 0), new Tile(3171, 3362, 0),
            new Tile(3188, 3361, 0), new Tile(3190, 3380, 0)
    });
    public static final Area area = new Area(new Tile[] {
            new Tile(3178, 3448, 0), new Tile(3178, 3432, 0),
            new Tile(3194, 3431, 0), new Tile(3194, 3447, 0)
    });
    public static final Tile[] pathtwo = {
            new Tile(3184, 3433, 0), new Tile(3182, 3428, 0),
            new Tile(3175, 3428, 0), new Tile(3171, 3426, 0),
            new Tile(3170, 3420, 0), new Tile(3170, 3414, 0),
            new Tile(3170, 3408, 0), new Tile(3169, 3402, 0),
            new Tile(3171, 3396, 0), new Tile(3174, 3391, 0),
            new Tile(3176, 3385, 0), new Tile(3179, 3380, 0),
            new Tile(3184, 3379, 0), new Tile(3185, 3375, 0)
    };

}
