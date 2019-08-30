package AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import 游戏主体.Main;
import 顶级接口.Config;

@Component
@Aspect
public class AddDifficult {

    @Pointcut("execution(* 普通模式.SnakeImpl.go(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before() {
        System.out.println("前置通知。。。。。。");
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        Integer flag = (Integer)result;
        if (flag == 1) {
//          如果返回值是1 代表蛇吃到了豆子 那么我利用AOP对难度进行升级
            Config config = (Config) Main.context.getBean("config");
            config.setDifficulty(config.getDifficulty()-5);
        }
    }
}
