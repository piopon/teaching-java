package pl.smtc.patterns.structural.bridge.abstraction;

import pl.smtc.patterns.structural.bridge.implementor.Weapon;
import pl.smtc.patterns.structural.bridge.support.CharacterClass;
import pl.smtc.patterns.structural.bridge.support.WeaponType;

public class Infiltrator extends Character {
    public Infiltrator(String name) {
        super(name, CharacterClass.INFILTRATOR);
    }

    @Override
    protected boolean isSpecializedWeapon(Weapon weapon) {
        return weapon.getType() == WeaponType.BIONIC
                || weapon.getType() == WeaponType.RIFLE;
    }
}
