package pl.smtc.patterns.structural.bridge.implementor;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.structural.bridge.support.WeaponType;

import static org.junit.jupiter.api.Assertions.*;

class MeleeTest {
    private static final int TEST_DAMAGE = 100;
    private Melee melee = new Melee(TEST_DAMAGE);

    @Test
    void attackShouldReturnDamageValue() {
        assertEquals(TEST_DAMAGE, melee.attack());
    }

    @Test
    void getTypeShouldReturnWeaponTypeMelee() {
        assertEquals(WeaponType.MELEE, melee.getType());
    }
}