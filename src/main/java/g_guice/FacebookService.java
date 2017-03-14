package g_guice;

import com.google.inject.Singleton;

/**
 * Created by wopqw on 14.03.17.
 */
@Singleton
public class FacebookService implements MessageService {

    @Override
    public String sendMessage(String msg, String recipient) {

        return String.format("Facebook Message sent to %s with message = %s",recipient, msg);
    }
}
