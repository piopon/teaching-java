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

class SoldierTest extends BaseTestOut {
    private final static String TEST_NAME = "TEST_NAME";
    private Soldier soldier;

    @Override
    protected void setUp() {
        soldier = new Soldier(TEST_NAME);
    }

    @Test
    void attackShouldInvokeAttackAndAddNormalDamageIfNotSpecializedWeapon() {
        soldier.attack(mockWeapon(20, WeaponType.BIONIC));
        System.out.print(TEST_NAME + " [SOLDIER] attacking with BIONIC => added 20 HP");
    }

    @Test
    void attackShouldInvokeAttackAndAddBigDamageIfSpecializedWeapon() {
        soldier.attack(mockWeapon(20, WeaponType.RIFLE));
        System.out.print(TEST_NAME + " [SOLDIER] attacking with MELEE => added 120 HP");
    }

    @Test
    void moveShouldInvokeMoveTowardsEnemyMethod() {
        soldier.move();
        String output = getOutput();
        assertTrue(output.contains(TEST_NAME + " [SOLDIER] moving towards enemy!"));
    }

    @Test
    void getCharacterInfoShouldReturnCharacterDescription() {
        assertEquals(TEST_NAME + " [SOLDIER]", soldier.getCharacterInfo());
    }

    @ParameterizedTest(name = "{1} is a specialized weapon for Soldier? {0}")
    @MethodSource("createSpecializedWeaponData")
    void isSpecializedWeaponForSoldier(boolean result, WeaponType weaponType) {
        Weapon weapon = mockWeapon(10, weaponType);
        assertEquals(result, soldier.isSpecializedWeapon(weapon));
    }

    private static Stream<Arguments> createSpecializedWeaponData() {
        return Stream.of(
                Arguments.of(false, WeaponType.BIONIC),
                Arguments.of(true, WeaponType.MELEE),
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