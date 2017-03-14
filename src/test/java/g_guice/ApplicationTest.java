package g_guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by wopqw on 14.03.17.
 */
class ApplicationTest {

    Injector injector;
    Application app;

    @BeforeEach
    void setUp() {
        injector = Guice.createInjector(new AppInjector());
        app = injector.getInstance(Application.class);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void sendMessage() {
        assertThat(app.sendMessage("hello", "Ivan"),
                is("Facebook Message sent to Ivan with message = hello"));
    }

}