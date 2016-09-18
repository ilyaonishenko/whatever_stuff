import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 18.09.16.
 */
public class StepicBasiOperationsJavaTest {
    @Test
    public void printTextPerRoleTest() throws Exception {

        assertThat(StepicBasiOperationsJava.printTextPerRole(new String[]{"Ivan","Mike","Andrew"},
                new String[]{"Ivan: I,m Ivan","Mike: where is Ivan?","Andrew: Hey. I'm a killer"}),
                is("Ivan:\n1) I,m Ivan\nMike:\n1) where is Ivan?\nAndrew:\n1) Hey. I'm a killer\n"));
    }

    @Test
    public void regExpTest(){

        assertThat(StepicBasiOperationsJava
                        .regexp("Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",".+?(?=:)",true),
                is("Городничий"));
    }

    @Test
    public void regExpTest2(){

        assertThat(StepicBasiOperationsJava
                        .regexp("Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",":(.+)",false),
                is(" Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор."));
    }

}