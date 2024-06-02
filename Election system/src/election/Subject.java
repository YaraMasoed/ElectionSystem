package election;

import java.util.ArrayList;

/**
 *
 * @author Yara
 */
public interface Subject {

    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
