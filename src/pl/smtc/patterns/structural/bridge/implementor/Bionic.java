package pl.smtc.patterns.structural.bridge.implementor;

import pl.smtc.patterns.structural.bridge.support.WeaponType;

public class Bionic implements Weapon {
    private int damage;
    private WeaponType type;

    public Bionic(int damage) {
        this.damage = damage;
        this.type = WeaponType.BIONIC;
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
