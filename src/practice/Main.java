package practice;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.*;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import practice.Interface.Equip;
import practice.Interface.Person;
import 游戏主体.Game;
import 游戏主体.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        ClassPathResource resource = new ClassPathResource("practice.xml");
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(resource);
        ApplicationContext factory = new ClassPathXmlApplicationContext("practice.xml");
        Person person = (Person) factory.getBean("gunnerPerson");
        System.out.println(person);
        Equip equip = person.getEquip();
        System.out.println(equip.getPerson());
        System.out.println();
    }
}