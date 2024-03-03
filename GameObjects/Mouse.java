package GameObjects;
import GameArena.Rectangle;
public class Mouse extends GameObject
{
    public Mouse(double x, double y, double scaleMultiplier)
    {
        super(x, y, scaleMultiplier);
        rectangles = new Rectangle[6];

        rectangles[0] = new Rectangle(x, y, 5*scaleMultiplier, 5*scaleMultiplier, "WHITE", 0);
        hitbox =  rectangles[0];

        rectangles[1] = new Rectangle(x, y, 2*scaleMultiplier, 2*scaleMultiplier, "BLACK", 8);
        rectangles[2] = new Rectangle(x+(3*scaleMultiplier), y, 2*scaleMultiplier, 2*scaleMultiplier, "BLACK", 8);
        rectangles[3] = new Rectangle(x+scaleMultiplier, y+scaleMultiplier, 3*scaleMultiplier, 4*scaleMultiplier, "BLACK", 8);
        rectangles[4] = new Rectangle(x+scaleMultiplier, y+(2*scaleMultiplier), scaleMultiplier, scaleMultiplier, "RED", 8);
        rectangles[5] = new Rectangle(x+(3*scaleMultiplier), y+(2*scaleMultiplier), scaleMultiplier, scaleMultiplier, "RED", 8);
    }
}
