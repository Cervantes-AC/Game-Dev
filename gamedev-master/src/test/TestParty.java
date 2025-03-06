package test;

import charsys.RPGCharacter;
import charsys.Warrior;
import charsys.role.CharacterRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import party.Party;

public class TestParty {

    @BeforeEach
    public void prep() {
        /*
            Prepares a party object with 9 RPGCharacters. You may change it however you want.
         */
        Party party = new Party();

        RPGCharacter character1 = new Warrior("Leon");
        RPGCharacter character2 = new Warrior("Johnson", CharacterRole.TANK);
    }

    @Test
    public void test1() {

    }
}
