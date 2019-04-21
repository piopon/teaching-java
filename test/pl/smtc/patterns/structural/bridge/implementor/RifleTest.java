package pl.smtc.patterns.structural.bridge.implementor;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.structural.bridge.support.WeaponType;

import static org.junit.jupiter.api.Assertions.*;

class RifleTest {
    private static final int TEST_DAMAGE = 100;
    private Rifle rifle = new Rifle(TEST_DAMAGE);

    @Test
    void attackShouldReturnDamageValue() {
        assertEquals(TEST_DAMAGE, rifle.attack());
    }

    @Test
    void getTypeShouldReturnWeaponTypeRifle() {
        assertEquals(WeaponType.RIFLE, rifle.getType());
    }
}