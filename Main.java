public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
        Level level1 = new Level("Level 1", 1, 100);
        menu.quit();
        level1.runLevel();
        level1.endGame();
        menu.runMenu();
    }
}
