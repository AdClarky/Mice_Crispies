import java.util.Random;

public class Bullets {
    private final Bullet[] bullets;
    private double bullet_velocity = -1;

    public Bullets(GameArena gameArena, int numBullets)
    {
        bullets = new Bullet[numBullets];
        Random rand = new Random();
        for(int i = 0; i < numBullets; i++)
        {
            int y = rand.nextInt(950);
            int x = rand.nextInt(1000);
            bullets[i] = new Bullet(x+1000, y);
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

    public void increaseBulletSpeed(double dx)
    {
        bullet_velocity -= dx;
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
