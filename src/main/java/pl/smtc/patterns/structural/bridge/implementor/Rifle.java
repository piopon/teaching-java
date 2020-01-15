package pl.smtc.patterns.structural.bridge.implementor;

import pl.smtc.patterns.structural.bridge.support.WeaponType;

public class Rifle implements Weapon {
    private int damage;
    private WeaponType type;

    public Rifle(int damage) {
        this.damage = damage;
        this.type = WeaponType.RIFLE;
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
