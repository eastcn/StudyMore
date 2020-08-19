package com.east.JavaBasic.DesignModel;

/**
 * @Classname DesignDemo
 * @Description 单例模式：全局有且仅有一个实例
 * 1. 只有private构造方法，确保外部无法实例化；
 * 2. 通过private static变量持有唯一实例，保证全局唯一性；
 * 3. 通过public static方法返回此唯一实例，使外部调用方能获取到实例。
 * @Date 2020/8/19 3:49 下午
 * @Created by East
 */
public class SingleDemo {
    private SingleDemo() {
        // 把构造函数设为private 保证外部无法构造
    }

    private static final SingleDemo instance = new SingleDemo(); // 内部生成一个自己的实例

    // 开一个接口给外部获取该实例
    static public SingleDemo getInstance() {
        return instance;
    }


}
