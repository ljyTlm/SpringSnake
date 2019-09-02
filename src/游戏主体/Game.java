package 游戏主体;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import 顶级接口.Food;
import 顶级接口.Config;
import 顶级接口.Graph;
import 顶级接口.Snake;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

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

    private int score;

    /**
     * 启动游戏（根据数据刷新视图）
     */
    public void startGame() {
        score = 0;
        while (true) {
            int status = snake.go(graph, food);
            switch (status) {
                case Snake.DEATH:
                    over();
                    break;
                case Snake.PRIZE:
                    score++;
                    food.refresh(graph, snake);
                    break;
                case Snake.SURVIVAL:
                    break;
            }
            view.repaint();
            try {
                Thread.sleep(config.getDifficulty()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 键盘监听 w a s d
     * @param code
     */
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

    /**
     * 获取当前游戏得分 属性要私有化
     * @return
     */
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * 这个方法用来和 视图交互 告诉视图那个坐标画多大范围画什么颜色
     * mvc设计模式 视图只用来渲染 不负责逻辑
     * @return
     */
    public List<Point> getData() {
        List<Point> data = new ArrayList<>();
        List<Point> graphData = graph.getData();
        copyList(data, graphData);
        List<Point> snakeData = snake.getData();
        copyList(data, snakeData);
        data.add(food.getData());
        return data;
    }

    /**
     * 私有辅助方法 用复制数组
     * @param list
     * @param resource
     */
    private void copyList(List list, List resource) {
        for(int i = 0; i < resource.size(); i ++) {
            list.add(resource.get(i));
        }
    }

    /**
     * 游戏结束方法，方便起见 直接整个游戏退出
     */
    public void over() {
        System.exit(0);
    }
}
