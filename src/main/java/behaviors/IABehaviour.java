package behaviors;

import Interfaces.ArtificialInteligence;

public class IABehaviour implements ArtificialInteligence {

    private CombatBehavior behavior;

    public IABehaviour(CombatBehavior behavior) {
        this.behavior = behavior;
    }

    @Override
    public void decideAction() {
     System.out.println("Decidindo ação...");

     if (behavior.getCharacter().getHitPoints() < 50) {
         behavior.usePotion();
     } else {
         behavior.attack();
     }
    }
}
