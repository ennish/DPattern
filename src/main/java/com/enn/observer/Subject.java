package  com.enn.observer;

/**
 * @author hacker
 */
public interface Subject {

	void registerObserver(Observer observer);

	void removeObserver(Observer observer);
	

	void notifyObservers();

}
