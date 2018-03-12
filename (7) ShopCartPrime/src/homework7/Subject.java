package homework7;

public interface Subject
{
	
	public void removeObserver(Observer observer);
	
	public void registerObserver(Observer observer);
	
	public void notifyObserver();
	
}
