public class Tears extends GameObject{
    public Tears(double x, double y, double size)
    {
        super(x, y, size);
        rectangles = new Rectangle[2];

        rectangles[0] = new Rectangle(x+(2*size), y+(5*size), size, 2*size, "BLUE", 10);
        rectangles[1] = new Rectangle(x+(5*size), y+(5*size), size, 2*size, "BLUE", 10);
    }
}
