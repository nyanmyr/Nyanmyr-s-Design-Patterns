package decorator;

interface Weapon {

    int attackPower();

    void attack();
}

class Sword implements Weapon {

    @Override
    public int attackPower() {
        return 10;
    }

    public void useSlashAttack() {
        System.out.println("Attack power: " + attackPower());
    }

    @Override
    public void attack() {
        System.out.println("You swing your sword.");
    }
}

class FireEnchantment extends Sword {

    protected Weapon weapon;

    public FireEnchantment(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int attackPower() {
        return weapon.attackPower() + 25;
    }

    @Override
    public void attack() {
        weapon.attack();
        System.out.println("Your weapon sword burns like fire.");
    }
}

class IceEnchantment extends Sword {

    protected Weapon weapon;

    public IceEnchantment(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int attackPower() {
        return weapon.attackPower() + 15;
    }
    
    @Override
    public void attack() {
        weapon.attack();
        System.out.println("Your weapon sword shimmers like ice.");
    }
}

public class Decorator {

    public static void main(String[] args) {

        // mySword is instantiated
        Sword mySword = new Sword();
        mySword.useSlashAttack();
        mySword.attack();
        System.out.println();

        // mySword is enchanted with fire.
        mySword = new FireEnchantment(mySword);
        mySword.useSlashAttack();
        mySword.attack();
        System.out.println();
        
        // mySword is enchanted with ice.
        mySword = new IceEnchantment(mySword);
        mySword.useSlashAttack();
        mySword.attack();
        System.out.println();
        
        // mySword is enchanted with ice but its previous enchantments are gone.
        mySword = new IceEnchantment(new Sword());
        mySword.useSlashAttack();
        mySword.attack();
    }

}
