package  com.enn.singleton;

/**
 * 使用另一个变量判断构造函数是否执行了多次，防止单例被attack
 * @author hacker
 *
 */
public class SingleDog2 {
	private static int count = 0;

	// private static final SingleDog singleDog = new SingleDog();//饱汉
	private static SingleDog2 singleDog;

	private static boolean flag = false;

	// 私有化构造函数,singleton的普遍做法
	private SingleDog2() throws Exception {
		synchronized (SingleDog2.class) {
			if (count==1) {
				flag = !flag;
				count++;
				System.out.println("Congratulation,you create no" + count + " single dog!");
			} else {
				throw new Exception("single failure");
			}
		}

	}

	public static SingleDog2 newInstance() throws Exception {

		if (singleDog == null) {
			singleDog = new SingleDog2();
		}
		return singleDog;
	}

}
