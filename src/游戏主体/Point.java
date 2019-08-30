package 游戏主体;

import java.awt.*;

public class Point {
    public int x;
    public int y;
    public int w;
    public int h;
    public Color color;

    public Point(int x, int y, int w, int h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        Point point = (Point)obj;
        if (point.x == x && point.y == y) return true;
        return false;
    }
}
