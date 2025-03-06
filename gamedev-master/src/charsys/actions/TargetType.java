package charsys.actions;

/**
 * Used for determining an action's target type.
 * <br>
 * To customize which target to choose from (enemy party or ally party), refer to {@link TargetParty}
 * enumerations.
 */
public enum TargetType {
    /**
     * Single-based targeting type. May refer to an enemy or an ally.
     */
    SINGLE,
    /**
     * Multi-based targeting type. Doesn't mean selecting multiple targets, but it means that a single
     * cell is selected but the action's effect may include more than one RPGCharacter.
     */
    MULTI,
    /**
     * Single-based targeting type. May refer to an empty cell, or a cell containing an RPGCharacter object.
     */
    AOE,
    /**
     * Self-based single targeting type. Primarily used in item usage, and some buffing/healing actions.
     */
    SELF
}
