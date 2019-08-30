package 普通模式;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import 游戏主体.Point;
import 顶级接口.Food;
import 顶级接口.Graph;
import 顶级接口.Config;
import 顶级接口.Snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component("snake")
public class SnakeImpl implements Snake {

    @Autowired
    Config config;

    ArrayList<Point> data;

    int direction; //3左 1右 2上 4下

    SnakeImpl() {
        direction = Snake.RIGHT;
        }

    @Override
    public List<Point> getData() {
        if (data == null) {
            data = new ArrayList<>();
            data.add(new Point(0, 0, config.getEdge(), config.getEdge(), Color.BLUE));
        }
        return data;
    }

    @Override
    public int go(Graph graph, Food food) {
        List<Point> data = getData();
        Point head = data.get(data.size()-1);
        Point newHead = null;
        switch (direction) {
            case Snake.RIGHT:
                newHead = new Point(head.x+ config.getEdge(), head.y, head.w, head.h, head.color);
                break;
            case Snake.UP:
                newHead = new Point(head.x, head.y- config.getEdge(), head.w, head.h, head.color);
                break;
            case Snake.LEFT:
                newHead = new Point(head.x- config.getEdge(), head.y, head.w, head.h, head.color);
                break;
            case Snake.DOWN:
                newHead = new Point(head.x, head.y+ config.getEdge(), head.w, head.h, head.color);
                break;
        }
        if (food.isHere(newHead)) {
            data.add(newHead);
            return 1;
        }
        if (isObstacle(newHead, 1, data.size()-1) || graph.isObstacle(newHead)) {
            return 0;
        }
        data.remove(0);
        data.add(newHead);
        return 2;
    }

    @Override
    public Boolean isObstacle(Point point) {
        return isObstacle(point, 0, data.size());
    }

    @Override
    public void upward() {
        if (direction == Snake.DOWN) return;
        direction = Snake.UP;
    }

    @Override
    public void left() {
        if (direction == Snake.RIGHT) return;
        direction = Snake.LEFT;
    }

    @Override
    public void down() {
        if (direction == Snake.UP) return;
        direction = Snake.DOWN;
    }

    @Override
    public void right() {
        if (direction == Snake.LEFT) return;
        direction = Snake.RIGHT;
    }

    private Boolean isObstacle(Point point, int s, int e) {
        for(int i = s; i < e; i ++) {
            if (point.equals(data.get(i))) return true;
        }
        return false;
    }
}
