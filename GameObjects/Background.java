package GameObjects;
import GameArena.Rectangle;
import GameArena.GameArena;
import static GameData.GameSettings.RECT_SIZE;
import static GameData.GameSettings.WINDOW_SIZE;
import static GameData.GameSettings.COLOUR_1;
import static GameData.GameSettings.COLOUR_2;
public class Background {
    private final Rectangle[] rectangles = new Rectangle[(WINDOW_SIZE/ RECT_SIZE)*(WINDOW_SIZE/ RECT_SIZE)];
    public Background()
    {
        String lastStartingColour = COLOUR_2;
        String nextColour;
        int count = 0;
        for(int i = 0; i < 1000/ RECT_SIZE; i++)
        {
            if(lastStartingColour.equals(COLOUR_2))
            {
                lastStartingColour = COLOUR_1;
                nextColour = COLOUR_2;
            }else{
                lastStartingColour = COLOUR_2;
                nextColour = COLOUR_1;
            }
            for(int j = 0; j < 1000/ RECT_SIZE; j++)
            {
                if(nextColour.equals(COLOUR_1)){
                    nextColour = COLOUR_2;
                }
                else{
                    nextColour = COLOUR_1;
                }

                rectangles[count] = new Rectangle(j* RECT_SIZE, (i* RECT_SIZE)+50, RECT_SIZE, RECT_SIZE, nextColour, 1);
                count++;
            }
        }
    }

    public void addTo(GameArena gameArena)
    {
        for (Rectangle rectangle : rectangles) {
            gameArena.addRectangle(rectangle);
        }
    }
}
