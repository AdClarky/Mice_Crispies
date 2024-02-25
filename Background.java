public class Background {
    private final static int sizeOfRects = 50;
    private Rectangle[] rectangles = new Rectangle[(1000/sizeOfRects)*(1000/sizeOfRects)];

    public Background()
    {
        String lastStartignColour = "GREY";
        String nextColour = "WHITE";
        int count = 0;
        for(int i = 0; i < 1000/sizeOfRects; i++)
        {
            if(lastStartignColour.equals("GREY"))
            {
                lastStartignColour = "WHITE";
                nextColour = "GREY";
            }else{
                lastStartignColour = "GREY";
                nextColour = "WHITE";
            }
            for(int j = 0; j < 1000/sizeOfRects; j++)
            {
                if(nextColour.equals("WHITE")){
                    nextColour = "GREY";
                }
                else{
                    nextColour = "WHITE";
                }

                rectangles[count] = new Rectangle(j*sizeOfRects, i*sizeOfRects, sizeOfRects, sizeOfRects, nextColour, 1);
                count++;
            }
        }
        System.out.println(count);;
    }

    public void addTo(GameArena gameArena)
    {
        for (Rectangle rectangle : rectangles) {
            gameArena.addRectangle(rectangle);
        }
    }
}
