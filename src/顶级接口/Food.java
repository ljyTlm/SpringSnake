package 顶级接口;

import 游戏主体.Point;

import java.util.Collection;
import java.util.List;

public interface Food {
    Point getData();

    void refresh(Graph graph, Snake snake);

    Boolean isHere(Point point);
}
