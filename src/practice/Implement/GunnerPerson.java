package practice.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import practice.Interface.Equip;
import practice.Interface.Person;

@Component("gunnerPerson")
public class GunnerPerson implements Person {

    @Autowired
    Equip gunner;

    @Override
    public Equip getEquip() {
        return gunner;
    }
}
