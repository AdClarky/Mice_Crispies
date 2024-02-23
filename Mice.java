import java.util.Random;

public class Mice {
    private Mouse[] mice;
    private Random rand = new Random();

    public Mice(GameArena gameArena, int numMice)
    {
        int x;
        int y;
        if(numMice > 15)
        {
            numMice = 15;
        }
        mice = new Mouse[numMice];
        for(int i = 0; i < numMice; i++)
        {
            x = rand.nextInt(940);
            y = rand.nextInt(940);
            mice[i] = new Mouse(x, y);
            mice[i].addTo(gameArena);
        }
    }

    public boolean checkCollision(Rectangle hitbox)
    {
        for (Mouse mouse : mice) {
            if(mouse.hitbox.collides(hitbox))
            {
                System.out.println("mouse deleted:" + mouse.getXPosition() + "," + mouse.getYPosition());
                mouse.move(1000, 1000);
                return true;
            }
        }
        return false;
    }
}
