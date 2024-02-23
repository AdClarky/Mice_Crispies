import engine.GameArena;
import engine.Rectangle;

public class Cat {
    private double x;
    private double y;
    private double y_accel = 0.2;
    private double x_accel = 0;
    private double juice = 100;
    private int score = 0;
    private final Rectangle[] rectangles = new Rectangle[17];
    private final Rectangle[] flames = new Rectangle[12];

    private final Rectangle[] tears = new Rectangle[2];
    public Rectangle hitbox;

    public Cat(int starting_x, int starting_y)
    {
        x = starting_x;
        y = starting_y;

        rectangles[0] = new Rectangle(x, y, 80, 80, "WHITE", 0); // hitbox
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


        flames[0] = new Rectangle(x+30, y+80, 20, 10, "WHITE", 10);
        flames[1] = new Rectangle(x+20, y+80, 10, 10, "YELLOW", 10);
        flames[2] = new Rectangle(x+50, y+80, 10, 10, "YELLOW", 10);
        flames[3] = new Rectangle(x+30, y+90, 20, 10, "YELLOW", 10);
        flames[4] = new Rectangle(x+20, y+90, 10, 20, "ORANGE", 10);
        flames[5] = new Rectangle(x+30, y+100, 20, 10, "ORANGE", 10);
        flames[6] = new Rectangle(x+50, y+90, 10, 10, "ORANGE", 10);
        flames[7] = new Rectangle(x+20, y+100, 10, 20, "RED", 10);
        flames[8] = new Rectangle(x+30, y+110, 30, 10, "RED", 10);
        flames[9] = new Rectangle(x+50, y+100, 10, 20, "RED", 10);
        flames[10] = new Rectangle(x+10, y+70, 10, 30, "RED", 10);
        flames[11] = new Rectangle(x+60, y+70, 10, 40, "RED", 10);

        tears[0] = new Rectangle(x+20, y+50, 10, 20, "BLUE", 10);
        tears[1] = new Rectangle(x+50, y+50, 10, 20, "BLUE", 10);
    }


    public void addTo(GameArena gameArena){
        gameArena.addRectangle(hitbox);
        for (Rectangle rectangle : rectangles) {
            gameArena.addRectangle(rectangle);
        }
        for (Rectangle rectangle : flames) {
            gameArena.addRectangle(rectangle);
        }
        for (Rectangle rectangle : tears){
            gameArena.addRectangle(rectangle);
        }
    }

    public void died()
    {
        tears[0].setXPosition(x+20);
        tears[0].setYPosition(y+50);
        tears[1].setXPosition(x+50);
        tears[1].setYPosition(y+50);
    }

    public void flameOn()
    {
        flames[0].setXPosition(x+30);
        flames[0].setYPosition(y+80);
        
        flames[1].setXPosition(x+20);
        flames[1].setYPosition(y+80);
        
        flames[2].setXPosition(x+50);
        flames[2].setYPosition(y+80);
        
        flames[3].setXPosition(x+30);
        flames[3].setYPosition(y+90);
        
        flames[4].setXPosition(x+20);
        flames[4].setYPosition(y+90);
        
        flames[5].setXPosition(x+30);
        flames[5].setYPosition(y+100);
        
        flames[6].setXPosition(x+50);
        flames[6].setYPosition(y+90);
        
        flames[7].setXPosition(x+20);
        flames[7].setYPosition(y+100);
        
        flames[8].setXPosition(x+30);
        flames[8].setYPosition(y+110);
        
        flames[9].setXPosition(x+50);
        flames[9].setYPosition(y+100);
        
        flames[10].setXPosition(x+10);
        flames[10].setYPosition(y+70);
        
        flames[11].setXPosition(x+60);
        flames[11].setYPosition(y+70);
    }

    public void flameOff()
    {           
        for (Rectangle rectangle : flames) {
            rectangle.setXPosition(1000);
        }
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

    public void move()
    {
        if((y+y_accel+80) > 1000 || (y+y_accel) < 0)
        {
            y_accel = (-y_accel)/3;
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

    public void update()
    {
        if(y_accel > -0.2 && y > 919)
        {
            y_accel = 0;
            x_accel += 0.2 * -(x_accel/Math.abs(x_accel));
        }else{
            y_accel += 0.4;
        }
        if(juice < 100)
            juice += 0.25;
        move();
    }
}
