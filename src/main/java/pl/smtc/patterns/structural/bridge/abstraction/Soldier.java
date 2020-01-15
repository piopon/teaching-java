package pl.smtc.patterns.structural.bridge.abstraction;

import pl.smtc.patterns.structural.bridge.implementor.Weapon;
import pl.smtc.patterns.structural.bridge.support.CharacterClass;
import pl.smtc.patterns.structural.bridge.support.WeaponType;

public class Soldier extends Character {
    public Soldier(String name) {
        super(name, CharacterClass.SOLDIER);
    }

    @Override
    protected boolean isSpecializedWeapon(Weapon weapon) {
        return weapon.getType() == WeaponType.PISTOL
                || weapon.getType() == WeaponType.RIFLE
                || weapon.getType() == WeaponType.MELEE;
    }
}
