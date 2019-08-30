package 普通模式;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import 游戏主体.Point;
import 顶级接口.Config;
import 顶级接口.Graph;

import java.util.ArrayList;
import java.util.List;

@Component("graph")
public class GraphImpl implements Graph {

    @Autowired
    Config config;

    List<Point> data;

    GraphImpl() {
        data = new ArrayList<>();
    }

    @Override
    public Boolean isObstacle(Point point) {
        if (point.x >= 0 &&
                point.x <= config.getWidth()-config.getEdge() &&
                point.y >= 0 &&
                point.y <= config.getHeight()-config.getEdge()) return false;
        return true;
    }

    @Override
    public List<Point> getData() {
        return data;
    }
}
