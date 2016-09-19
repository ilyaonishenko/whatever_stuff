package robottask;

/**
 * Created by wopqw on 19.09.16.
 */
public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction getLeftDir(Direction dir) {
        if (null != dir) switch (dir) {
            case UP:
                return LEFT;
            case LEFT:
                return DOWN;
            case DOWN:
                return RIGHT;
            case RIGHT:
                return UP;
            default:
                break;
        }
        return null;
    }

    public static Direction getRightDir(Direction dir) {
        if (null != dir) switch (dir) {
            case UP:
                return RIGHT;
            case LEFT:
                return UP;
            case DOWN:
                return LEFT;
            case RIGHT:
                return DOWN;
            default:
                break;
        }
        return null;
    }
}
