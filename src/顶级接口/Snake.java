package 顶级接口;

import 游戏主体.Point;

import java.util.Collection;
import java.util.List;

public interface Snake {
    //3左 1右 2上 4下
    int RIGHT = 1;

    int UP = 2;

    int LEFT = 3;

    int DOWN = 4;

    List<Point> getData();

    int go(Graph g, Food f);

    Boolean isObstacle(Point data);

    void upward();

    void left();

    void down();

    void right();
}
