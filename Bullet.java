public class Bullet {
    private double x;
    private double y;
    private final Rectangle[] rectangles = new Rectangle[4];
    public Rectangle hitbox;

    public Bullet(int starting_x, int starting_y)
    {
        x = starting_x;
        y = starting_y;

        rectangles[0] = new Rectangle(x, y, 70, 50, "WHITE", 0);
        hitbox = rectangles[0];

        rectangles[1] = new Rectangle(x, y+20, 10, 20, "WHITE", 9);
        rectangles[2] = new Rectangle(x+10, y+10, 10, 40, "WHITE", 9);
        rectangles[3] = new Rectangle(x+20, y, 60, 60, "WHITE", 9);
    }

    public void addTo(GameArena gameArena)
    {
        for (Rectangle rectangle : rectangles)
        {
            gameArena.addRectangle(rectangle);
        }
    }

    public void move(double dx, double dy)
    {
        for (Rectangle rectangle : rectangles)
        {
            rectangle.setXPosition(rectangle.getXPosition()+dx);
            rectangle.setYPosition(rectangle.getYPosition()+dy);
        }
        x += dx;
        y += dy;
    }
}
