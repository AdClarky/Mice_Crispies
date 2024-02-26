public class LevelData {
    public static boolean level1()
    {
        Level level = new Level("Level 1", 15, 5, 2, 1);
        level.setMousePositions(new int[][]{{950, 0}});
        level.runLevel();
        return level.endGame();
    }

    public static boolean level2()
    {
        Level level = new Level("Level 2", 15, 5, 2, 5);
        level.setMousePositions(new int[][]{{500, 500}});
        level.runLevel();
        return level.endGame();
    }

    public static boolean level3()
    {
        Level level = new Level("Level 3", 15, 5, 2, 10);
        level.setMousePositions(new int[][]{{950, 0}});
        level.runLevel();
        return level.endGame();
    }

    public static boolean level4()
    {
        Level level = new Level("Level 4", 15, 10, 2, 10);
        level.setMousePositions(new int[][]{{950, 0}});
        level.runLevel();
        return level.endGame();
    }

    public static boolean level5()
    {
        Level level = new Level("Level 5", 30, 2, 2, 10);
        level.setMousePositions(new int[][]{{950, 0}});
        level.runLevel();
        return level.endGame();
    }

    public static boolean level6()
    {
        Level level = new Level("Level 6", 10, 10, 2, 15);
        level.setMousePositions(new int[][]{{950, 0}});
        level.runLevel();
        return level.endGame();
    }

    public static boolean level7()
    {
        Level level = new Level("Level 7", 15, 5, 2, 20);
        level.setMousePositions(new int[][]{{950, 0}});
        level.runLevel();
        return level.endGame();
    }

    public static boolean level8()
    {
        Level level = new Level("Level 8", 2, 50, 2, 20);
        level.setMousePositions(new int[][]{{950, 0}});
        level.runLevel();
        return level.endGame();
    }

    public static boolean level9()
    {
        Level level = new Level("Level 9", 50, 2, 2, 30);
        level.setMousePositions(new int[][]{{950, 0}});
        level.runLevel();
        return level.endGame();
    }
}
