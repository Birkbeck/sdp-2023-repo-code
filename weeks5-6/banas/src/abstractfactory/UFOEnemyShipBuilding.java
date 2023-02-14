package abstractfactory;

// This is the only class that needs to change, if you
// want to determine which enemy ships you want to
// provide as an option to build

public class UFOEnemyShipBuilding extends EnemyShipBuilding {

    protected EnemyShip makeEnemyShip(String typeOfShip) {
        // If UFO was sent, use the factory that knows
        // what types of weapons and engines a regular UFO
        // needs. The EnemyShip object is given a name & returned
        if (typeOfShip.equals("UFO")) {
            EnemyShipFactory shipPartsFactory = new UFOEnemyShipFactory();
            EnemyShip theEnemyShip = new UFOEnemyShip(shipPartsFactory);
            theEnemyShip.setName("UFO Grunt Ship");
            return theEnemyShip;
        }
        // If UFO BOSS was sent, use the factory that knows
        // what types of weapons and engines a Boss UFO
        // needs. The EnemyShip object is given a name & returned
        else if (typeOfShip.equals("UFO BOSS")) {
            EnemyShipFactory shipPartsFactory = new UFOBossEnemyShipFactory();
            EnemyShip theEnemyShip = new UFOBossEnemyShip(shipPartsFactory);
            theEnemyShip.setName("UFO Boss Ship");
            return theEnemyShip;
        }
        return null;
    }
}
