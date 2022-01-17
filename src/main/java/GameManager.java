import behaviors.CombatBehavior;
import behaviors.IABehaviour;
import Models.Character;
import Models.Goblin;
import Models.Warrior;

import java.util.Locale;
import java.util.Scanner;

public class GameManager {

    private static GameManager instance;
    Character player;
    Goblin enemy;
    boolean isGameOver = false;
    Scanner scanner = new Scanner(System.in);

    enum ActorsType {PLAYER, ENEMY}

    ActorsType currentActor = ActorsType.PLAYER;

    private GameManager() {
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void start() {
        player = new Warrior(35, 20);
        CombatBehavior playerCombatBehavior = new CombatBehavior(player);
        player.setCombatBehavior(playerCombatBehavior);

        enemy = new Goblin(20, 20);
        CombatBehavior enemyCombatBehavior = new CombatBehavior(enemy);
        enemy.setCombatBehavior(enemyCombatBehavior);
        enemy.setArtificialInteligence(new IABehaviour(enemyCombatBehavior));

        playerCombatBehavior.setCharacterTarget(enemy);
        enemyCombatBehavior.setCharacterTarget(player);

        showCharactersInfo();
        while (!isGameOver) {
            if (currentActor == ActorsType.PLAYER) {
                showMenu();
            } else {
                activateEnemyTurn();
            }
        }

        System.out.println("FIM DE BATALHA!");
    }

    private void showMenu() {


        System.out.println("TURN RPG\n\n" +
                "[1] - ATACAR\n" +
                "[2] - USAR HABILIDADE\n" +
                "[3] - USAR POÇÃO DE CURA\n" +
                "[0] - SAIR\n");
        System.out.print("AÇÃO: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                player.getCombatBehavior().attack();
                break;
            case 2:
                System.out.println("HABILIDADA NÃO IMPLEMENTADA");
                break;
            case 3:
                player.getCombatBehavior().usePotion();
                break;
            case 0:
                System.exit(0);
        }
        checkGameOver();
        changeCurrentActor();
    }

    private void changeCurrentActor() {
        showCharactersInfo();
        pauseGame();
        if (currentActor == ActorsType.PLAYER) {
            currentActor = ActorsType.ENEMY;
        } else {
            currentActor = ActorsType.PLAYER;
        }
    }

    private void checkGameOver() {
        if (player.getHitPoints() > 0 && enemy.getHitPoints() > 0) {
            isGameOver = false;
        } else {
            isGameOver = true;
        }
    }

    private void pauseGame() {
        System.out.println("\nAPERTE ENTER PARA CONTINUAR...\n");
        scanner.nextLine();
    }

    private void activateEnemyTurn() {
        enemy.getArtificialInteligence().decideAction();
        checkGameOver();
        changeCurrentActor();
    }

    private void showCharactersInfo() {
        System.out.println("\n" + player.getName().toUpperCase(Locale.ROOT) + ": [" + player.getHitPoints() + "] HP");
        System.out.println(enemy.getName().toUpperCase(Locale.ROOT) + ": [" + enemy.getHitPoints() + "] HP\n");
    }
}
