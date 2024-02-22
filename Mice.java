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
            }while(isLocationUsed(x, y, 50) != null);
            mice[i] = new Mouse(x, y);
            mice[i].addTo(gameArena);
        }
    }

    public boolean checkCollision(double x, double y, int size)
    {
        Mouse mouse = isLocationUsed(x, y, size);
        if(mouse != null)
        {
            System.out.println("mouse deleted:" + mouse.getXPosition() + "," + mouse.getYPosition());
            mouse.move(1000, 1000);
            return true;
        }
        return false;
    }

    private Mouse isLocationUsed(double x, double y, int size)
    {
        for (Mouse mouse : mice) {
            if(mouse != null &&
            (
                // check top left of mouse
                (mouse.getXPosition() > x && mouse.getYPosition() > y && mouse.getXPosition() < (x+size) && mouse.getYPosition() < (y+size)) ||
                // check top right of mouse
                (mouse.getXPosition()+50 < (x+size) && mouse.getYPosition() > y && mouse.getXPosition()+50 > x && mouse.getYPosition() < (y+size)) ||
                // check bottom left of mouse
                (mouse.getXPosition() > x && mouse.getYPosition()+50 < (y+size) && mouse.getXPosition() < (x+size) && mouse.getYPosition()+50 > y) ||
                //check bottom right of mouse
                (mouse.getXPosition()+50 < (x+size) && mouse.getYPosition()+50 < (y+size) && mouse.getXPosition()+50 > x && mouse.getYPosition()+50 > y)
            ))
            {
                return mouse;
            }
        }
        return null;
    }
}
