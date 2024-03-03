import javax.swing.JFrame;
import GameArena.Text;
import GameArena.GameArena;
import GameData.LevelData;

public class LevelsMenu {
    GameArena levelMenu = new GameArena(500, 500);
    Text leftText = new Text("<", 50, 160, 100, "WHITE");
    int currentLevel = 1;
    Text currentLevelText = new Text(""+currentLevel, 40, 237, 95, "WHITE");
    Text rightText = new Text(">", 50, 298, 100, "WHITE");
    
    public LevelsMenu()
    {
        levelMenu.setBackgroundImage("cat.jpeg");
        levelMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        levelMenu.addText(leftText);
        levelMenu.addText(rightText);
        levelMenu.addText(currentLevelText);
    }
    
    public void quit()
    {
        levelMenu.exit();
    }

    private void leftClicked()
    {
        if(currentLevel > 1)
        {
            currentLevel--;
        }
        currentLevelText.setText(""+currentLevel);
    }

    private void rightClicked()
    {
        if(currentLevel < 9)
        {
            currentLevel++;
        }
        currentLevelText.setText(""+currentLevel);
    }

    public void levelClicked()
    {
        switch(currentLevel)
        {
            case 1:
                LevelData.level1();
                break;
            case 2:
                LevelData.level2();
                break;
            case 3:
                LevelData.level3();
                break;
            case 4:
                LevelData.level4();
                break;
            case 5:
                LevelData.level5();
                break;
            case 6:
                LevelData.level6();
                break;
            case 7:
                LevelData.level7();
                break;
            case 8:
                LevelData.level8();
                break;
            case 9:
                LevelData.level9();
                break;
        }
    }

    public void runLevelMenu()
    {
        while(true)
        {
            levelMenu.pause();
            if(levelMenu.getMousePositionX() > 168 && levelMenu.getMousePositionX() < 185 && levelMenu.getMousePositionY() > 67 && levelMenu.getMousePositionY() < 93)
            {
                if(levelMenu.leftMousePressed())
                {
                    leftClicked();
                    levelMenu.pause(50);
                }
                leftText.setColour("RED");
                rightText.setColour("WHITE");
                currentLevelText.setColour("WHITE");
            }else if(levelMenu.getMousePositionX() > 300 && levelMenu.getMousePositionX() < 326 && levelMenu.getMousePositionY() > 67 && levelMenu.getMousePositionY() < 93)
            {                
                if(levelMenu.leftMousePressed())
                {
                    rightClicked();
                    levelMenu.pause(50);
                }
                leftText.setColour("WHITE");
                rightText.setColour("RED");
                currentLevelText.setColour("WHITE");
            }else if(levelMenu.getMousePositionX() > 185 && levelMenu.getMousePositionX() < 300 && levelMenu.getMousePositionY() > 67 && levelMenu.getMousePositionY() < 93)
            {                
                if(levelMenu.leftMousePressed())
                {
                    levelClicked();
                    levelMenu.pause(50);
                }
                leftText.setColour("WHITE");
                rightText.setColour("WHITE");
                currentLevelText.setColour("RED");
            }else
            {
                leftText.setColour("WHITE");
                rightText.setColour("WHITE");
                currentLevelText.setColour("WHITE");
            }
        }
    }
}
