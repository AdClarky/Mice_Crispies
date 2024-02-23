public class Mouse {
    private double x;
    private double y;
    private final Rectangle[] rectangles = new Rectangle[6];
    public Rectangle hitbox;

    public Mouse(int starting_x, int starting_y)
    {
        this.x = starting_x;
        this.y = starting_y;

        rectangles[0] = new Rectangle(x, y, 50, 50, "WHITE", 0);
        hitbox =  rectangles[0];

        rectangles[1] = new Rectangle(x, y, 20, 20, "BLACK", 8);
        rectangles[2] = new Rectangle(x+30, y, 20, 20, "BLACK", 8);
        rectangles[3] = new Rectangle(x+10, y+10, 30, 40, "BLACK", 8);
        rectangles[4] = new Rectangle(x+10, y+20, 10, 10, "RED", 8);
        rectangles[5] = new Rectangle(x+30, y+20, 10, 10, "RED", 8);
    }

    public void addTo(GameArena gameArena){
        for (Rectangle rectangle : rectangles) {
            gameArena.addRectangle(rectangle);
        }
    }

    public double getXPosition()
    {
        return x;
    }

    public double getYPosition()
    {
        return y;
    }

    public void move(int newX, int newY)
    {
        for (Rectangle rectangle : rectangles) {
            rectangle.setXPosition((rectangle.getXPosition()-x)+newX);
            rectangle.setYPosition((rectangle.getYPosition()-y)+newY);
        }
        x = newX;
        y = newY;
    }
}
