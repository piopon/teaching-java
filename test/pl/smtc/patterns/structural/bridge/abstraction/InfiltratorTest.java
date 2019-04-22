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

class InfiltratorTest extends BaseTestOut {
    private final static String TEST_NAME = "TEST_NAME";
    private Infiltrator infiltrator;

    @Override
    protected void setUp() {
        infiltrator = new Infiltrator(TEST_NAME);
    }

    @Test
    void attackShouldInvokeAttackAndAddNormalDamageIfNotSpecializedWeapon() {
        infiltrator.attack(mockWeapon(20, WeaponType.PISTOL));
        System.out.print(TEST_NAME + " [INFILTRATOR] attacking with BIONIC => added 20 HP");
    }

    @Test
    void attackShouldInvokeAttackAndAddBigDamageIfSpecializedWeapon() {
        infiltrator.attack(mockWeapon(20, WeaponType.RIFLE));
        System.out.print(TEST_NAME + " [INFILTRATOR] attacking with MELEE => added 120 HP");
    }

    @Test
    void moveShouldInvokeMoveTowardsEnemyMethod() {
        infiltrator.move();
        String output = getOutput();
        assertTrue(output.contains(TEST_NAME + " [INFILTRATOR] moving towards enemy!"));
    }

    @Test
    void getCharacterInfoShouldReturnCharacterDescription() {
        assertEquals(TEST_NAME + " [INFILTRATOR]", infiltrator.getCharacterInfo());
    }

    @ParameterizedTest(name = "{1} is a specialized weapon for Infiltrator? {0}")
    @MethodSource("createSpecializedWeaponData")
    void isSpecializedWeaponForInfiltrator(boolean result, WeaponType weaponType) {
        Weapon weapon = mockWeapon(10, weaponType);
        assertEquals(result, infiltrator.isSpecializedWeapon(weapon));
    }

    private static Stream<Arguments> createSpecializedWeaponData() {
        return Stream.of(
                Arguments.of(true, WeaponType.BIONIC),
                Arguments.of(false, WeaponType.MELEE),
                Arguments.of(false, WeaponType.PISTOL),
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