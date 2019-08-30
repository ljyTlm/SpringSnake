package 顶级接口;


import 游戏主体.Point;

import java.util.Collection;
import java.util.List;

public interface Graph {

    Boolean isObstacle(Point point);

    List<Point> getData();
}
