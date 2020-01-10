package pl.smtc.patterns.structural.bridge.abstraction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.structural.bridge.implementor.Weapon;
import pl.smtc.patterns.structural.bridge.support.WeaponType;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class VangardTest extends BaseTestOut {
    private final static String TEST_NAME = "TEST_NAME";
    private Vangard vangard;

    @Override
    protected void setUp() {
        vangard = new Vangard(TEST_NAME);
    }

    @Test
    void attackShouldInvokeAttackAndAddNormalDamageIfNotSpecializedWeapon() {
        vangard.attack(mockWeapon(20, WeaponType.MELEE));
        System.out.print(TEST_NAME + " [VANGARD] attacking with BIONIC => added 20 HP");
    }

    @Test
    void attackShouldInvokeAttackAndAddBigDamageIfSpecializedWeapon() {
        vangard.attack(mockWeapon(20, WeaponType.BIONIC));
        System.out.print(TEST_NAME + " [VANGARD] attacking with MELEE => added 120 HP");
    }

    @Test
    void moveShouldInvokeMoveTowardsEnemyMethod() {
        vangard.move();
        String output = getOutput();
        assertTrue(output.contains(TEST_NAME + " [VANGARD] moving towards enemy!"));
    }

    @Test
    void getCharacterInfoShouldReturnCharacterDescription() {
        assertEquals(TEST_NAME + " [VANGARD]", vangard.getCharacterInfo());
    }

    @ParameterizedTest(name = "{1} is a specialized weapon for Vangard? {0}")
    @MethodSource("createSpecializedWeaponData")
    void isSpecializedWeaponForVangard(boolean result, WeaponType weaponType) {
        Weapon weapon = mockWeapon(10, weaponType);
        assertEquals(result, vangard.isSpecializedWeapon(weapon));
    }

    private static Stream<Arguments> createSpecializedWeaponData() {
        return Stream.of(
                Arguments.of(true, WeaponType.BIONIC),
                Arguments.of(false, WeaponType.MELEE),
                Arguments.of(true, WeaponType.PISTOL),
                Arguments.of(true, WeaponType.RIFLE));
    }

    private Weapon mockWeapon(int damage, WeaponType type) {
        return new Weapon() {
            @Override
            public int attack() {
                return damage;
            }

            @Override
            public WeaponType getType() {
                return type;
            }
        };
    }
}