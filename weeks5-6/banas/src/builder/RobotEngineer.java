package builder;

// The director / engineer class creates a Robot using the
// builder interface that is defined (OldRobotBuilder)

public class RobotEngineer {

    private final RobotBuilder robotBuilder;

    // OldRobotBuilder specification is sent to the engineer

    public RobotEngineer(RobotBuilder robotBuilder) {
        this.robotBuilder = robotBuilder;
    }

    // Return the Robot made from the OldRobotBuilder spec

    public Robot getRobot() {
        return robotBuilder.getRobot();
    }

    // Execute the methods specific to the RobotBuilder
    // that implements RobotBuilder (OldRobotBuilder)

    public void makeRobot() {
        robotBuilder.buildRobotHead();
        robotBuilder.buildRobotTorso();
        robotBuilder.buildRobotArms();
        robotBuilder.buildRobotLegs();
    }
}