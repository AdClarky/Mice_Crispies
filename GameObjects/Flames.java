package GameObjects;
import GameArena.Rectangle;
public class Flames extends GameObject{
    public Flames(double x, double y, double scaleMultiplier)
    {
        super(x, y, scaleMultiplier);
        rectangles = new Rectangle[12];

        rectangles[0] = new Rectangle(x+(3*scaleMultiplier), y+(8*scaleMultiplier), 2*scaleMultiplier, scaleMultiplier, "WHITE", 10);
        rectangles[1] = new Rectangle(x+(2*scaleMultiplier), y+(8*scaleMultiplier), scaleMultiplier, scaleMultiplier, "YELLOW", 10);
        rectangles[2] = new Rectangle(x+(5*scaleMultiplier), y+(8*scaleMultiplier), scaleMultiplier, scaleMultiplier, "YELLOW", 10);
        rectangles[3] = new Rectangle(x+(3*scaleMultiplier), y+(9*scaleMultiplier), 2*scaleMultiplier, scaleMultiplier, "YELLOW", 10);
        rectangles[4] = new Rectangle(x+(2*scaleMultiplier), y+(9*scaleMultiplier), scaleMultiplier, 2*scaleMultiplier, "ORANGE", 10);
        rectangles[5] = new Rectangle(x+(3*scaleMultiplier), y+(10*scaleMultiplier), 2*scaleMultiplier, scaleMultiplier, "ORANGE", 10);
        rectangles[6] = new Rectangle(x+(5*scaleMultiplier), y+(9*scaleMultiplier), scaleMultiplier, scaleMultiplier, "ORANGE", 10);
        rectangles[7] = new Rectangle(x+(2*scaleMultiplier), y+(10*scaleMultiplier), scaleMultiplier, 2*scaleMultiplier, "RED", 10);
        rectangles[8] = new Rectangle(x+(3*scaleMultiplier), y+(11*scaleMultiplier), 3*scaleMultiplier, scaleMultiplier, "RED", 10);
        rectangles[9] = new Rectangle(x+(5*scaleMultiplier), y+(10*scaleMultiplier), scaleMultiplier, 2*scaleMultiplier, "RED", 10);
        rectangles[10] = new Rectangle(x+scaleMultiplier, y+70, scaleMultiplier, 3*scaleMultiplier, "RED", 10);
        rectangles[11] = new Rectangle(x+(6*scaleMultiplier), y+(7*scaleMultiplier), scaleMultiplier, 4*scaleMultiplier, "RED", 10);

    }
}
