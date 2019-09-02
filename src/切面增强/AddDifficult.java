package 切面增强;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import 游戏主体.Main;
import 顶级接口.Config;
import 顶级接口.Snake;

@Component
@Aspect
public class AddDifficult {

    @Pointcut("execution(* 普通模式.SnakeImpl.go(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before() {
//      在这个方法里 可以充分的发挥想象类 设计有趣的 游戏玩法
        System.out.println("前置通知。。。。。。");
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
//      在后置通知里面 我设计了一个 玩法就是每吃到一个豆子 那么游戏难度增加
        Integer status = (Integer)result;
        if (status == Snake.PRIZE) {
//          如果返回值是1 代表蛇吃到了豆子 那么我利用AOP对难度进行升级
            Config config = (Config) Main.getContext().getBean("config");
            config.setDifficulty(config.getDifficulty()-5);
        }
    }
}
