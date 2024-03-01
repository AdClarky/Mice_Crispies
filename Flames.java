public class Flames extends GameObject{
    public Flames(double x, double y, double size)
    {
        super(x, y, size);
        rectangles = new Rectangle[12];

        rectangles[0] = new Rectangle(x+(3*size), y+(8*size), 2*size, size, "WHITE", 10);
        rectangles[1] = new Rectangle(x+(2*size), y+(8*size), size, size, "YELLOW", 10);
        rectangles[2] = new Rectangle(x+(5*size), y+(8*size), size, size, "YELLOW", 10);
        rectangles[3] = new Rectangle(x+(3*size), y+(9*size), 2*size, size, "YELLOW", 10);
        rectangles[4] = new Rectangle(x+(2*size), y+(9*size), size, 2*size, "ORANGE", 10);
        rectangles[5] = new Rectangle(x+(3*size), y+(10*size), 2*size, size, "ORANGE", 10);
        rectangles[6] = new Rectangle(x+(5*size), y+(9*size), size, size, "ORANGE", 10);
        rectangles[7] = new Rectangle(x+(2*size), y+(10*size), size, 2*size, "RED", 10);
        rectangles[8] = new Rectangle(x+(3*size), y+(11*size), 3*size, size, "RED", 10);
        rectangles[9] = new Rectangle(x+(5*size), y+(10*size), size, 2*size, "RED", 10);
        rectangles[10] = new Rectangle(x+size, y+70, size, 3*size, "RED", 10);
        rectangles[11] = new Rectangle(x+(6*size), y+(7*size), size, 4*size, "RED", 10);

    }
}
