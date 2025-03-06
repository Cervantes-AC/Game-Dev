package charsys.actions;

import charsys.RPGCharacter;

/**
 * An action that increases the attack damage to a target RPGCharacter.
 */
public class Inspire implements Actionable {
    @Override
    public TargetType getTargetType() {
        return TargetType.SELF;
    }

    @Override
    public TargetParty getTargetPartySelector() {
        return TargetParty.SELF;
    }

    @Override
    public void performAction(RPGCharacter source, RPGCharacter target)
    {
        System.out.printf("%s buffed %s!\n\n", source.getName(), target.getName());
    }

    @Override
    public String getActionName() {
        return "Inspire";
    }
}
