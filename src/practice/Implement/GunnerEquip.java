package practice.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import practice.Interface.Equip;
import practice.Interface.Person;

@Component("gunnerEquip")
public class GunnerEquip implements Equip {

    String name = "火炮";

    @Autowired
    Person person;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Person getPerson() {
        return person;
    }

}
