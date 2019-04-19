package pl.smtc.patterns.structural.bridge.implementor;

import pl.smtc.patterns.structural.bridge.support.WeaponType;

public class Pistol implements Weapon {
    private int damage;
    private WeaponType type;

    public Pistol(int damage) {
        this.damage = damage;
        this.type = WeaponType.PISTOL;
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
