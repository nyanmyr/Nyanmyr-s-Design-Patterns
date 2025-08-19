package bridge;

interface Hero {

    void usePower();
}

class Fighter implements Hero {

    private final Power power;

    Fighter(Power power) {
        this.power = power;
    }

    @Override
    public void usePower() {
        System.out.print("Fighter uses their skill and ");
        power.activate();
    }
}

class Mage implements Hero {

    private final Power power;

    Mage(Power power) {
        this.power = power;
    }

    @Override
    public void usePower() {
        System.out.print("Mage uses their skill and ");
        power.activate();
    }
}

interface Power {

    void activate();

}

class Rage implements Power {

    @Override
    public void activate() {
        System.out.println("becomes enraged!");
    }
}

class MagicMissile implements Power {

    @Override
    public void activate() {
        System.out.println("fires a magic missile!");
    }
}

public class Bridge {

    public static void main(String[] args) {

        Fighter fighter = new Fighter(new MagicMissile());
        Mage mage = new Mage(new Rage());

        fighter.usePower();
        mage.usePower();
    }
}
