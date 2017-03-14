package g_guice;

import com.google.inject.Inject;

/**
 * Created by wopqw on 14.03.17.
 */
public class Application {

    private MessageService service;

    @Inject
    public void setService(MessageService service){
        this.service = service;
    }

    public String  sendMessage(String msg, String rec){
        //some business logic here
        return service.sendMessage(msg, rec);
    }
}
