package com.enn.singleton;

public class SingleDog {
	private static int count = 0;
//	private static final  SingleDog singleDog = new SingleDog();//饱汉
	private static SingleDog singleDog;

	// 私有化构造函数,singleton的普遍做法
	private SingleDog() {
		count++;
		System.out.println("Congratulation,you create no" + count + " single dog!");
	}

	public static SingleDog newInstance() {
		if (singleDog == null) {
			singleDog = new SingleDog();
		}
		return singleDog;
	}

	public static void main(String[] args) {
		SingleDog sd = SingleDog.newInstance();
		
	}
}
