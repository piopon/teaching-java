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

class SentinelTest extends BaseTestOut {
    private final static String TEST_NAME = "TEST_NAME";
    private Sentinel sentinel;

    @Override
    protected void setUp() {
        sentinel = new Sentinel(TEST_NAME);
    }

    @Test
    void attackShouldInvokeAttackAndAddNormalDamageIfNotSpecializedWeapon() {
        sentinel.attack(mockWeapon(20, WeaponType.RIFLE));
        System.out.print(TEST_NAME + " [SENTINEL] attacking with BIONIC => added 20 HP");
    }

    @Test
    void attackShouldInvokeAttackAndAddBigDamageIfSpecializedWeapon() {
        sentinel.attack(mockWeapon(20, WeaponType.MELEE));
        System.out.print(TEST_NAME + " [SENTINEL] attacking with MELEE => added 120 HP");
    }

    @Test
    void moveShouldInvokeMoveTowardsEnemyMethod() {
        sentinel.move();
        String output = getOutput();
        assertTrue(output.contains(TEST_NAME + " [SENTINEL] moving towards enemy!"));
    }

    @Test
    void getCharacterInfoShouldReturnCharacterDescription() {
        assertEquals(TEST_NAME + " [SENTINEL]", sentinel.getCharacterInfo());
    }

    @ParameterizedTest(name = "{1} is a specialized weapon for Sentinel? {0}")
    @MethodSource("createSpecializedWeaponData")
    void isSpecializedWeaponForSentinel(boolean result, WeaponType weaponType) {
        Weapon weapon = mockWeapon(10, weaponType);
        assertEquals(result, sentinel.isSpecializedWeapon(weapon));
    }

    private static Stream<Arguments> createSpecializedWeaponData() {
        return Stream.of(
                Arguments.of(true, WeaponType.BIONIC),
                Arguments.of(true, WeaponType.MELEE),
                Arguments.of(false, WeaponType.PISTOL),
                Arguments.of(false, WeaponType.RIFLE));
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