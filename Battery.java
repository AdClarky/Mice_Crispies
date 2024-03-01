import java.util.Random;

public class Battery extends GameObject {
    private final Random rand = new Random();

    public Battery(double size)
    {
        super(0, 0, size);
        x = rand.nextInt(940);
        y = rand.nextInt(940);

        rectangles = new Rectangle[3];

        rectangles[0] = new Rectangle(x, y, 2*size, 5*size, "WHITE", 0);
        hitbox =  rectangles[0];

        rectangles[1] = new Rectangle(x, y, 2*size, 2*size, "ORANGE", 9);
        rectangles[2] = new Rectangle(x, y+(2*size), 2*size, 3*size, "BLACK", 9);
    }

    public void captured()
    {
        int new_x = rand.nextInt(440);
        int new_y = rand.nextInt(440) + 50;

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
