package GameObjects;
import GameArena.Rectangle;
import static GameData.GameSettings.OBJ_SIZE;
public class Flames extends GameObject{
    public Flames(double x, double y)
    {
        super(x, y);
        rectangles = new Rectangle[12];

        rectangles[0] = new Rectangle(x+(3*OBJ_SIZE), y+(8*OBJ_SIZE), 2*OBJ_SIZE, OBJ_SIZE, "WHITE", 10);
        rectangles[1] = new Rectangle(x+(2*OBJ_SIZE), y+(8*OBJ_SIZE), OBJ_SIZE, OBJ_SIZE, "YELLOW", 10);
        rectangles[2] = new Rectangle(x+(5*OBJ_SIZE), y+(8*OBJ_SIZE), OBJ_SIZE, OBJ_SIZE, "YELLOW", 10);
        rectangles[3] = new Rectangle(x+(3*OBJ_SIZE), y+(9*OBJ_SIZE), 2*OBJ_SIZE, OBJ_SIZE, "YELLOW", 10);
        rectangles[4] = new Rectangle(x+(2*OBJ_SIZE), y+(9*OBJ_SIZE), OBJ_SIZE, 2*OBJ_SIZE, "ORANGE", 10);
        rectangles[5] = new Rectangle(x+(3*OBJ_SIZE), y+(10*OBJ_SIZE), 2*OBJ_SIZE, OBJ_SIZE, "ORANGE", 10);
        rectangles[6] = new Rectangle(x+(5*OBJ_SIZE), y+(9*OBJ_SIZE), OBJ_SIZE, OBJ_SIZE, "ORANGE", 10);
        rectangles[7] = new Rectangle(x+(2*OBJ_SIZE), y+(10*OBJ_SIZE), OBJ_SIZE, 2*OBJ_SIZE, "RED", 10);
        rectangles[8] = new Rectangle(x+(3*OBJ_SIZE), y+(11*OBJ_SIZE), 3*OBJ_SIZE, OBJ_SIZE, "RED", 10);
        rectangles[9] = new Rectangle(x+(5*OBJ_SIZE), y+(10*OBJ_SIZE), OBJ_SIZE, 2*OBJ_SIZE, "RED", 10);
        rectangles[10] = new Rectangle(x+OBJ_SIZE, y+70, OBJ_SIZE, 3*OBJ_SIZE, "RED", 10);
        rectangles[11] = new Rectangle(x+(6*OBJ_SIZE), y+(7*OBJ_SIZE), OBJ_SIZE, 4*OBJ_SIZE, "RED", 10);

    }
}
