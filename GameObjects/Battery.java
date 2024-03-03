package GameObjects;
import java.util.Random;
import GameArena.Rectangle;

public class Battery extends GameObject {
    private static final int WINDOW_SIZE = 1000;
    private final Random rand = new Random();

    public Battery(double scaleMultiplier)
    {
        super(0, 0, scaleMultiplier);
        x = rand.nextDouble(WINDOW_SIZE - (scaleMultiplier*6));
        y = rand.nextDouble(WINDOW_SIZE - (scaleMultiplier*6));

        rectangles = new Rectangle[3];

        rectangles[0] = new Rectangle(x, y, 2*scaleMultiplier, 5*scaleMultiplier, "WHITE", 0);
        hitbox =  rectangles[0];

        rectangles[1] = new Rectangle(x, y, 2*scaleMultiplier, 2*scaleMultiplier, "ORANGE", 9);
        rectangles[2] = new Rectangle(x, y+(2*scaleMultiplier), 2*scaleMultiplier, 3*scaleMultiplier, "BLACK", 9);
    }

    public void captured()
    {
        double new_x = rand.nextDouble(WINDOW_SIZE - (scaleMultiplier*6));
        double new_y = rand.nextDouble(WINDOW_SIZE - (scaleMultiplier*6)) + 50;

        // ensures it spawns away from where the last one was
        if(x < 500)
        {
            new_x += 500;
        }
        if(y < 500)
        {
            new_y += 500;
        }
        setPosition(new_x, new_y);
    }
}
