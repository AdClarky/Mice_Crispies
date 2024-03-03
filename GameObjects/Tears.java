package GameObjects;
import GameArena.Rectangle;
public class Tears extends GameObject{
    public Tears(double x, double y, double scaleMultiplier)
    {
        super(x, y, scaleMultiplier);
        rectangles = new Rectangle[2];

        rectangles[0] = new Rectangle(x+(2*scaleMultiplier), y+(5*scaleMultiplier), scaleMultiplier, 2*scaleMultiplier, "BLUE", 10);
        rectangles[1] = new Rectangle(x+(5*scaleMultiplier), y+(5*scaleMultiplier), scaleMultiplier, 2*scaleMultiplier, "BLUE", 10);
    }
}
