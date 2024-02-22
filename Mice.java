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
            do{
                x = rand.nextInt(940);
                y = rand.nextInt(940);
            }while(isLocationUsed(x, y, 50) != 0);
            mice[i] = new Mouse(x, y);
            mice[i].addTo(gameArena);
        }
    }

    public boolean checkCollision(double x, double y, int size)
    {
        int mouseInd = isLocationUsed(x, y, size);
        if(mice[mouseInd] != null)
        {
            System.out.println("mouse deleted:" + mice[mouseInd].getXPosition() + "," + mice[mouseInd].getYPosition());
            mice[mouseInd].move(1000, 1000);
            mice[mouseInd] = null;
            return true;
        }
        return false;
    }

    private int isLocationUsed(double x, double y, int size)
    {
        for (int i = 0; i < mice.length; i++) {
            if(mice[i] != null &&
            (
                // check top left of mouse
                (mice[i].getXPosition() > x && mice[i].getYPosition() > y && mice[i].getXPosition() < (x+size) && mice[i].getYPosition() < (y+size)) ||
                // check top right of mouse
                (mice[i].getXPosition()+50 < (x+size) && mice[i].getYPosition() > y && mice[i].getXPosition()+50 > x && mice[i].getYPosition() < (y+size)) ||
                // check bottom left of mouse
                (mice[i].getXPosition() > x && mice[i].getYPosition()+50 < (y+size) && mice[i].getXPosition() < (x+size) && mice[i].getYPosition()+50 > y) ||
                //check bottom right of mouse
                (mice[i].getXPosition()+50 < (x+size) && mice[i].getYPosition()+50 < (y+size) && mice[i].getXPosition()+50 > x && mice[i].getYPosition()+50 > y)
            ))
            {
                return i;
            }
        }
        return 0;
    }
}
