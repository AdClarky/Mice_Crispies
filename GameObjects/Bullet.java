package GameObjects;
import GameArena.Rectangle;
public class Bullet extends GameObject{
    double size;
    public Bullet(double x, double y, double size)
    {
        super(x, y);
        this.size = size;
        rectangles = new Rectangle[3];

        rectangles[0] = new Rectangle(x, y+(2*size), size, 2*size, "BLACK", 9);
        rectangles[1] = new Rectangle(x+size, y+size, size, 4*size, "BLACK", 9);
        rectangles[2] = new Rectangle(x+(2*size), y, 6*size, 6*size, "BLACK", 9);
    }


    public double getXPosition()
    {
        return x;
    }

    public double getSize(){
        return size;
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
