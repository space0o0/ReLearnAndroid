package demo.sp.relearnandroid.autoProxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        IPeople man = new Man();
        AutoProxyHandler handler = new AutoProxyHandler(man);
        ClassLoader loader = man.getClass().getClassLoader();

        IPeople pMan = (IPeople) Proxy.newProxyInstance(loader, new Class[]{IPeople.class}, handler);

        pMan.eat();
    }
}
