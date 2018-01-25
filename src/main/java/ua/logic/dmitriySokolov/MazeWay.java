package ua.logic.dmitriySokolov;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MazeWay {
    private final Set<Point> deadLocks = new HashSet<>();
    private final Set<Point> usedPoints = new HashSet<>();

    final private int[][] maze;

    MazeWay(int[][] maze) {
        this.maze = maze;
    }

    public List<Point> getWay(int[][] maze) {
        List<Point> result = new ArrayList<>();
        Point point = new Point(0, 0);
        Point tryPoint;
        usedPoints.add(point);
        result.add(point);
        Point finishPoint = new Point(maze.length - 1, maze[maze.length - 1].length - 1);
        while (!point.equals(finishPoint) && !result.isEmpty()) {

            tryPoint = getNextPoint(result);
            if (tryPoint != null) {
                point = tryPoint;
                result.add(point);
                usedPoints.add(point);
            } else {
                itsDeadlock(point, result);
            }
        }

        return result;
    }

    private void itsDeadlock(Point point, List<Point> node) {
        deadLocks.add(point);
        node.remove(node.size() - 1);
    }

    private boolean validPoint(Point point) {
        if (usedPoints.contains(point)) {
            return false;
        }

        if (deadLocks.contains(point)) {
            return false;
        }

        if (0 > point.getX()) {
            return false;
        }

        if (0 > point.getY()) {
            return false;
        }

        if (maze.length - 1 < point.getX()) {
            return false;
        }

        if (maze[maze.length - 1].length - 1 < point.getY()) {
            return false;
        }

        int currentX = (int) point.getX();
        int currentY = (int) point.getY();
        if (maze[currentX][currentY] == 1) {
            return false;
        }

        return true;
    }

    private Point getNextPoint(List<Point> node) {
        Point last = node.get(node.size() - 1);
        int currentX = (int) last.getX();
        int currentY = (int) last.getY();
        Point current = new Point(currentX, currentY + 1);
        if (validPoint(current)) {
            return current;
        }
        current = new Point(currentX - 1, currentY);
        if (validPoint(current)) {
            return current;
        }
        current = new Point(currentX, currentY - 1);
        if (validPoint(current)) {
            return current;
        }
        current = new Point(currentX + 1, currentY);
        if (validPoint(current)) {
            return current;
        }

        return null;
    }
}
