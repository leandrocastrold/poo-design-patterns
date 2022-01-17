package Models;

import Interfaces.ArtificialInteligence;

public class Goblin extends Character{

    private ArtificialInteligence artificialInteligence;

    public Goblin() {
    }

    public Goblin(int attackPoints, int defensePoints) {
        super(100, "Goblin", attackPoints, defensePoints);
    }

    public ArtificialInteligence getArtificialInteligence() {
        return artificialInteligence;
    }

    public void setArtificialInteligence(ArtificialInteligence artificialInteligence) {
        this.artificialInteligence = artificialInteligence;
    }
}
