public class Mouse extends GameObject
{
    public Mouse(double x, double y, double size)
    {
        super(x, y, size);
        rectangles = new Rectangle[6];

        rectangles[0] = new Rectangle(x, y, 5*size, 5*size, "WHITE", 0);
        hitbox =  rectangles[0];

        rectangles[1] = new Rectangle(x, y, 2*size, 2*size, "BLACK", 8);
        rectangles[2] = new Rectangle(x+(3*size), y, 2*size, 2*size, "BLACK", 8);
        rectangles[3] = new Rectangle(x+size, y+size, 3*size, 4*size, "BLACK", 8);
        rectangles[4] = new Rectangle(x+size, y+(2*size), size, size, "RED", 8);
        rectangles[5] = new Rectangle(x+(3*size), y+(2*size), size, size, "RED", 8);
    }
}
