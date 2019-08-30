package 游戏主体;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class View extends JFrame implements KeyListener{

    Game game;

    public View(Game game) {
        super();
        this.game = game;
        setSize(game.config.getWidth(), game.config.getHeight());
        addKeyListener(this);
        add(new MyPanel());
        setVisible(true);
    }

    public void init(Game game) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        game.KeyInput(e.getKeyCode());
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            System.out.println("我被调用了");
            Graphics2D g2d = (Graphics2D)g;
            g2d.setFont(new Font("幼圆",0,30));
            g2d.drawString("您的得分是：" + game.getScore() + "分", Font.BOLD, 570);
            ArrayList<Point> data = game.getData();
            for(int i = 0 ; i < data.size() ; i++) {
                Point point = data.get(i);
                g2d.setColor(point.color);
                g2d.fillRect(point.x,point.y,point.w,point.h);
            }
        }
    }
}
