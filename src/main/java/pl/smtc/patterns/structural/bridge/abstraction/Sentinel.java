package pl.smtc.patterns.structural.bridge.abstraction;

import pl.smtc.patterns.structural.bridge.implementor.Weapon;
import pl.smtc.patterns.structural.bridge.support.CharacterClass;
import pl.smtc.patterns.structural.bridge.support.WeaponType;

public class Sentinel extends Character {
    public Sentinel(String name) {
        super(name, CharacterClass.SENTINEL);
    }

    @Override
    protected boolean isSpecializedWeapon(Weapon weapon) {
        return weapon.getType() == WeaponType.MELEE
                || weapon.getType() == WeaponType.BIONIC;
    }
}
