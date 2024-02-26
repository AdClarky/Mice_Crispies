import javax.swing.JFrame;

public class LevelsMenu {
    GameArena levelMenu = new GameArena(500, 500);
    
    public LevelsMenu()
    {
        levelMenu.setBackgroundImage("cat.jpeg");
        levelMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void quit()
    {
        levelMenu.exit();
    }

    public void runLevelMenu()
    {
        while(true)
        {
            levelMenu.pause();
        }
    }
}
