package pl.smtc.patterns.structural.bridge.implementor;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.structural.bridge.support.WeaponType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BionicTest {
    private static final int TEST_DAMAGE = 100;
    private Bionic bionic = new Bionic(TEST_DAMAGE);

    @Test
    void attackShouldReturnDamageValue() {
        assertEquals(TEST_DAMAGE, bionic.attack());
    }

    @Test
    void getTypeShouldReturnWeaponTypeBionic() {
        assertEquals(WeaponType.BIONIC, bionic.getType());
    }
}