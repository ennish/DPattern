package  com.enn.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用枚举的单例模式
 */
public class EnumSingleton {
	private static int sn = 1;

	private EnumSingleton() {
		sn = sn + 1;
	}

	public int getSn() {
		return sn;
	}

	public static EnumSingleton getInstance() {
		return Singleton.INSTANCE.getInstance();
	}

	private static enum Singleton {
		INSTANCE;

		private EnumSingleton singleton;

		// JVM会保证此方法绝对只调用一次
		private Singleton() {
			singleton = new EnumSingleton();
		}

		public EnumSingleton getInstance() {
			return singleton;
		}
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		EnumSingleton obj1 = EnumSingleton.getInstance();
		EnumSingleton obj2 = EnumSingleton.getInstance();
		// 输出结果：obj1==obj2?true
		System.out.println("obj1==obj2?" + (obj1 == obj2));

		Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		EnumSingleton ref_obj = constructor.newInstance();
		System.out.println("obj1==ref_obj?" + (obj1 == ref_obj));
		System.out.println(obj1.getSn() + ":" + ref_obj.getSn());
	}
}