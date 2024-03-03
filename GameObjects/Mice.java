package GameObjects;
import java.util.Random;
import GameArena.Rectangle;
import GameArena.GameArena;
import static GameData.GameSettings.OBJ_SIZE;

public class Mice {
    private final Mouse[] mice;
    private final int numMice;

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
            mice[i] = new Mouse(x, y+50);
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
