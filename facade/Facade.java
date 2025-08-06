package facade;

// subsystem
class Robot {

    private final String name;

    Robot(String name) {
        this.name = name;
    }

    private void buildBody(Boolean showProcess) {
        if (showProcess) {
            System.out.println("Building body...");
            System.out.println("\tBody Built [25%]");
            System.out.println("\tBody Built [50%]");
            System.out.println("\tBody Built [100%]");
        }
    }

    private void buildArms(Boolean showProcess) {
        if (showProcess) {
            System.out.println("Building arms...");
            System.out.println("\tArms Built [25%]");
            System.out.println("\tArms Built [50%]");
            System.out.println("\tArms Built [100%]");
        }
    }

    private void buildLegs(Boolean showProcess) {
        if (showProcess) {
            System.out.println("Building legs...");
            System.out.println("\tLegs Built [25%]");
            System.out.println("\tLegs Built [50%]");
            System.out.println("\tLegs Built [100%]");
        }
    }

    private void buildHead(Boolean showProcess) {
        if (showProcess) {
            System.out.println("Building head...");
            System.out.println("\tHead Built [25%]");
            System.out.println("\tHead Built [50%]");
            System.out.println("\tHead Built [100%]");
        }
    }

    private void buildCore(Boolean showProcess) {
        if (showProcess) {
            System.out.println("Building core...");
            System.out.println("\tCore Built [25%]");
            System.out.println("\tCore Built [50%]");
            System.out.println("\tCore Built [100%]");
        }
    }

    protected Robot buildRobot(Boolean showProcess) {
        if (showProcess) {
            System.out.println("Building Robot: ");
        }
        
        buildBody(showProcess);
        buildArms(showProcess);
        buildLegs(showProcess);
        buildHead(showProcess);
        buildCore(showProcess);
        
        return this;
    }

    @Override
    public String toString() {
        return name + " is ready for robot stuff.";
    }
}

// facade
class RobotShop {

    private final Boolean showProcess;
    
    RobotShop(boolean showProcess) {
        this.showProcess = showProcess;
    }
    
    public Robot buyRobot(String name) {
        return new Robot(name).buildRobot(showProcess);
    }
}

public class Facade {

    public static void main(String[] args) {
        
        RobotShop robotShop1 = new RobotShop(true);
        Robot robert = robotShop1.buyRobot("Robert");
        System.out.println(robert.toString());

        RobotShop robotShop2 = new RobotShop(false);
        Robot goobert = robotShop2.buyRobot("Goobert");
        System.out.println(goobert.toString());
    }
}
