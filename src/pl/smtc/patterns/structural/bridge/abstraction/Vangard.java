package pl.smtc.patterns.structural.bridge.abstraction;

import pl.smtc.patterns.structural.bridge.implementor.Weapon;
import pl.smtc.patterns.structural.bridge.support.CharacterClass;
import pl.smtc.patterns.structural.bridge.support.WeaponType;

public class Vangard extends Character {
    public Vangard(String name) {
        super(name, CharacterClass.VANGARD);
    }

    @Override
    protected boolean isSpecializedWeapon(Weapon weapon) {
        return weapon.getType() == WeaponType.PISTOL
                || weapon.getType() == WeaponType.RIFLE
                || weapon.getType() == WeaponType.BIONIC;
    }
}
