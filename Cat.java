public class Cat extends GameObject{
    private double y_accel = 0.2;
    private double x_accel = 0;
    private double juice = 100;
    private int score = 0;
    private final Flames flames = new Flames(100, 100);
    private final Tears tears = new Tears(100, 100);

    public Cat(int x, int y)
    {
        super(x, y);

        rectangles = new Rectangle[17];

        rectangles[0] = new Rectangle(x, y, 80, 80, "BLUE", 0); // hitbox
        hitbox =  rectangles[0];

        rectangles[1] = new Rectangle(x+10, y+20, 60, 50, "WHITE", 10);
        rectangles[2] = new Rectangle(x, y+10, 10, 50, "BLACK", 10);
        rectangles[3] = new Rectangle(x+10, y, 10, 10, "BLACK", 10);
        rectangles[4] = new Rectangle(x+10, y+10, 10, 20, "PINK", 10);
        rectangles[5] = new Rectangle(x+10, y+60, 10, 10, "BLACK", 10);
        rectangles[6] = new Rectangle(x+20, y+10, 10, 10, "BLACK", 10);
        rectangles[7] = new Rectangle(x+20, y+40, 10, 10, "BLACK", 10);
        rectangles[8] = new Rectangle(x+20, y+70, 40, 10, "BLACK", 10);
        rectangles[9] = new Rectangle(x+30, y+20, 20, 10, "BLACK", 10);
        rectangles[10] = new Rectangle(x+30, y+50, 20, 10, "PINK", 10);
        rectangles[11] = new Rectangle(x+50, y+10, 10, 10, "BLACK", 10);
        rectangles[12] = new Rectangle(x+50, y+40, 10, 10, "BLACK", 10);
        rectangles[13] = new Rectangle(x+60, y, 10, 10, "BLACK", 10);
        rectangles[14] = new Rectangle(x+60, y+60, 10, 10, "BLACK", 10);
        rectangles[15] = new Rectangle(x+60, y+10, 10, 20, "PINK", 10);
        rectangles[16] = new Rectangle(x+70, y+10, 10, 50, "BLACK", 10);
    }

    public void addTo(GameArena gameArena)
    {
        for (Rectangle rectangle : rectangles)
        {
            gameArena.addRectangle(rectangle);
        }
        tears.addTo(gameArena);
        flames.addTo(gameArena);
    }

    public void died()
    {
        tears.setPosition(x, y);
    }

    public void flameOn()
    {
        flames.setPosition(x, y);
    }

    public void flameOff()
    {           
        flames.setPosition(1000, 1000);
    }

    // right is positive, left is negative
    public double getJuice()
    {
        return juice;
    }

    public void batteryCaptured()
    {
        juice = 100;
    }

    public void scored()
    {
        score++;
    }

    public int getScore()
    {
        return score;
    }

    public void verticalInput()
    {
        if(juice < 1)
        {
            juice = 0;
            flameOff();
            return;
        }
        y_accel -= 1;
        juice -= 2;
    }

    public void horizontalInput(int dir)
    {
        if((x_accel < 10 && dir == 1) || (x_accel > -10 && dir == -1))
        {
            x_accel += dir;
        }
    }

    public void update()
    {
        if(y_accel > -0.2 && y > 969)
        {
            y_accel = 0;
            x_accel /= 1.1;
        }else{
            y_accel += 0.4;
        }
        if(juice < 100)
            juice += 0.25;
        if((y+y_accel+80) > 1050 || (y+y_accel) < 50)
        {
            y_accel = (-y_accel)/3;
        }
        if((x+x_accel+80) > 1000 || (x+x_accel) < 0)
        {
            x_accel = (-x_accel)/2;
        }
        move(x_accel, y_accel);
    }
}
