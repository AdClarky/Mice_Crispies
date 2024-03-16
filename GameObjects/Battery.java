package GameObjects;
import java.util.Random;
import GameArena.Rectangle;

import static GameData.GameSettings.*;

public class Battery extends GameObject {
    private final Random rand = new Random();

    public Battery()
    {
        super(0, 0);
        x = rand.nextDouble(WINDOW_SIZE - (OBJ_SIZE*6));
        y = rand.nextDouble(WINDOW_SIZE - (OBJ_SIZE*6));

        rectangles = new Rectangle[3];

        rectangles[0] = new Rectangle(x, y, 2*OBJ_SIZE, 5*OBJ_SIZE, "WHITE", 0);
        hitbox =  rectangles[0];

        rectangles[1] = new Rectangle(x, y, 2*OBJ_SIZE, 2*OBJ_SIZE, "ORANGE", 9);
        rectangles[2] = new Rectangle(x, y+(2*OBJ_SIZE), 2*OBJ_SIZE, 3*OBJ_SIZE, "BLACK", 9);
    }

    public void captured()
    {
        double new_x = rand.nextDouble(WINDOW_SIZE - (OBJ_SIZE*6));
        double new_y = rand.nextDouble(WINDOW_SIZE - (OBJ_SIZE*6)) + HEADER_SIZE;

        // ensures it spawns away from where the last one was
        if(x < (double) WINDOW_SIZE /2)
        {
            new_x += (double) WINDOW_SIZE /2;
        }
        if(y < (double) WINDOW_SIZE /2)
        {
            new_y += (double) WINDOW_SIZE / 2;
        }
        setPosition(new_x, new_y);
    }
}
