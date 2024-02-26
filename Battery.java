import java.util.Random;

public class Battery {
    private double x;
    private double y;
    private final Random rand = new Random();
    private final Rectangle[] rectangles = new Rectangle[3];
    public Rectangle hitbox;

    public Battery()
    {
        x = rand.nextInt(940);
        y = rand.nextInt(940);

        rectangles[0] = new Rectangle(x, y, 20, 50, "WHITE", 0);
        hitbox =  rectangles[0];

        rectangles[1] = new Rectangle(x, y, 20, 20, "ORANGE", 9);
        rectangles[2] = new Rectangle(x, y+20, 20, 30, "BLACK", 9);
    }

    public void captured()
    {
        int new_x = rand.nextInt(440);
        int new_y = rand.nextInt(440) + 50;
        if(x < 500)
        {
            new_x += 500;
        }
        if(y < 500)
        {
            new_y += 500;
        }

        for (Rectangle rectangle : rectangles) {
            rectangle.setXPosition((rectangle.getXPosition()-x) + new_x);
            rectangle.setYPosition((rectangle.getYPosition()-y) + new_y);
        }
        x = new_x;
        y = new_y;
    }

    public void addTo(GameArena gameArena)
    {
        for (Rectangle rectangle : rectangles) {
            gameArena.addRectangle(rectangle);
        }
    }
}
