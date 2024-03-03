package GameObjects;
import GameArena.Rectangle;
import static GameData.GameSettings.OBJ_SIZE;
public class Tears extends GameObject{
    public Tears(double x, double y)
    {
        super(x, y);
        rectangles = new Rectangle[2];

        rectangles[0] = new Rectangle(x+(2*OBJ_SIZE), y+(5*OBJ_SIZE), OBJ_SIZE, 2*OBJ_SIZE, "BLUE", 10);
        rectangles[1] = new Rectangle(x+(5*OBJ_SIZE), y+(5*OBJ_SIZE), OBJ_SIZE, 2*OBJ_SIZE, "BLUE", 10);
    }
}
