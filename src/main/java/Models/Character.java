package Models;

import Interfaces.Combat;

public class Character {

    private int hitPoints;
    private String name;
    private int attackPoints;
    private int defensePoints;
    private int potions;
    private Combat combatBehavior;

    public Character() {
    }

    public Character(int hitPoints, String name, int attackPoints, int defensePoints) {
        this.hitPoints = hitPoints;
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.potions = 3;
    }

    public int getPotions() {
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public Combat getCombatBehavior() {
        return combatBehavior;
    }

    public void setCombatBehavior(Combat combatBehavior) {
        this.combatBehavior = combatBehavior;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", attackPoints=" + attackPoints +
                ", defensePoints=" + defensePoints +
                '}';
    }
}
