public class Bullet {
    private double x;
    private double y;
    private static final int SIZE = 5;
    private final Rectangle[] rectangles = new Rectangle[4];
    public Rectangle hitbox;

    public Bullet(int starting_x, int starting_y)
    {
        x = starting_x;
        y = starting_y;

        rectangles[0] = new Rectangle(x, y, 7*SIZE, 6*SIZE, "BLUE", 0);
        hitbox = rectangles[0];

        rectangles[1] = new Rectangle(x, y+(2*SIZE), 1*SIZE, 2*SIZE, "BLACK", 9);
        rectangles[2] = new Rectangle(x+(1*SIZE), y+(1*SIZE), 1*SIZE, 4*SIZE, "BLACK", 9);
        rectangles[3] = new Rectangle(x+(2*SIZE), y, 6*SIZE, 6*SIZE, "BLACK", 9);
    }

    public int getSize()
    {
        return SIZE;
    }

    public double getXPosition()
    {
        return x;
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

    public void setPos(double new_x, double new_y)
    {
        for (Rectangle rectangle : rectangles) {
            rectangle.setXPosition((rectangle.getXPosition()-x)+new_x);
            rectangle.setYPosition((rectangle.getYPosition()-y)+new_y);
        }
        x = new_x;
        y = new_y;
    }
}
