import java.util.Random;

public class Mice {
    private final Mouse[] mice;
    private int numMice;

    public Mice(GameArena gameArena, int num_mice)
    {
        int x;
        int y;
        numMice = num_mice;
        mice = new Mouse[numMice];
        Random rand = new Random();
        for(int i = 0; i < numMice; i++)
        {
            x = rand.nextInt(940);
            y = rand.nextInt(940);
            mice[i] = new Mouse(x, y+50, 10);
            mice[i].addTo(gameArena);
        }
    }

    public int getMouseCount()
    {
        return numMice;
    }

    public void setMousePositions(int[][] positions)
    {
        for(int i = 0; i < numMice; i++)
        {
            mice[i].setPosition(positions[i][0], positions[i][1]+50);
        }
    }

    public boolean checkCollision(Rectangle hitbox)
    {
        for (Mouse mouse : mice) {
            if(mouse.hitbox.collides(hitbox))
            {
                mouse.setPosition(1000, 1000);
                return true;
            }
        }
        return false;
    }
}
