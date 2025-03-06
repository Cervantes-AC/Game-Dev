package charsys;

import charsys.actions.Attack;
import charsys.role.CharacterRole;
import charsys.role.CharacterType;

import java.util.List;

public class Archer extends RPGCharacter {

    /**
     * Creates a default Archer character of Ranged type and DPS role.
     * Prefers columns 1, 2, and 0.
     *
     * @param name Archer character name.
     */
    public Archer(String name) {
        super(name, CharacterType.RANGED, CharacterRole.DPS, List.of(1,2,0));
        assignDefaultActions();
    }

    /**
     * Creates a custom Archer character of Ranged type but custom primary role.
     * Still prefers columns 1, 2, and 0.
     * @param name Archer name.
     * @param role Custom primary role of this character.
     */
    public Archer(String name, CharacterRole role) {
        super(name, CharacterType.RANGED, role, List.of(1,2,0));
        assignDefaultActions();
    }

    /**
     * Assigns default actions to this Archer character: Attack.
     */
    @Override
    protected void assignDefaultActions() {
        // Add an attack action
        this.addAction(new Attack());
    }
}
