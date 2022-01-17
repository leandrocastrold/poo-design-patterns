package behaviors;

import Interfaces.Combat;
import Models.Character;

public class EnemyCombatBehavior implements Combat {

    private Character character;
    private Character characterTarget;

    public EnemyCombatBehavior(Character character) {
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
        System.out.println(character.getName()+ " Atacou " + characterTarget.getName() + " com a Espada!");
        int targetHPLeft = characterTarget.getHitPoints() - character.getAttackPoints();
        characterTarget.setHitPoints(targetHPLeft);
    }

    @Override
    public void useSkill() {

    }

    @Override
    public void usePotion() {
        System.out.println(character.getName()+ " usou poção de cura!");
    }

}
