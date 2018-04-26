package com.enn.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingleDogReflectKiller {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// kDg();
		try {
			kDg3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void kDg() throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> classType = SingleDog.class;
		Constructor<?> constructor = classType.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		SingleDog singleton = (SingleDog) constructor.newInstance();
		SingleDog singleton2 = SingleDog.newInstance();
		System.out.println(singleton == singleton2); // false
	}

	public static void kDg2() throws Exception {
		Class<?> classType = SingleDog2.class;
		Constructor<?> constructor = classType.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		SingleDog2 singleton = (SingleDog2) constructor.newInstance();
		SingleDog2 singleton2 = SingleDog2.newInstance();
		System.out.println(singleton == singleton2); // false
	}

	public static void kDg3() throws Exception {
		Class<?> classType = SingleDog3.class;
		Constructor<?> constructor = classType.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		
		SingleDog3 singleton2 = SingleDog3.newInstance();
		SingleDog3 singleton = (SingleDog3) constructor.newInstance();
		System.out.println(singleton == singleton2); // false
	}
}