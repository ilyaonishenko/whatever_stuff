package patterns.observer;

/**
 * Created by wopqw on 14.03.17.
 */
public interface Observer {

    void update(int temp, int humidity, int pressure);
}
