package patterns.observer;

/**
 * Created by wopqw on 14.03.17.
 */
public interface Subject {

    void registerObserver(Observer o);
    void deleteObserver(Observer o);
    void notifyObjects();
}
