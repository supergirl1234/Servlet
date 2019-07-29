package damic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/*
* 动态代理
* */
public class DamicProxy  implements InvocationHandler {
   /*真实对象*/
    private  Object targetObject;

    /*代理对象*/

    public Object proxyObject(Object user){
        this.targetObject=user;
        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(),
                this);

    }

    /*
    * proxy:真实对象
    * 这个函数是由系统调用的
    * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        check();
        return method.invoke(this.targetObject,args);
    }


    public void check(){
        System.out.println("检查电脑性能");
    }
}
