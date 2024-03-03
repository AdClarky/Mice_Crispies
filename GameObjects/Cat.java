package GameObjects;
import java.time.Duration;
import java.time.Instant;
import GameArena.Rectangle;
import GameArena.GameArena;

public class Cat extends GameObject{
    private double y_accel = 0.2;
    private double x_accel = 0;
    private double juice = 100;
    private int score = 0;
    private final Flames flames;
    private final Tears tears;
    private Instant beginTime = Instant.now();

    public Cat(int x, int y, double scaleMultiplier)
    {
        super(x, y, scaleMultiplier);
        flames = new Flames(100, 100, scaleMultiplier);
        tears = new Tears(1100, 1100, scaleMultiplier);
        rectangles = new Rectangle[17];

        rectangles[0] = new Rectangle(x, y, 8*scaleMultiplier, 8*scaleMultiplier, "BLUE", 0); // hitbox
        hitbox =  rectangles[0];

        rectangles[1] = new Rectangle(x+scaleMultiplier, y+(2*scaleMultiplier), 6*scaleMultiplier, 5*scaleMultiplier, "WHITE", 10);
        rectangles[2] = new Rectangle(x, y+scaleMultiplier, scaleMultiplier, (5*scaleMultiplier), "BLACK", 10);
        rectangles[3] = new Rectangle(x+scaleMultiplier, y, scaleMultiplier, scaleMultiplier, "BLACK", 10);
        rectangles[4] = new Rectangle(x+scaleMultiplier, y+scaleMultiplier, scaleMultiplier, (2*scaleMultiplier), "PINK", 10);
        rectangles[5] = new Rectangle(x+scaleMultiplier, y+(6*scaleMultiplier), scaleMultiplier, scaleMultiplier, "BLACK", 10);
        rectangles[6] = new Rectangle(x+(2*scaleMultiplier), y+scaleMultiplier, scaleMultiplier, scaleMultiplier, "BLACK", 10);
        rectangles[7] = new Rectangle(x+(2*scaleMultiplier), y+(4*scaleMultiplier), scaleMultiplier, scaleMultiplier, "BLACK", 10);
        rectangles[8] = new Rectangle(x+(2*scaleMultiplier), y+(7*scaleMultiplier), (4*scaleMultiplier), scaleMultiplier, "BLACK", 10);
        rectangles[9] = new Rectangle(x+(3*scaleMultiplier), y+(2*scaleMultiplier), (2*scaleMultiplier), scaleMultiplier, "BLACK", 10);
        rectangles[10] = new Rectangle(x+(3*scaleMultiplier), y+(5*scaleMultiplier), (2*scaleMultiplier), scaleMultiplier, "PINK", 10);
        rectangles[11] = new Rectangle(x+(5*scaleMultiplier), y+scaleMultiplier, scaleMultiplier, scaleMultiplier, "BLACK", 10);
        rectangles[12] = new Rectangle(x+(5*scaleMultiplier), y+(4*scaleMultiplier), scaleMultiplier, scaleMultiplier, "BLACK", 10);
        rectangles[13] = new Rectangle(x+(6*scaleMultiplier), y, scaleMultiplier, scaleMultiplier, "BLACK", 10);
        rectangles[14] = new Rectangle(x+(6*scaleMultiplier), y+(6*scaleMultiplier), scaleMultiplier, scaleMultiplier, "BLACK", 10);
        rectangles[15] = new Rectangle(x+(6*scaleMultiplier), y+scaleMultiplier, scaleMultiplier, (2*scaleMultiplier), "PINK", 10);
        rectangles[16] = new Rectangle(x+(7*scaleMultiplier), y+scaleMultiplier, scaleMultiplier, (5*scaleMultiplier), "BLACK", 10);
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
        if(y_accel > -0.2 && y > 969)
        {
            System.out.println(y_accel);
            y_accel = 0;
            x_accel /= 1.1;
        }else{// increases the downwards momentum
            y_accel += 10;
        }
        // increase the juice periodically
        if(juice < 100)
            juice += 0.25;

        // bounce mechanic
        if((y+(y_accel*delta)+80) > 1050 || (y+(y_accel*delta)) < 50)
        {
            y_accel = (-y_accel)/3;
        }
        if(((x+(x_accel*delta))+80) > 1000 || (x+(x_accel*delta)) < 0)
        {
            x_accel = (-x_accel)/2;
        }
        move(x_accel*delta, y_accel*delta);
    }
}
