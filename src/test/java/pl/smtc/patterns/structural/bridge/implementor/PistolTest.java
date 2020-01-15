package pl.smtc.patterns.structural.bridge.implementor;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.structural.bridge.support.WeaponType;

import static org.junit.jupiter.api.Assertions.*;

class PistolTest {
    private static final int TEST_DAMAGE = 100;
    private Pistol pistol = new Pistol(TEST_DAMAGE);

    @Test
    void attackShouldReturnDamageValue() {
        assertEquals(TEST_DAMAGE, pistol.attack());
    }

    @Test
    void getTypeShouldReturnWeaponTypePistol() {
        assertEquals(WeaponType.PISTOL, pistol.getType());
    }
}