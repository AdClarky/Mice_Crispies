public class Main {
    public static void main(String[] args) {
        GameArena arena = new GameArena(1000, 1000);
        
        Rectangle background = new Rectangle(0, 0, 1000, 1000, "WHITE");
        arena.addRectangle(background);

        Mice mice = new Mice(arena, 15);

        Cat cat = new Cat(0, 0);
        cat.addTo(arena);
        

        while(true)
        {
            arena.pause();
            cat.update();
            mice.checkCollision(cat.getXPosition(), cat.getYPosition(), 79);
        }

    }
}
