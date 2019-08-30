package 游戏主体;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import 顶级接口.Food;
import 顶级接口.Config;
import 顶级接口.Graph;
import 顶级接口.Snake;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

@Component("game")
public class Game {

    public View view;

    @Autowired
    Config config;

    @Autowired
    Graph graph;

    @Autowired
    Snake snake;

    @Autowired
    Food food;

    int score;

    public void startGame() {
        score = 0;
        while (true) {
            int flag = snake.go(graph, food);
            if (flag == 1) {
                score++;
                food.refresh(graph, snake);
            }
            if (flag == 0)
                over();
            view.repaint();
            try {
                Thread.sleep(config.getDifficulty()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void KeyInput(int code) {
        switch (code) {
            case KeyEvent.VK_W:
                snake.upward();
                break;
            case KeyEvent.VK_A:
                snake.left();
                break;
            case KeyEvent.VK_S:
                snake.down();
                break;
            case KeyEvent.VK_D:
                snake.right();
                break;
        }
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Point> getData() {
        ArrayList<Point> data = new ArrayList<>();
        for(int i = 0; i < graph.getData().size(); i ++) {
            data.add(graph.getData().get(i));
        }
        for(int i = 0; i < snake.getData().size(); i ++) {
            data.add(snake.getData().get(i));
        }
        data.add(food.getData());
        return data;
    }

    public void over() {
        System.exit(0);
    }
}
