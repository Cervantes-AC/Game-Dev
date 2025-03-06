import charsys.*;
import charsys.actions.Actionable;
import charsys.attrib.Attribute;
import charsys.role.CharacterRole;
import party.Party;
import pos.Position;
import turnsys.TurnManager;

import java.util.Scanner;

public class Game {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Party playerParty = new Party();

        RPGCharacter hero1 = new Warrior("Leon", CharacterRole.TANK);
        RPGCharacter hero2 = new Mage("Merlin", CharacterRole.BURST);
        RPGCharacter hero3 = new Cleric("Raul", CharacterRole.SUPPORT);

        hero1.setCharacterStat(Attribute.SPEED, 5);
        hero2.setCharacterStat(Attribute.SPEED, 6);
        hero3.setCharacterStat(Attribute.SPEED, 4);

        playerParty.addToPartyAuto(hero1);
        playerParty.addToPartyAuto(hero2);
        playerParty.addToPartyAuto(hero3);

        System.out.println("Player PARTY");
        playerParty.displayParty();

        // Enemy party composition
        // TODO: Try to play around the characters

        Party enemyParty = new Party(true);

        RPGCharacter enemy1 = new Warrior("Johnson", CharacterRole.TANK);
        RPGCharacter enemy2 = new Archer("Miya");
        RPGCharacter enemy3 = new Mage("Albus");

        enemy1.setCharacterStat(Attribute.SPEED, 3);
        enemy2.setCharacterStat(Attribute.SPEED, 7);
        enemy3.setCharacterStat(Attribute.SPEED, 2);

        enemyParty.addToPartyAuto(enemy1);
        enemyParty.addToPartyAuto(enemy2);
        enemyParty.addToPartyAuto(enemy3);

        System.out.println("Enemy PARTY");
        enemyParty.displayParty();

        // Create a Turn Manager object
        TurnManager turnManager = new TurnManager(playerParty, enemyParty);
        // Run
        turnManager.runTurnCycle();
    }
}