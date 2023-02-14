package factory;

public class UFOEnemyShip extends EnemyShip {

    public UFOEnemyShip() {
        super("UFO Enemy Ship", 20.0);
    }

    protected UFOEnemyShip(String name, double amtDamage) {
        super(name, amtDamage);
    }
}