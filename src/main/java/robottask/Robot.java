package robottask;

import java.awt.*;

/**
 * Created by wopqw on 19.09.16.
 */
public class Robot {

    private Point position;
    private Direction currentDir;

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point currentPosition) {
        this.position = currentPosition;
    }

    public Direction getDirection() {
        return currentDir;
    }

    public void setDirection(Direction currentDir) {
        this.currentDir = currentDir;
    }

    public int getX() {
        return position.x; // текущая координата X
    }

    public int getY() {
        return position.y; // текущая координата Y
    }

    public void turnLeft() {
        currentDir = Direction.getLeftDir(currentDir); // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        currentDir = Direction.getRightDir(currentDir); // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        if (null != currentDir) // шаг в направлении взгляда
            // за один шаг робот изменяет одну свою координату на единицу
            switch (getDirection()) {
                case DOWN:
                    position.y -= 1;
                    break;
                case UP:
                    position.y += 1;
                    break;
                case LEFT:
                    position.x -= 1;
                    break;
                case RIGHT:
                    position.x += 1;
                    break;
                default:
                    break;
            }
    }
}
