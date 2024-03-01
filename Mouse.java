public class Mouse extends GameObject
{
    public Mouse(int x, int y)
    {
        super(x, y);
        rectangles = new Rectangle[6];

        rectangles[0] = new Rectangle(x, y, 50, 50, "WHITE", 0);
        hitbox =  rectangles[0];

        rectangles[1] = new Rectangle(x, y, 20, 20, "BLACK", 8);
        rectangles[2] = new Rectangle(x+30, y, 20, 20, "BLACK", 8);
        rectangles[3] = new Rectangle(x+10, y+10, 30, 40, "BLACK", 8);
        rectangles[4] = new Rectangle(x+10, y+20, 10, 10, "RED", 8);
        rectangles[5] = new Rectangle(x+30, y+20, 10, 10, "RED", 8);
    }
}
