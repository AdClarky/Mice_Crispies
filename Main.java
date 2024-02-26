public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
    }

    public static void level1()
    {
        Level level1 = new Level("Level 1", 15, 5, 2, 1);
        level1.setMousePositions(new int[][]{{950, 0}});
        level1.runLevel();
        level1.endGame();
    }
}
