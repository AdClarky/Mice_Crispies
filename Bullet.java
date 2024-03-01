public class Bullet extends GameObject{
    private int size = 5;

    public Bullet(int x, int y, int size_input)
    {
        super(x, y);
        rectangles = new Rectangle[3];

        size = size_input;
        rectangles[0] = new Rectangle(x, y+(2*size), 1*size, 2*size, "BLACK", 9);
        rectangles[1] = new Rectangle(x+(1*size), y+(1*size), 1*size, 4*size, "BLACK", 9);
        rectangles[2] = new Rectangle(x+(2*size), y, 6*size, 6*size, "BLACK", 9);
    }

    public int getSize()
    {
        return size;
    }

    public double getXPosition()
    {
        return x;
    }

    public boolean checkCollision(Rectangle hitbox)
    {
        for (Rectangle rectangle : rectangles) {
            if(rectangle.collides(hitbox))
            {
                return true;
            }
        }
        return false;
    }
}
