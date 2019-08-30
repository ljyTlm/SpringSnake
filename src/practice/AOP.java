package practice;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import practice.Implement.GunnerPerson;
import practice.Interface.Person;

import java.lang.reflect.Method;

public class AOP {
    public static void main(String[] args) {
        demo1();
    }

    private static void demo1() {
        GunnerPerson person = new GunnerPerson();
//      准备 被代理对象
        ProxyFactory factory = new ProxyFactory();
//      创建代理工厂
        factory.setTarget(person);
//      设置工厂原型对象

//      构造切面 切面 = 切点+通知
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
//      创建切点
        pointcut.setPattern(".*get.*");
//      设置切点的匹配规则 就是符合这个规则的都作为切点

//      创建切面
        Advice advice = new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("你好我正在进行前置通知");
//                method.invoke(args);
            }
        };

//      创建切面 并设置切点和通知
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

//      将切面交给代理工厂 由代理工厂按照切面生成代理类
        factory.addAdvisor(advisor);
        GunnerPerson proxy = (GunnerPerson)factory.getProxy();
        System.out.println(proxy.getEquip());
    }
}
