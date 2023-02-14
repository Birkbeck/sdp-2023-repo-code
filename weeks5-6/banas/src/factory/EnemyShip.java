package factory;

public abstract class EnemyShip {

    private final String name;
    private final double amtDamage;
    private double speed;
    private double directionX;
    private double directionY;

    EnemyShip(String name, double amtDamage) {
        this.name = name;
        this.amtDamage = amtDamage;
    }

    public String getName() {
        return name;
    }

    public double getDamage() {
        return amtDamage;
    }

    public void followHeroShip() {
        System.out.println(getName() + " is following the hero");
    }

    public void displayEnemyShip() {
        System.out.println(getName() + " is on the screen");
    }

    public void enemyShipShoots() {
        System.out.println(getName() + " attacks and does " + getDamage() + " damage to hero");
    }
}