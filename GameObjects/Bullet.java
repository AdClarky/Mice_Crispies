package GameObjects;
import GameArena.Rectangle;
public class Bullet extends GameObject{
    public Bullet(double x, double y, double scaleMultiplier)
    {
        super(x, y, scaleMultiplier);
        rectangles = new Rectangle[3];

        rectangles[0] = new Rectangle(x, y+(2*scaleMultiplier), scaleMultiplier, 2*scaleMultiplier, "BLACK", 9);
        rectangles[1] = new Rectangle(x+scaleMultiplier, y+scaleMultiplier, scaleMultiplier, 4*scaleMultiplier, "BLACK", 9);
        rectangles[2] = new Rectangle(x+(2*scaleMultiplier), y, 6*scaleMultiplier, 6*scaleMultiplier, "BLACK", 9);
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
