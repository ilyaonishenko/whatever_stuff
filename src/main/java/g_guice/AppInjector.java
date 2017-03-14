package g_guice;

import com.google.inject.AbstractModule;

/**
 * Created by wopqw on 14.03.17.
 */
public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {

        bind(MessageService.class).to(FacebookService.class);
    }
}
