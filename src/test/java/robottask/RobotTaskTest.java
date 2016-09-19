package robottask;

import org.junit.Test;

import java.awt.*;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;


/**
 * Created by wopqw on 19.09.16.
 */
public class RobotTaskTest {

    @Test
    public void RobotMoveTest(){
        Robot robot = new Robot();
        robot.setPosition(new Point(10, 10));
        robot.setDirection(Direction.UP);

        RobotTask.moveRobot(robot,0,0);

        assertThat(robot.getPosition(),is(new Point(0,0)));
    }

}