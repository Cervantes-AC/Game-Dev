package turnsys;

import charsys.RPGCharacter;

/**
 * Monitors the round order of a character. Basically, it checks whether a particular character can execute
 * an act for the current round order in the Turn System.
 */
public class TurnEntry {

    private final RPGCharacter character;
    private int roundOrder = 0;

    public TurnEntry(RPGCharacter character) {
        this.character = character;
    }

    public TurnEntry(RPGCharacter character, int roundOrder) {
        this.character = character;
        this.roundOrder = roundOrder;
    }

    public int getRoundOrder() {
        return roundOrder;
    }

    /**
     * Increases a character's order count by 1. Refer to {@link #increaseRounderOrder(int)} for more info.
     */
    public void increaseRoundOrder() {
        this.increaseRounderOrder(1);
    }

    /**
     * Increases a character's order count. This happens when a character executes their action for a turn
     * and finishes it.
     * <br>
     * This can also be used together with status effects, e.g. stun, where the count is based on the number of turns
     * a character has missed because they were stunned (or any other similar status effect).
     * @param count Number of round orders to increases. Usually 1.
     */
    public void increaseRounderOrder(int count) {
        this.roundOrder += count;
    }

    public RPGCharacter getCharacter() {
        return character;
    }
}
