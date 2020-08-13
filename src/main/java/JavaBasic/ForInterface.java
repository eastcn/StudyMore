package JavaBasic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Classname ForInterface
 * @Description TODO
 * @Date 2020/8/13 11:45 上午
 * @Created by East
 */
public class ForInterface implements InterfaceDemo {

    @Override
    public void getInterfaceName() {
        String interfaceName = "name";
        System.out.println(interfaceName);
    }

    @Override
    public void Hello() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        ForInterface forInterface = new ForInterface();
        forInterface.getInterfaceName();
        forInterface.Hello();

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };


        proxyInterface hello = (proxyInterface) Proxy.newProxyInstance(
                proxyInterface.class.getClassLoader(),
                new Class[]{proxyInterface.class},
                handler
        );
        hello.Hello();
    }
}
