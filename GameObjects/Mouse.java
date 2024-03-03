package GameObjects;
import GameArena.Rectangle;
import static GameData.GameSettings.OBJ_SIZE;
public class Mouse extends GameObject
{
    public Mouse(double x, double y)
    {
        super(x, y);
        rectangles = new Rectangle[6];

        rectangles[0] = new Rectangle(x, y, 5*OBJ_SIZE, 5*OBJ_SIZE, "WHITE", 0);
        hitbox =  rectangles[0];

        rectangles[1] = new Rectangle(x, y, 2*OBJ_SIZE, 2*OBJ_SIZE, "BLACK", 8);
        rectangles[2] = new Rectangle(x+(3*OBJ_SIZE), y, 2*OBJ_SIZE, 2*OBJ_SIZE, "BLACK", 8);
        rectangles[3] = new Rectangle(x+OBJ_SIZE, y+OBJ_SIZE, 3*OBJ_SIZE, 4*OBJ_SIZE, "BLACK", 8);
        rectangles[4] = new Rectangle(x+OBJ_SIZE, y+(2*OBJ_SIZE), OBJ_SIZE, OBJ_SIZE, "RED", 8);
        rectangles[5] = new Rectangle(x+(3*OBJ_SIZE), y+(2*OBJ_SIZE), OBJ_SIZE, OBJ_SIZE, "RED", 8);
    }
}
