package inputsys;

import charsys.RPGCharacter;
import charsys.actions.Actionable;
import party.Party;
import pos.Position;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PlayerInput {

    private static final Scanner input = new Scanner(System.in);

    /**
     * Prompts the player to select an action from the list of actions of an RPGCharacter object.
     * @param actions RPGCharacter's actions.
     * @return Action chosen by player.
     */
    public static Actionable selectPlayerAction(List<Actionable> actions) {
        System.out.println();
        Actionable chosen;
        while(true) {
            try {
                System.out.print("Select an action: ");
                int index = input.nextInt() - 1;
                chosen = actions.get(index);
                break;
            } catch(IndexOutOfBoundsException exception) {
                System.err.println("Invalid action selected!");
            } catch(InputMismatchException exception) {
                System.err.println("Invalid action value selected!");
            }
        }
        return chosen;
    }

    /**
     * Prompts the user to select a valid target based on the list of valid targets.
     * @param validTargets  Position of valid targets.
     * @param targetParty Party object to select party from based on position.
     * @return Position object of the selected character.
     */
    public static RPGCharacter chooseValidTarget(List<Position> validTargets, Party targetParty) {
        int i = 1;
        // Target selection
        for(Position target : validTargets) {
            System.out.printf("[ %d ] %s\n", i, targetParty.getCharacterAtPos(target).getName());
            i += 1;
        }

        System.out.print("\nChoose a valid target: ");
        return targetParty.getCharacterAtPos(validTargets.get(input.nextInt() - 1));
    }
}
