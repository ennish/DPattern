package com.enn.singleton;

/**
 *	多线程下有效，但是任然不能防止反射的attack 
 * @author hacker
 *
 */
public class SingleDog3 {
	private static int count = 0;
	// private static final SingleDog singleDog = new SingleDog();//饱汉
	
	//当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
	private volatile static SingleDog3 singleDog;

	// 私有化构造函数,singleton的普遍做法
	private SingleDog3() {
		count++;
		System.out.println("Congratulation,you create no" + count + " single dog!");
	}
	
	public static SingleDog3 newInstance() {
		if (singleDog == null) {
			synchronized (SingleDog.class) {
				if (singleDog == null) {
					singleDog = new SingleDog3();
				}
			}
		}
		return singleDog;
	}
 
}
