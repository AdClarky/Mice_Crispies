import java.util.Random;

public class Battery {
    private double x = 0;
    private double y = 0;
    private Random rand = new Random();
    private Rectangle[] rectangles = new Rectangle[2];

    public Battery()
    {
        x = rand.nextInt(940);
        y = rand.nextInt(940);

        rectangles[0] = new Rectangle(x, y, 20, 20, "ORANGE");
        rectangles[1] = new Rectangle(x, y+20, 20, 30, "BLACK");
    }

    public void captured()
    {
        int new_x = rand.nextInt(440);
        int new_y = rand.nextInt(440);
        if(x < 500)
        {
            x = new_x + 500;
        }
        if(y < 500)
        {
            y = new_y + 500;
        }
    }

    public void addTo(GameArena gameArena)
    {
        for (Rectangle rectangle : rectangles) {
            gameArena.addRectangle(rectangle);
        }
    }
}
