package charsys.attrib;

import java.util.HashMap;
import java.util.Map;

public class CharacterStats {
    private final Map<Attribute, Integer> attributes;

    public CharacterStats() {
        this.attributes = new HashMap<>();
        // Optional Default attributes.
        this.attributes.put(Attribute.STRENGTH, 10);
        this.attributes.put(Attribute.AGILITY, 10);
        this.attributes.put(Attribute.INTELLIGENCE, 10);
    }

    public int getAttribute(Attribute attribute) {
        return this.attributes.getOrDefault(attribute, 0);
    }

    public void setAttributes(Attribute attribute, int value) {
        this.attributes.put(attribute, value);
    }
}
