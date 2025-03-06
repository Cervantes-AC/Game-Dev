package charsys;

import charsys.actions.Fireball;
import charsys.role.CharacterRole;
import charsys.role.CharacterType;

import java.util.List;

public class Mage extends RPGCharacter {

    public Mage(String name) {
        this(name, CharacterRole.BURST);
    }

    public Mage(String name, CharacterRole primary) {
        super(name, CharacterType.RANGED, primary, List.of(0,1,2));
        this.assignDefaultActions();
    }

    public Mage(String name, CharacterRole primary, CharacterRole secondary) {
        super(name, CharacterType.RANGED, primary, secondary, List.of(0, 1, 2));
    }

    public Mage(String name, CharacterRole primary, List<Integer> preferredCols)
    {
        super(name, CharacterType.RANGED, primary, preferredCols);
    }

    @Override
    protected void assignDefaultActions() {
        this.addAction(new Fireball());
    }
}
