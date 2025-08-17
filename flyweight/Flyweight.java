package flyweight;

import java.util.HashMap;
import java.util.Map;

// flyweight interface
interface CyberneticModule {

    void describe();
}

// concrete flyweights
class CyberneticArms implements CyberneticModule {

    public void describe() {
        System.out.println("Cybernetic arms increases strength in the upper body.");
    }

    public String toString() {
        return "Cybernetic Arms";
    }
}

class CyberneticLegs implements CyberneticModule {

    public void describe() {
        System.out.println("Cybernetic legs increases strength in the lower body.");
    }

    public String toString() {
        return "Cybernetic Legs";
    }
}

// flyweight provider
class CyberneticsFlyweights {

    private static final Map<String, CyberneticModule> cybernetics = new HashMap<>();

    public static CyberneticModule getCyberneticModule(String module) {
        return cybernetics.computeIfAbsent(module, type -> {
            switch (type) {
                case "Cybernetic Arms" -> {
                    return new CyberneticArms();
                }
                case "Cybernetic Legs" -> {
                    return new CyberneticLegs();
                }
                default ->
                    throw new RuntimeException("Unknown module: " + type);
            }
        });
    }
}

// context
class Cyborg {

    String name;
    CyberneticModule cyberneticModule;

    Cyborg(String name, CyberneticModule cyberneticModule) {
        this.name = name;
        this.cyberneticModule = cyberneticModule;
        describeCyberneticModule();
    }

    public void changeCyberneticModule(CyberneticModule cyberneticModule) {
        this.cyberneticModule = cyberneticModule;
        describeCyberneticModule();
    }

    private void describeCyberneticModule() {
        System.out.println(name + " equips " + cyberneticModule);
        cyberneticModule.describe();
    }
;

}

public class Flyweight {

    public static void main(String[] args) {

        Cyborg genos = new Cyborg("Genos", CyberneticsFlyweights.getCyberneticModule("Cybernetic Legs"));
        genos.changeCyberneticModule(CyberneticsFlyweights.getCyberneticModule("Cybernetic Arms"));

        Cyborg driveKnight = new Cyborg("Drive Knight", CyberneticsFlyweights.getCyberneticModule("Cybernetic Arms"));

        System.out.printf("Is %s and %s using the same cybernetic module instance? %s\n", genos.name, driveKnight.name,
                ((genos.cyberneticModule == driveKnight.cyberneticModule) ? "Yes" : "No"));
    }
}
