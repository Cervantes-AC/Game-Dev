package charsys;

import charsys.actions.Attack;
import charsys.actions.Defend;
import charsys.role.CharacterRole;
import charsys.role.CharacterType;

import java.util.List;

/**
 * A MELEE RPGCharacter with FIGHTER Role, usually prefers to be placed at 2,1,0.
 */
public class Warrior extends RPGCharacter {

    public Warrior(String name) {
        this(name, CharacterRole.FIGHTER);
    }

    /**
     * Creates a default warrior character with custom preferred columns.
     * @param name Warrior name.
     * @param preferredColums Custom preferred columns.
     */
    public Warrior(String name, List<Integer> preferredColumns) {
        super(name, CharacterType.MELEE, CharacterRole.FIGHTER, preferredColumns);
        this.assignDefaultActions();
    }

    /**
     * Creates a Melee Warrior with custom role. Default preferred columns applied.
     * @param name Warrior name.
     * @param role Custom Warrior role.
     */
    public Warrior(String name, CharacterRole role) {
        super(name, CharacterType.MELEE, role, List.of(2,1,0));
        this.assignDefaultActions();
    }

    /**
     * Creates a Melee Warrior with custom primary and secondary role. Default preferred columns applied.
     * @param name Warrior name.
     * @param primary Custom primary role.
     * @param secondary Custom secondary role.
     */
    public Warrior(String name, CharacterRole primary, CharacterRole secondary) {
        super(name, CharacterType.MELEE, primary, secondary, List.of(2,1,0));
        this.assignDefaultActions();
    }

    /**
     * Assigns default actions to this warrior: Attack and Defend.
     */
    @Override
    protected void assignDefaultActions() {
        this.addAction(new Attack());
        this.addAction(new Defend());
    }
}
