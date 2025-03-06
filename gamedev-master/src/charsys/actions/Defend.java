package charsys.actions;

import charsys.RPGCharacter;

/**
 * A buffing action that increases the defense of a selected RPGCharacter.
 */
public class Defend implements Actionable {

    @Override
    public TargetType getTargetType() {
        return TargetType.SELF;
    }

    @Override
    public TargetParty getTargetPartySelector() {
        return TargetParty.SELF;
    }

    @Override
    public void performAction(RPGCharacter source, RPGCharacter target) {
        System.out.printf("%s chooses to defend against the next attack, increasing their defense!\n\n", source.getName());
    }

    @Override
    public String getActionName() {
        return "Defend";
    }
}
