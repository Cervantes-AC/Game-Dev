package turnsys;

import charsys.attrib.Attribute;

import java.util.Comparator;

/**
 * A comparator class that compares if one character should go first
 * based on their TurnEntry round order index, and their SPEED attribute.
 * <br><br>
 * See {@link TurnEntry} to understand the TurnEntry class.
 * See {@link Attribute} for SPEED attribute reference.
 */
public class TurnComparator implements Comparator<TurnEntry> {

    /**
     * Compares two TurnEntry objects by checking of RPGCharacter A at TurnEntry A should go first in the
     * Turn System queue, or should RPGCharacter B at TurnEntry B should go first.
     * <br><br>
     * Checks RPGCharacter A's round order index first through TurnEntry A, against TurnEntry B containing
     * RPGCharacter B.
     * <br><br>
     * If both TurnEntry objects has the same round order, then compare the SPEED attributes of each RPGCharacter
     * on those TurnEntry. The RPGCharacter with a higher SPEED attribute will go first.
     * <br><br>
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return -1, 0, 1.
     */
    @Override
    public int compare(TurnEntry o1, TurnEntry o2) {
        if(o1.getRoundOrder() != o2.getRoundOrder()) {
            return Integer.compare(o1.getRoundOrder(), o2.getRoundOrder());
        }

        return Integer.compare(o2.getCharacter().getCharacterStat(Attribute.SPEED),
                o1.getCharacter().getCharacterStat(Attribute.SPEED));
    }
}
