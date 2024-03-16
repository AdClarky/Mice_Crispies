package GameObjects;
import GameArena.Rectangle;
import GameArena.GameArena;
import GameData.GameSettings;

import static GameData.GameSettings.RECT_WIDTH_COUNT;
import static GameData.GameSettings.WINDOW_SIZE;
import static GameData.GameSettings.HEADER_SIZE;
import static GameData.GameSettings.COLOUR_1;
import static GameData.GameSettings.COLOUR_2;
public class Background {
    private final Rectangle[] rectangles = new Rectangle[RECT_WIDTH_COUNT*RECT_WIDTH_COUNT];
    public Background()
    {
        String lastStartingColour = COLOUR_2;
        String nextColour;
        int count = 0;
        for(int i = 0; i < RECT_WIDTH_COUNT; i++)
        {
            if(lastStartingColour.equals(COLOUR_2))
            {
                lastStartingColour = COLOUR_1;
                nextColour = COLOUR_2;
            }else{
                lastStartingColour = COLOUR_2;
                nextColour = COLOUR_1;
            }
            for(int j = 0; j < RECT_WIDTH_COUNT; j++)
            {
                if(nextColour.equals(COLOUR_1)){
                    nextColour = COLOUR_2;
                }
                else{
                    nextColour = COLOUR_1;
                }
                rectangles[count++] = new Rectangle(j * ((double) WINDOW_SIZE / RECT_WIDTH_COUNT) , i * ((double) WINDOW_SIZE / RECT_WIDTH_COUNT) + HEADER_SIZE , (double) WINDOW_SIZE / RECT_WIDTH_COUNT, (double) WINDOW_SIZE / RECT_WIDTH_COUNT ,nextColour, 1);
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
