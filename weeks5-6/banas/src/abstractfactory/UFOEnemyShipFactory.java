package abstractfactory;

/// This factory uses the EnemyShipFactory interface
// to create very specific UFO Enemy Ship

// This is where we define all the parts the ship
// will use by defining the methods implemented
// being ESWeapon and ESEngine

// The returned object specifies a specific weapon & engine

public class UFOEnemyShipFactory implements EnemyShipFactory {

    // Defines the weapon object to associate with the ship

    @Override
    public ESWeapon addESGun() {
        return new ESUFOGun(); // Specific to regular UFO
    }

    // Defines the engine object to associate with the ship

    @Override
    public ESEngine addESEngine() {
        return new ESUFOEngine(); // Specific to regular UFO
    }
}