package GameObjects;
import java.time.Duration;
import java.time.Instant;
import GameArena.Rectangle;
import GameArena.GameArena;

import static GameData.GameSettings.*;

public class Cat extends GameObject{
    private double y_accel = 0.2;
    private double x_accel = 0;
    private double juice = 100;
    private int score = 0;
    private final Flames flames;
    private final Tears tears;
    private Instant beginTime = Instant.now();

    public Cat(int x, int y)
    {
        super(x, y);
        flames = new Flames(100, 100);
        tears = new Tears(1100, 1100);
        rectangles = new Rectangle[17];

        rectangles[0] = new Rectangle(x, y, 8*OBJ_SIZE, 8*OBJ_SIZE, "BLUE", 0); // hitbox
        hitbox =  rectangles[0];

        rectangles[1] = new Rectangle(x+OBJ_SIZE, y+(2*OBJ_SIZE), 6*OBJ_SIZE, 5*OBJ_SIZE, "WHITE", 10);
        rectangles[2] = new Rectangle(x, y+OBJ_SIZE, OBJ_SIZE, (5*OBJ_SIZE), "BLACK", 10);
        rectangles[3] = new Rectangle(x+OBJ_SIZE, y, OBJ_SIZE, OBJ_SIZE, "BLACK", 10);
        rectangles[4] = new Rectangle(x+OBJ_SIZE, y+OBJ_SIZE, OBJ_SIZE, (2*OBJ_SIZE), "PINK", 10);
        rectangles[5] = new Rectangle(x+OBJ_SIZE, y+(6*OBJ_SIZE), OBJ_SIZE, OBJ_SIZE, "BLACK", 10);
        rectangles[6] = new Rectangle(x+(2*OBJ_SIZE), y+OBJ_SIZE, OBJ_SIZE, OBJ_SIZE, "BLACK", 10);
        rectangles[7] = new Rectangle(x+(2*OBJ_SIZE), y+(4*OBJ_SIZE), OBJ_SIZE, OBJ_SIZE, "BLACK", 10);
        rectangles[8] = new Rectangle(x+(2*OBJ_SIZE), y+(7*OBJ_SIZE), (4*OBJ_SIZE), OBJ_SIZE, "BLACK", 10);
        rectangles[9] = new Rectangle(x+(3*OBJ_SIZE), y+(2*OBJ_SIZE), (2*OBJ_SIZE), OBJ_SIZE, "BLACK", 10);
        rectangles[10] = new Rectangle(x+(3*OBJ_SIZE), y+(5*OBJ_SIZE), (2*OBJ_SIZE), OBJ_SIZE, "PINK", 10);
        rectangles[11] = new Rectangle(x+(5*OBJ_SIZE), y+OBJ_SIZE, OBJ_SIZE, OBJ_SIZE, "BLACK", 10);
        rectangles[12] = new Rectangle(x+(5*OBJ_SIZE), y+(4*OBJ_SIZE), OBJ_SIZE, OBJ_SIZE, "BLACK", 10);
        rectangles[13] = new Rectangle(x+(6*OBJ_SIZE), y, OBJ_SIZE, OBJ_SIZE, "BLACK", 10);
        rectangles[14] = new Rectangle(x+(6*OBJ_SIZE), y+(6*OBJ_SIZE), OBJ_SIZE, OBJ_SIZE, "BLACK", 10);
        rectangles[15] = new Rectangle(x+(6*OBJ_SIZE), y+OBJ_SIZE, OBJ_SIZE, (2*OBJ_SIZE), "PINK", 10);
        rectangles[16] = new Rectangle(x+(7*OBJ_SIZE), y+OBJ_SIZE, OBJ_SIZE, (5*OBJ_SIZE), "BLACK", 10);
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
        y_accel -= 30;
        juice -= 2;
    }

    public void horizontalInput(int dir)
    {
        if((x_accel < 1000 && dir == 1) || (x_accel > -1000 && dir == -1))
        {
            x_accel += dir*40;
        }
    }

    public void update()
    {
        double delta = (double) Duration.between(beginTime, Instant.now()).getNano() /1000000000;
        beginTime = Instant.now();
        // if its near enough still (vertically) on the floor
        double juiceIncreaseRate = 0.25;
        if(y_accel > -0.2 && y > 969)
        {
            y_accel = 0;
            x_accel /= 1.1;
            juiceIncreaseRate = 0.75;

        }else{// increases the downwards momentum
            y_accel += 10;
        }
        // increase the juice periodically
        if(juice < 100)
            juice += juiceIncreaseRate;

        // bounce mechanic
        if((y+(y_accel*delta)+8*OBJ_SIZE) > WINDOW_SIZE+HEADER_SIZE || (y+(y_accel*delta)) < HEADER_SIZE)
        {
            y_accel = (-y_accel)/3;
        }
        if(((x+(x_accel*delta))+8*OBJ_SIZE) > WINDOW_SIZE || (x+(x_accel*delta)) < 0)
        {
            x_accel = (-x_accel)/2;
        }
        move(x_accel*delta, y_accel*delta);
    }
}
