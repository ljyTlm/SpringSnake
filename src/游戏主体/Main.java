package 游戏主体;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

/**
 * 游戏启动器
 */
public class Main {

    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        return context;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择游戏模式！！");
        String[] difficulty = {"普通模式", "地狱模式"};
        int n = sc.nextInt();
        context = new ClassPathXmlApplicationContext(difficulty[n]+".xml");
        Game game = (Game) context.getBean("game");
        View view = new View(game);
        game.view = view;
        game.startGame();
    }


}
