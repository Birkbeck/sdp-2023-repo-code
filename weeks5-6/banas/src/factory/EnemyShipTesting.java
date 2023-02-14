package factory;

import java.util.Scanner;

public class EnemyShipTesting {

    public static void main(String[] args) {

        // Create the factory object
        EnemyShipFactory shipFactory = new EnemyShipFactory();

        Scanner userInput = new Scanner(System.in);

        System.out.print("What type of ship? (U / R / B)");

        if (userInput.hasNextLine()) {

            String typeOfShip = userInput.nextLine();

            // Enemy ship object
            EnemyShip theEnemy = shipFactory.makeEnemyShip(typeOfShip);

            if (theEnemy != null) {
                doStuffEnemy(theEnemy);
            }
            else {
                System.out.print("Please enter U, R, or B next time");
            }
        }
    }

    // Executes methods of the super class

    public static void doStuffEnemy(EnemyShip enemyShip) {
        enemyShip.displayEnemyShip();
        enemyShip.followHeroShip();
        enemyShip.enemyShipShoots();
    }
}