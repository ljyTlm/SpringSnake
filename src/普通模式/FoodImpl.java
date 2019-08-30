package 普通模式;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import 游戏主体.Point;
import 顶级接口.Food;
import 顶级接口.Graph;
import 顶级接口.Config;
import 顶级接口.Snake;

import java.awt.*;


@Component("food")
public class FoodImpl implements Food {

    @Autowired
    Config config;

    Point data;

    @Override
    public Point getData() {
        if (data == null) {
            data = new Point(90,90, config.getEdge(), config.getEdge(), Color.RED);
        }
        return data;
    }

    @Override
    public void refresh(Graph graph, Snake snake) {
        Point data = getData();
        int f = 0;
        do {
            f = 0;
            data.x = (int)(Math.random()*20)* config.getEdge();
            data.y = (int)(Math.random()*20)* config.getEdge();
            if (graph.isObstacle(data)) f = 1;
            if (snake.isObstacle(data)) f = 1;
        } while (f == 1);
    }

    @Override
    public Boolean isHere(Point point) {
        return getData().equals(point);
    }
}
