package ua.logic.dmitriySokolov;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class MazeWayTest {
    @Test
    public void simple() throws Exception {
        int[][] maze = {
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0}
        };

        List<Point> expected = new LinkedList<>();
        expected.add(new Point(0, 0));
        expected.add(new Point(0, 1));
        expected.add(new Point(0, 2));
        expected.add(new Point(1, 2));
        expected.add(new Point(2, 2));
        expected.add(new Point(3, 2));
        expected.add(new Point(3, 3));
        expected.add(new Point(3, 4));

        MazeWay mazeWay = new MazeWay(maze);
        List<Point> current = mazeWay.getWay(maze);
        Assert.assertTrue(expected.equals(current));
    }

    @Test
    public void deadlock() throws Exception {
        int[][] maze = {
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        List<Point> expected = new LinkedList<>();
        expected.add(new Point(0, 0));
        expected.add(new Point(1, 0));
        expected.add(new Point(2, 0));
        expected.add(new Point(3, 0));
        expected.add(new Point(3, 1));
        expected.add(new Point(3, 2));
        expected.add(new Point(3, 3));
        expected.add(new Point(3, 4));

        MazeWay mazeWay = new MazeWay(maze);
        List<Point> current = mazeWay.getWay(maze);
        Assert.assertTrue(expected.equals(current));
    }

    @Test
    public void noWay() throws Exception {
        int[][] maze = {
                {0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0}
        };

        List<Point> expected = new LinkedList<>();
        expected.add(new Point(0, 0));
        expected.add(new Point(1, 0));
        expected.add(new Point(2, 0));
        expected.add(new Point(3, 0));
        expected.add(new Point(3, 1));
        expected.add(new Point(3, 2));

        MazeWay mazeWay = new MazeWay(maze);
        List<Point> current = mazeWay.getWay(maze);
        Assert.assertTrue(current.isEmpty());
    }
}