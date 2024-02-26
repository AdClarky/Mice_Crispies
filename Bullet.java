public class Bullet {
    private double x;
    private double y;
    private int size = 5;
    private final Rectangle[] rectangles = new Rectangle[3];
    public Rectangle hitbox;

    public Bullet(int starting_x, int starting_y, int size_input)
    {
        x = starting_x;
        y = starting_y;
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
