package charsys.actions;

import charsys.RPGCharacter;
import pos.Position;

import java.util.List;

public interface Actionable {

    /**
     * Target type of this action.
     * <br><br>
     * See {@link TargetType} for more info of target types.
     * @return Target type.
     *
     */
    public TargetType getTargetType();

    /**
     * Target party selection.
     * @return SELF if this action needs to target character's own party.
     * <br> OPPOSITE if this action needs to target enemy party.
     * <br> HYBRID for future interactions.
     */
    public TargetParty getTargetPartySelector();

    /**
     * An RPGCharacter performs an action against an RPGCharacter target.
     * @param source    RPGCharacter that initiated the action.
     * @param target    RPGCharacter that is receives the effects of that action.
     */
    public void performAction(RPGCharacter source, RPGCharacter target);

    /**
     * String-based name of this action.
     * @return String-based action name.
     */
    public String getActionName();
}
