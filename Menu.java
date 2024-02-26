import javax.swing.JFrame;

public class Menu {
    GameArena menu = new GameArena(1000, 1000);
    Cat cat = new Cat(0, 0);
    
    public Menu()
    {
        menu.setBackgroundImage("cat.jpeg");
        menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cat.addTo(menu);
    }
    
    public void quit()
    {
        menu.exit();
    }

    public void runMenu()
    {
        while(true)
        {
            cat.update();
            menu.pause();
            if(menu.leftMousePressed())
            {
                break;
            }
        }
    }
}
