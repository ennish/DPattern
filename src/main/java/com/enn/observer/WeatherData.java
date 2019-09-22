package com.enn.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author hacker
 */
public class WeatherData implements Subject{
	
	List<Observer> observerList = new ArrayList<Observer>();
	public float getTemperature() {
		return 0f;
	}
	
	public float getHumid() {
		return 0f;
	}
	
	public float getPressure() {
		return 0f;
	}
	
	public void measurementsChanged() {
		
	}

	@Override
	public void registerObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		if(observerList.indexOf(observer)>0) {
			observerList.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		for(Observer o:observerList) {
			o.update(getTemperature(), getHumid(), getPressure());
		}
	}
}
