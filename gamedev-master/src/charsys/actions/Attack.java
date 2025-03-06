package charsys.actions;

import charsys.RPGCharacter;
import pos.Position;

/**
 * A single target attack action.
 */
public class Attack implements Actionable {

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
        System.out.printf("%s attacks %s!\n\n", source.getName(), target.getName());
    }

    public String getActionName() {
        return "Attack";
    }
}