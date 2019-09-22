package com.enn.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingleDog5 {

    private static int ID = 1;

    /**
     * initialization on daemon holder
     *
     */
    private enum SingleDog5EnumHolder {
        //
        INSTANCE;

        private SingleDog5 singleton;

        /**
         * jvm保证该方法只执行一次
         */
        SingleDog5EnumHolder() {
            singleton = new SingleDog5();
        }

        public SingleDog5 newInstance() {
            ID++;
            return singleton;
        }
    }

    public static SingleDog5 getInstance() {
        return SingleDog5EnumHolder.INSTANCE.newInstance();
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        SingleDog5 single = SingleDog5.getInstance();

        Constructor<SingleDog5> constructor = SingleDog5.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingleDog5 refSingleton = constructor.newInstance();
        System.out.println("singleton == ref_singleton:" + (single == refSingleton));
        System.out.println("single_id & ref_single_id:" + SingleDog5.ID);
    }
}