package com.enn.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingleDog5 {

	private static int id = 1;

	private static enum SingleDog5Enum {
		INSTANCE;

		private SingleDog5 singleton;

		/**
		 * jvm保证该方法只执行一次
		 */
		private SingleDog5Enum() {
			singleton = new SingleDog5();
		}

		public SingleDog5 newInstance() {
			id++;
			return singleton;
		}
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		SingleDog5.id = id;
	}

	public static SingleDog5 getInstance() {
		return SingleDog5Enum.INSTANCE.newInstance();
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SingleDog5 single = SingleDog5.getInstance();

		Constructor<SingleDog5> constructor = SingleDog5.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		SingleDog5 ref_singleton = constructor.newInstance();
		System.out.println("singleton == ref_singleton:"+(single==ref_singleton));
		System.out.println("single_id & ref_single_id:" + single.getId() + "&" + ref_singleton.getId());
	}
}