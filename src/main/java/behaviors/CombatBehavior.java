package behaviors;

import Interfaces.Combat;
import Models.Character;

public class CombatBehavior implements Combat {

    private Character character;
    private Character characterTarget;

    public CombatBehavior(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getCharacterTarget() {
        return characterTarget;
    }

    public void setCharacterTarget(Character characterTarget) {
        this.characterTarget = characterTarget;
    }

    @Override
    public void attack() {
        System.out.println(character.getName()+ " Atacou " + characterTarget.getName() + "!");
        int targetHPLeft = characterTarget.getHitPoints() - character.getAttackPoints();
        characterTarget.setHitPoints(targetHPLeft);
    }

    @Override
    public void useSkill() {

    }

    @Override
    public void usePotion() {
        character.setHitPoints(character.getHitPoints() + 20);
        if (character.getHitPoints() >= 100) {
            character.setHitPoints(100);
        }
        System.out.println(character.getName()+ " usou poção de cura!");
    }

}
