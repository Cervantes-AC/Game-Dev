package party;

import charsys.RPGCharacter;
import helper.ColumnReverser;
import pos.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Party {
    public static final int MAX_ROWS = 3, MAX_COLS = 3;
    private final boolean reversed;
    private final RPGCharacter[][] partyGrid;

    public Party() {
        this(false);
    }

    /**
     * Creates a party object that contains RPGCharacter objects.
     * @param reversed Flag if the positioning of characters must be reversed or not.
     *                 <br>
     *                 Set to true if the party to be created is for an enemy.
     */
    public Party(boolean reversed) {
        this.partyGrid = new RPGCharacter[MAX_ROWS][MAX_COLS];
        this.reversed = reversed;
    }

    public RPGCharacter getCharacterAtPos(int row, int col) {
        return this.partyGrid[row][col];
    }

    public RPGCharacter getCharacterAtPos(Position position) {
        return this.partyGrid[position.getRow()][position.getCol()];
    }

    private void setCharacterAtPos(RPGCharacter character, Position pos) {
        this.partyGrid[pos.getRow()][pos.getCol()] = character;
    }

    /**
     * Checks if a character is present on the row and column.
     * @param row Row index. 0 <= row <= 2.
     * @param col Column index. 0 <= col <= 2.
     * @return True if empty, false if not.
     */
    public boolean isEmpty(int row, int col) {
        return this.partyGrid[row][col] == null;
    }

    /**
     * Automatically adds a character into the party formation using the
     * auto-positioning logic based on a character's preferred column indexes.
     * @param character RPGCharacter object to be automatically added.
     */
    public void addToPartyAuto(RPGCharacter character) {
        Position position = findOptimalPosition(character);
        if(position == null) {
            System.out.printf("No valid position for %s.\n", character.getName());
            return;
        }
        this.setCharacterAtPos(character, position);
        character.setPosition(position);
    }

    /**
     * Finds the optimal position of this character based on their preferred columns.
     * @param character Character to be placed.
     * @return Position object if a position is available. Null if party formation is full.
     */
    private Position findOptimalPosition(RPGCharacter character) {
        return this.findFirstAvailablePosition(character.getPreferredColumns());
    }

    /**
     * Finds the first available position based on the preferred columns given by the character.
     * It will iterate through the first preferred column to the least preferred column.
     * <br>
     * If no position is available, then it means that the party formation is full.
     * @param columns List of preferred columns from an RPGCharacter object.
     * @return Position object if a position is available. Null otherwise.
     */
    private Position findFirstAvailablePosition(List<Integer> columns) {
        /*
             Copy RPGCharacter's columns.
             Check first if the party grid should utilize a reversed way of positioning.
             If it is reversed, then reverse the character's column preferences.
         */
        List<Integer> cols = new ArrayList<>(this.reversed ? ColumnReverser.reverseCharacterColumns(columns)
            : columns);

        for(int col: cols) {
            for(int row = 0; row < MAX_ROWS; row++) {
                if(isEmpty(row, col)) {
                    return new Position(row, col);
                }
            }
        }
        return null;
    }

    /**
     * Displays the name of each character in their respected positions.
     * Some cells that are empty will display [ Empty ].
     */
    public void displayParty() {
        for(int row = 0; row < MAX_ROWS; row++) {
            for(int col = 0; col < MAX_COLS; col++) {
                if(isEmpty(row, col)) {
                    System.out.print("[ Empty ]");
                }
                else {
                    System.out.printf("[ %s ]", getCharacterAtPos(row, col).getName());
                }
            }
            System.out.println();
        }
    }


    /**
     * Get the party members included in this Party object.
     * @return Collection of party members inside a list.
     */
    public List<RPGCharacter> getPartyMembers() {
        List<RPGCharacter> participants = new ArrayList<>();
        for(RPGCharacter[] row: partyGrid) {
            for(RPGCharacter character: row) {
                if(character != null) // Safety check
                    participants.add(character);
            }
        }
        return participants;
    }

    /**
     * Checks whether this Party object contains the specified character object.
     * <br>
     * Mainly used in targeting system to determine which party should the target pointer point into.
     * @param ch Character to check.
     * @return True if that character object is in this party. False otherwise.
     */
    public boolean contains(RPGCharacter ch) {
        for(RPGCharacter[] row: partyGrid) {
            for(RPGCharacter character: row) {
                if(character == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Gets the Position of the selected index from the party formation.
     * @param index Index.
     * @param reversed Flag if the retrieval of index is reversed.
     *                 <br>
     *                 Used if the position to be retrieved is from the player party. Only to be utilized for
     *                 AI-based targeting.
     * @return Position object containing the row and column of the selected index.
     */
    public static Position getPositionBasedOnIndex(int index, boolean reversed) {
        int row, col;

        /*
            Row assignment cycles on 0, 1, and 2.
         */
        row = index % 3;

        switch (index) {
            case 1:
            case 2:
            case 3:
                col = 0;
                break;
            case 4:
            case 5:
            case 6:
                col = 1;
                break;
            case 7:
            case 8:
            case 9:
                col = 2;
                break;
            default:
                // Invalid indexing
                return null;
        }
        if(reversed) {
            col = 2 - col;
        }

        return new Position(row, col);
    }
}
