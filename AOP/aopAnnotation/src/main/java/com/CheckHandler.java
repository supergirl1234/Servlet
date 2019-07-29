package com;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*AOP是基于动态代理实现的*/
/*用AOP注解的方式实现动态代理，
*
* */
@Aspect
public class CheckHandler {

    @Pointcut("execution(* com.User.*(..))")
    private void method(){}
    @Before("method()" )
    private void check(){
        System.out.println("检查是否带好随身物品");
    }


}
