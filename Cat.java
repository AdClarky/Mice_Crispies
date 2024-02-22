public class Cat {
    private double x = 0;
    private double y = 0;
    private double y_accel = 0;
    private double x_accel = 0;
    Rectangle[] rectangles = new Rectangle[16];

    public Cat(int starting_x, int starting_y)
    {
        this.x = starting_x;
        this.y = starting_y;

        rectangles[0] = new Rectangle(x+10, y+20, 60, 50, "WHITE");
        rectangles[1] = new Rectangle(x, y+10, 10, 50, "BLACK");
        rectangles[2] = new Rectangle(x+10, y, 10, 10, "BLACK");
        rectangles[3] = new Rectangle(x+10, y+10, 10, 20, "PINK");
        rectangles[4] = new Rectangle(x+10, y+60, 10, 10, "BLACK");
        rectangles[5] = new Rectangle(x+20, y+10, 10, 10, "BLACK");
        rectangles[6] = new Rectangle(x+20, y+40, 10, 10, "BLACK");
        rectangles[7] = new Rectangle(x+20, y+70, 40, 10, "BLACK");
        rectangles[8] = new Rectangle(x+30, y+20, 20, 10, "BLACK");
        rectangles[9] = new Rectangle(x+30, y+50, 20, 10, "PINK");
        rectangles[10] = new Rectangle(x+50, y+10, 10, 10, "BLACK");
        rectangles[11] = new Rectangle(x+50, y+40, 10, 10, "BLACK");
        rectangles[12] = new Rectangle(x+60, y, 10, 10, "BLACK");
        rectangles[13] = new Rectangle(x+60, y+60, 10, 10, "BLACK");
        rectangles[14] = new Rectangle(x+60, y+10, 10, 20, "PINK");
        rectangles[15] = new Rectangle(x+70, y+10, 10, 50, "BLACK");
    }


    public void addTo(GameArena gameArena){
        for (Rectangle rectangle : rectangles) {
            gameArena.addRectangle(rectangle);
        }
    }

    // right is positive, left is negative
    public void horizontalInput(int dir)
    {
        x_accel += dir * 5;
    }

    public void verticalInput()
    {
        y_accel += 10;
    }

    public void move()
    {
        if((y+y_accel+80) > 1000 || (y+y_accel) < 0)
        {
            y_accel = (-y_accel)/2;
        }
        if((x+x_accel+80) > 1000 || (x+x_accel) < 0)
        {
            x_accel = (-x_accel)/2;
        }
        y += y_accel;
        x += x_accel;
        for (Rectangle rectangle : rectangles) {
            rectangle.setXPosition(rectangle.getXPosition()+(x_accel));
            rectangle.setYPosition(rectangle.getYPosition()+(y_accel));
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

    public void update()
    {
        y_accel += 0.1;
        move();
    }
}
