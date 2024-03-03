package GameObjects;
import GameArena.Rectangle;
import GameArena.GameArena;
import static GameData.GameSettings.OBJ_SIZE;
public class GameObject {
    protected double x;
    protected double y;
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

    public void setPosition(double new_x, double new_y)
    {
        for(Rectangle rectangle : rectangles)
        {
            rectangle.setXPosition((rectangle.getXPosition()-x)+new_x);
            rectangle.setYPosition((rectangle.getYPosition()-y)+new_y);
        }
        x = new_x;
        y = new_y;
    }
}
