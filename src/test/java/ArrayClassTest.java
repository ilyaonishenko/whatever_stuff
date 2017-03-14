import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 15.12.16.
 */
public class ArrayClassTest {

    @Test
    public void reverse3Test(){

        assertThat(ArrayClass.reverse3(new int[]{1, 2, 3}), is(new int[]{3, 2, 1}));
    }

    @Test
    public void maxEnd3(){

        assertThat(ArrayClass.maxEnd3(new int[]{11, 3, 3}), is(new int[]{11, 11, 11}));
    }

    @Test
    public void sum2(){

        assertThat(ArrayClass.sum2(new int[]{5,2,3,1,2,5}), is(7));
    }

}