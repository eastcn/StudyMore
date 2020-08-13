package JavaBasic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Classname ForReflect
 * @Description 反射demo
 * @Date 2020/8/13 10:23 上午
 * @Created by East
 */
public class ForReflect {

    private int number = 0;

    public void setNumber(int n) {
        number = n;
    }

    public int getNumber() {
        return number;
    }

    public static void main(String[] args) {
        // 打印当前类的类名
        System.out.println(ForReflect.class.getName());

        // 正向使用
        ForReflect a = new ForReflect();
        a.setNumber(10);
        System.out.println(a.getNumber());
        // 反射

        try {
            // 通过类名查询到类
            Class b = Class.forName("JavaBasic.ForReflect");
            // 通过方法名 从类中获取到方法, 设置方法参数的类
            Method getNumber = b.getMethod("getNumber");
            Method setNumber = b.getMethod("setNumber", int.class);
            // 从Class对象中获取类的构造方法
            Constructor constructor = b.getConstructor();
            // 通过构造方法的 newInstance() 实例化一个类
            Object object = constructor.newInstance();
            // 通过之前获取到的方法，进行调用，传入实例化的类和 方法所需要的参数
            // 调用方法使用 invoke
            System.out.println(getNumber.invoke(object));
            setNumber.invoke(object, 5);
            System.out.println(getNumber.invoke(object));

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
