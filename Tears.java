public class Tears extends GameObject{
    public Tears(double x, double y)
    {
        super(x, y);
        rectangles = new Rectangle[2];

        rectangles[0] = new Rectangle(1000, 1000, 10, 20, "BLUE", 10);
        rectangles[1] = new Rectangle(1000, 1000, 10, 20, "BLUE", 10);
    }
}
