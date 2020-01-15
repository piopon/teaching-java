package pl.smtc.patterns.structural.bridge.abstraction;

import pl.smtc.patterns.structural.bridge.implementor.Weapon;
import pl.smtc.patterns.structural.bridge.support.CharacterClass;

public abstract class Character {
    private String name;
    private CharacterClass characterClass;

    public Character(String name, CharacterClass characterClass) {
        this.name = name;
        this.characterClass = characterClass;
    }

    public void attack(Weapon weapon) {
        System.out.print(getCharacterInfo() + " attacking with " + weapon.getType() + " => ");
        int damage = weapon.attack() + (isSpecializedWeapon(weapon) ? 100 : 0);
        System.out.println("added " + damage + "HP");
    }

    public void move() {
        System.out.println(getCharacterInfo() + " moving towards enemy!");
    }

    protected String getCharacterInfo() {
        return name + " [" + characterClass.toString() + "]";
    }

    protected abstract boolean isSpecializedWeapon(Weapon weapon);
}
