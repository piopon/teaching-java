package pl.smtc.patterns.structural.bridge.implementor;

import pl.smtc.patterns.structural.bridge.support.WeaponType;

public interface Weapon {
    int attack();

    WeaponType getType();
}
