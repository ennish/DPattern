package com.enn.observer;

public class BulletinObserver implements Observer {
	public static void main(String[] args) {
		
		WeatherData wd = new WeatherData();
	
		wd.registerObserver(new BulletinObserver());
	
		wd.notifyObservers();
	}

	@Override
	public void update(float tempe, float humid, float pressure) {
		System.out.println("updated:tem" + tempe + "humid" + humid + "pressure" + pressure);
	}

}
