package com.enn.singleton;

public class SingleDog4 {

	private static class SingleDog4Holder {

		private static final SingleDog4 INSTANCE = new SingleDog4();

		private SingleDog4 getInstance() {
			return INSTANCE;
		}
	}

	public static SingleDog4 newInstance() {
		return SingleDog4Holder.INSTANCE.newInstance();
	}

}