public class GameObject {
    protected double x;
    protected double y;

    protected double y_accel = 0;
    protected double x_accel = 0;
    protected Rectangle[] rectangles;

    public Rectangle hitbox;

    public GameObject(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void addTo(GameArena gameArena)
    {
        for(Rectangle rectangle : rectangles)
        {
            gameArena.addRectangle(rectangle);
        }
    }

    /*
    increase/decrease the x position by dx,dy
     */
    public void move(double dx, double dy)
    {
        for(Rectangle rectangle : rectangles)
        {
            rectangle.setXPosition(rectangle.getXPosition()+dx);
            rectangle.setYPosition(rectangle.getYPosition()+dy);
        }
        x += dx;
        y += dy;
    }
}
