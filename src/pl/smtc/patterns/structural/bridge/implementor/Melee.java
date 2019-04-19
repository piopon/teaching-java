package pl.smtc.patterns.structural.bridge.implementor;

import pl.smtc.patterns.structural.bridge.support.WeaponType;

public class Melee implements Weapon {
    private int damage;
    private WeaponType type;

    public Melee(int damage) {
        this.damage = damage;
        this.type = WeaponType.MELEE;
    }

    @Override
    public int attack() {
        return damage;
    }

    @Override
    public WeaponType getType() {
        return type;
    }
}
