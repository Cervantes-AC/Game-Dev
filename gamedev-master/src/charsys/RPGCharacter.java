package charsys;

import charsys.actions.Actionable;
import charsys.attrib.Attribute;
import charsys.attrib.CharacterStats;
import charsys.role.CharacterRole;
import charsys.role.CharacterType;
import pos.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class RPGCharacter {

    protected String name;
    protected int health, level;
    protected final List<Actionable> actions = new ArrayList<>();
    protected Position position;
    /**
     * Hero Type: MELEE, RANGED, or HYBRID
     */
    protected CharacterType type;
    /**
     * Primary role of this character. Maybe a Tank, Fighter, or something else.
     */
    protected CharacterRole primaryRole;
    /**
     * Optional secondary role of this character.
     */
    protected CharacterRole secondaryRole;
    /**
     * Determines the preferred columns that this character wants to be placed at
     * during party formations.
     * <br>
     * The first index refers to the most preferred column, and the second index
     * refers to the second most preferred column should the most preferred column is full.
     * The third index is the last fallback position for this character.
     */
    protected List<Integer> preferredColumns;
    /**
     * Character stats of this character.
     */
    protected CharacterStats stats = new CharacterStats();

    public RPGCharacter(String name, CharacterType type, CharacterRole primaryRole, List<Integer> preferredColumns) {
        this(name, type, primaryRole, null, preferredColumns);
    }

    public RPGCharacter(String name, CharacterType type, CharacterRole primaryRole, CharacterRole secondaryRole, List<Integer> preferredColumns) {
        this(name, -1, -1, type, primaryRole, secondaryRole, preferredColumns);
    }

    public RPGCharacter(String name, int row, int col, CharacterType type, CharacterRole primaryRole, List<Integer> preferredColumns) {
        this(name, row, col, type, primaryRole, null, preferredColumns);
    }

    public RPGCharacter(String name, int row, int col, CharacterType type, CharacterRole primaryRole, CharacterRole secondaryRole, List<Integer> preferredColumns) {
        this.name = name;
        this.position = new Position(row, col);
        this.type = type;
        this.primaryRole = primaryRole;
        this.secondaryRole = secondaryRole;
        this.preferredColumns = preferredColumns;
    }

    /**
     * Get the name of this character.
     * @return Character name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the position of a character into a new one.
     * @param position Position object containing new row and column values.
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    public void levelUp() {
        this.level++;
        System.out.printf("%s (%d) has leveled up!", this.name, this.level);
    }

    public List<Actionable> getActions() {
        return this.actions;
    }

    /**
     * Assign default actions to this character!
     */
    protected abstract void assignDefaultActions();

    /**
     * Adds a new action for this character.
     * @param action Additional action for this character.
     */
    public void addAction(Actionable action) {
        this.actions.add(action);
    }


    /**
     * Get the action class based on the given index.
     * <br>
     * 0 will return the default action to be executed by this character.
     * @return The default action to be performed.
     */
    public Actionable chooseAction(Integer index) {
        return this.actions.get(index);
    }

    /**
     * Presents this character's current row and column position in party formations.
     * @return Row and column at party formation.
     */
    public String getPosition() {
        return String.format("%s is at row %d and column %d.\n", this.name, this.position.getRow(), this.position.getCol());
    }

    public void setPreferredColumns(List<Integer> preferredColumns) {
        this.preferredColumns = preferredColumns;
    }

    /**
     * Checks if this character is a melee, ranged, or hybrid character.
     * @param type CharacterType value to check.
     * @return True or false.
     */
    public boolean hasType(CharacterType type) {
        return this.type == type;
    }

    /**
     * Checks if this character has a particular role in their primary or secondary role.
     * @param role CharacterRole value to check.
     * @return True or false.
     */
    public boolean hasRole(CharacterRole role) {
        // Check primary role first
        return this.primaryRole == role || (this.secondaryRole != null && this.secondaryRole == role);
    }

    public List<Integer> getPreferredColumns() {
        return this.preferredColumns;
    }

    public CharacterStats getStats() {
        return stats;
    }

    public int getCharacterStat(Attribute attribute) {
        return this.stats.getAttribute(attribute);
    }

    public void setCharacterStat(Attribute attribute, Integer value) {
        this.stats.setAttributes(attribute, value);
    }

    public void displayCharacterActions() {
        System.out.printf("%s's ACTIONS \n\n", this.name.toUpperCase());

        int i = 1;
        for(Actionable action: this.actions) {
            System.out.printf("[%d] %s\n", i, action.getActionName());
            i++;
        }
    }
}
