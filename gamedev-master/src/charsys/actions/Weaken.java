package charsys.actions;

import charsys.RPGCharacter;

/**
 * A debuffing action that decreases the defense of a target RPGCharacter.
 */
public class Weaken implements Actionable {

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
        System.out.printf("%s decreases %s's defense!\n\n", source.getName(), target.getName());
    }

    @Override
    public String getActionName() {
        return "Weaken";
    }
}
