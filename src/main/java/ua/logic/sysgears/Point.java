package ua.logic.sysgears;

/*
Задание:
Имеется n произвольных точек на проскости. Необходимо объединить все точки одной ломаной линией таким образом,
 чтобы она не имела самопересечений.

Входные данные:
Список из произвольных координат точек на плоскости.

Выходные данные:
Упорядоченный список координат точек на плоскости для последовательного соединения в ломаную линию.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Point implements Comparable {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Point tmp = (Point) o;

        if (getX() > tmp.getX()) {
            return 1;
        }

        if (getX() < tmp.getX()) {
            return -1;
        }

        if (getY() > tmp.getY()) {
            return 1;
        }

        if (getY() < tmp.getY()) {
            return -1;
        }

        return 0;
    }

    public static List<Point> OneLine(List<Point> points) {
        Collections.sort(points);
        return points;
    }

    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(1, 2));
        points.add(new Point(3, 1));
        points.add(new Point(2, 4));
        points.add(new Point(1, 3));

        System.out.println(points);

        OneLine(points);

        System.out.println(points);
    }
}
