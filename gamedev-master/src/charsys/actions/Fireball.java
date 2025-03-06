package charsys.actions;

import charsys.RPGCharacter;

/**
 * A spell-casting action where an RPGCharacter casts a fireball.
 */
public class Fireball implements Actionable {

    @Override
    public TargetType getTargetType() {
        return TargetType.SINGLE;
    }

    @Override
    public TargetParty getTargetPartySelector() {
        return TargetParty.OPPOSITE;
    }

    @Override
    public void performAction(RPGCharacter source, RPGCharacter target) {
        System.out.printf("%s throws a fireball at %s!\n\n", source.getName(), target.getName());
    }

    @Override
    public String getActionName() {
        return "Fireball";
    }
}
