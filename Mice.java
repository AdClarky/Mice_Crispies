import java.util.Random;

public class Mice {
    private int[][] actualLocations = new int[15][2];
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
            do{
                x = rand.nextInt(940);
                y = rand.nextInt(940);
            }while(isLocationUsed(x, y, 0) != null);
            actualLocations[i] = new int[]{x, y};
            mice[i] = new Mouse(x, y);
            mice[i].addTo(gameArena);
        }
    }

    public boolean checkCollision(double x, double y, int size)
    {
        Mouse[] miceHit = {isLocationUsed(x+size, y+size, size)};
                        //   isLocationUsed(x, y, size),};
                        //    isLocationUsed(x, y+size, size),
                        //    isLocationUsed(x+size, y, size)};
        for (Mouse mouse : miceHit) {
            if(mouse != null)
            {
                System.out.println("here");
                mouse.move(1000, 1000);
                return true;
            }
        }

        return false;
    }

    private Mouse isLocationUsed(double x, double y, int size)
    {
        for (Mouse mouse : mice) {
            if(mouse == null)
            {
                continue;
            }
            if((y >= (mouse.getYPosition()) && y <= (mouse.getYPosition() + size) && x >= (mouse.getXPosition()) && x <= (mouse.getXPosition() + size)))
            {
                return mouse;
            }
        }
        return null;
    }
}
