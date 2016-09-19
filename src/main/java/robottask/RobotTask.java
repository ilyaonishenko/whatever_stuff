package robottask;

/**
 * Created by wopqw on 19.09.16.
 */
public class RobotTask {

    public static void moveRobot(Robot robot, int toX, int toY) {

        int difX = getDif(robot.getX(),toX);
        System.out.println("DIFX: "+difX);
        int difY = getDif(robot.getY(),toY);
        System.out.println("DIFY: "+difY);

        if (difX>0){
            turnFor(robot,Direction.RIGHT);
            goFor(robot,difX);
        } else {
            turnFor(robot,Direction.LEFT);
            goFor(robot,-difX);
        }

        if(difY>0){
            turnFor(robot,Direction.UP);
            goFor(robot,difY);
        } else {
            turnFor(robot,Direction.DOWN);
            goFor(robot,-difY);
        }

    }
    private static int getDif(int rX, int toX){

        return toX-rX;
    }

    private static void goFor (Robot robot, int x){
        while (x!=0){
            x-=1;
            robot.stepForward();
        }
    }
    private static void turnFor (Robot r, Direction d){

        while(r.getDirection()!=d)
            r.turnRight();
    }
}
