import java.awt.*;

public class Enemy {

    int x,y,diam = 30;
    int speed, dx, dy = 5;
    int numEnemies = 50;

    public Enemy(){
        x=50;
        y=50;
    }

    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(x,y,diam,diam);
    }

    public int getNumEnemies() {
        return numEnemies;
    }

    public void move(){
        y+=dy;
    }
}
