import javax.swing.JFrame;

public class Menu {
    GameArena menu = new GameArena(1000, 1000);
    Text playText = new Text("PLAY", 50, 5, 700, "WHITE");
    Text levelsText = new Text("LEVELS", 50, 5, 750, "WHITE");
    Text exitText = new Text("EXIT", 50, 5, 800, "WHITE");
    
    public Menu()
    {
        menu.setBackgroundImage("catTitle.jpeg");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.addText(playText);
        menu.addText(levelsText);
        menu.addText(exitText);
    }
    
    public void quit()
    {
        menu.exit();
    }

    private void playClicked()
    {
        Main.level1();
    }

    private void levelsClicked()
    {
        LevelsMenu levels = new LevelsMenu();
        levels.runLevelMenu();
    }

    private void exitClicked()
    {
        menu.exit();
    }


    public void runMenu()
    {
        while(true)
        {
            menu.pause();
            if(menu.getMousePositionX() > 5 && menu.getMousePositionX() < 137 && menu.getMousePositionY() > 650 && menu.getMousePositionY() < 700)
            {
                if(menu.leftMousePressed())
                {
                    playClicked();
                }
                playText.setColour("RED");
                levelsText.setColour("WHITE");
                exitText.setColour("WHITE");
            }else if(menu.getMousePositionX() > 5 && menu.getMousePositionX() < 195 && menu.getMousePositionY() > 700 && menu.getMousePositionY() < 750)
            {                
                if(menu.leftMousePressed())
                {
                    levelsClicked();
                }
                playText.setColour("WHITE");
                levelsText.setColour("RED");
                exitText.setColour("WHITE");
            }else if(menu.getMousePositionX() > 5 && menu.getMousePositionX() < 118 && menu.getMousePositionY() > 750 && menu.getMousePositionY() < 800)
            {
                if(menu.leftMousePressed())
                {
                    exitClicked();
                }
                playText.setColour("WHITE");
                levelsText.setColour("WHITE");
                exitText.setColour("RED");
            }else
            {
                playText.setColour("WHITE");
                levelsText.setColour("WHITE");
                exitText.setColour("WHITe");
            }
        }
    }
}
