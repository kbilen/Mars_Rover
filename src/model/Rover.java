package model;

import java.util.Set;

public class Rover {
    private int x;
    private int y;
    private char direction;
    private static final int GRID_SIZE = 100;
    private Set<String> obstacles;

    public Rover(int startX, int startY, char startDirection, Set<String> obstacles) {
        this.x = startX;
        this.y = startY;
        this.direction = startDirection;
        this.obstacles = obstacles;
    }


    public void moveForward() {
        int newX = x;
        int newY = y;

        switch (direction) {
            case 'N' -> newY = (y + 1) % GRID_SIZE;
            case 'S' -> newY = (y - 1 + GRID_SIZE) % GRID_SIZE;
            case 'E' -> newX = (x + 1) % GRID_SIZE;
            case 'W' -> newX = (x - 1 + GRID_SIZE) % GRID_SIZE;
        }

        if (isObstacle(newX, newY)) {
            System.out.println("Obstacle detected at (" + newX + ", " + newY + "). Stopping.");
        } else {
            x = newX;
            y = newY;
        }
    }

    public void moveBackward() {
        int newX = x;
        int newY = y;

        switch (direction) {
            case 'N' -> newY = (y - 1 + GRID_SIZE) % GRID_SIZE;
            case 'S' -> newY = (y + 1) % GRID_SIZE;
            case 'E' -> newX = (x - 1 + GRID_SIZE) % GRID_SIZE;
            case 'W' -> newX = (x + 1) % GRID_SIZE;
        }

        if (isObstacle(newX, newY)) {
            System.out.println("Obstacle detected at (" + newX + ", " + newY + "). Stopping.");
        } else {
            x = newX;
            y = newY;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case 'N' -> direction = 'W';
            case 'W' -> direction = 'S';
            case 'S' -> direction = 'E';
            case 'E' -> direction = 'N';
        }
    }

    public void turnRight() {
        switch (direction) {
            case 'N' -> direction = 'E';
            case 'E' -> direction = 'S';
            case 'S' -> direction = 'W';
            case 'W' -> direction = 'N';
        }
    }

    private boolean isObstacle(int x, int y) {
        return obstacles.contains(x + "," + y);
    }

    public void printPosition() {
        System.out.println("Rover position: (" + x + ", " + y + ") facing " + direction);
    }
}