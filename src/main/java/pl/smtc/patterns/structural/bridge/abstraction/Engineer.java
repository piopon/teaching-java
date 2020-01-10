package pl.smtc.patterns.structural.bridge.abstraction;

import pl.smtc.patterns.structural.bridge.implementor.Weapon;
import pl.smtc.patterns.structural.bridge.support.CharacterClass;
import pl.smtc.patterns.structural.bridge.support.WeaponType;

public class Engineer extends Character {
    public Engineer(String name) {
        super(name, CharacterClass.ENGINEER);
    }

    @Override
    protected boolean isSpecializedWeapon(Weapon weapon) {
        return weapon.getType() == WeaponType.PISTOL
                || weapon.getType() == WeaponType.MELEE;
    }
}
