import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {

    Player player;
    Enemy enemy;
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    Enemy[][] enemies = new Enemy[5][10];
    Timer timer;
    Long timeDelay;
    Game game;
    Long bulletDelay;

    public Board(Game game){
        this.game = game;
        setPreferredSize(new Dimension( 1000, 750));
        setBackground(Color.BLACK);
        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void setup(){
        player = new Player(this);

        for(int row = 0; row<5; row++){
            for(int col = 0; col<10; col++){
                enemies[row][col] = new Enemy((getWidth()/4) + col*50, row*50);
            }
        }

        timeDelay = System.currentTimeMillis();
        bulletDelay = System.currentTimeMillis();
    }

    public void checkCollisions(){

        for(int i = bullets.size() -1; i>= 0; i--){
            for(int j = 0; j<enemies.length; j++){
                for(int k = 0; k<enemies[0].length; k++) {
                    if(enemies[j][k] != null){
                        if (bullets.get(i).getBounds().intersects(enemies[j][k].getBounds())){
                            bullets.get(i).setRemove();
                            enemies[j][k] = null;
                            break;
                        }
                    }

                }
            }

            if(bullets.get(i).getRemove()){
                bullets.remove(bullets.get(i));
            }
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //player.moveLeft();
        long currentTime = System.currentTimeMillis();
        checkCollisions();

        if(game.isSpacePressed() == true && currentTime - bulletDelay>=250){
            bullets.add(new Bullet(player));
            bulletDelay = System.currentTimeMillis();
        }

        if(game.isLeftPressed() == true && player.getX() > 0){
            player.moveLeft();
        }
        if(game.isRightPressed() == true && player.getX() < (this.getWidth() - player.getWIDTH())){
            player.moveRight();
        }


        for(Bullet bullet: bullets){
            bullet.move();
        }

        for(int i = bullets.size()-1; i >= 0; i--){
            if(bullets.get(i).getY()  < 0){
                bullets.remove(bullets.get(i));
            }
            else
                bullets.get(i).move();
        }


        if(System.currentTimeMillis() - timeDelay >= 1000){
            for(int row = 0; row<5; row++){
                for(int col = 0; col<10; col++){
                    if(enemies[row][col] != null){
                        enemies[row][col].move();
                    }
                }
            }
            timeDelay = System.currentTimeMillis();
        }


        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.paint(g);

        for(int row = 0; row<5; row++){
            for(int col = 0; col<10; col++){
               if (enemies[row][col] != null){
                   enemies[row][col].paint(g);
               }
            }
        }
        for(Bullet bullet: bullets){
            bullet.paint(g);
        }
    }

}
