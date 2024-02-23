import java.util.Random;

public class Bullets {
    private final Bullet[] bullets;
    private static final double bullet_velocity = 0.5;

    public Bullets(GameArena gameArena, int numBullets)
    {
        bullets = new Bullet[numBullets];
        Random rand = new Random();
        for(int i = 0; i < numBullets; i++)
        {
            int y = rand.nextInt(950);
            bullets[i] = new Bullet(1000, y);
            bullets[i].addTo(gameArena);
        }
    }

    public void updateBullets()
    {
        for (Bullet bullet : bullets)
        {
            bullet.move(bullet_velocity, 0);
        }
    }

    public boolean checkCollision(Rectangle hitbox)
    {
        for(Bullet bullet : bullets){
            if(bullet.hitbox.collides(hitbox))
            {
                System.out.println("game over");
                return true;
            }
        }
        return false;
    }
}
