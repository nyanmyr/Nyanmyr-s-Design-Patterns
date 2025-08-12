package adapter;

// adapter
class SwordSkillAdapter extends SpearSkill  {
    
    private final SwordSkill swordSkill;
    
    SwordSkillAdapter(SwordSkill swordSkill) {
        this.swordSkill = swordSkill;
    }
    
    @Override
    public void stab() {
        swordSkill.slash();
    }
}

// adaptee
class SwordSkill {
    
    public void slash() {
        System.out.println("The sword slashes!");
    }
}

// target
class SpearSkill {
    
    public void stab() {
        System.out.println("The spear stabs!");
    }
}

// client
class Warrior {
    
    private SpearSkill spearSkill;
    Warrior(SpearSkill spearSkill) {
        this.spearSkill = spearSkill;
    }
    
    public void changeWeapon(SpearSkill spearSkill) {
        
        this.spearSkill = spearSkill;
    }
    
    public void useWeapon() {
        spearSkill.stab();
    }
}

public class Adapter {

    public static void main(String[] args) {
        
        Warrior warrior = new Warrior(new SpearSkill());
        warrior.useWeapon();
        
        SwordSkillAdapter swordSkill = new SwordSkillAdapter(new SwordSkill());
        warrior.changeWeapon(swordSkill);
        warrior.useWeapon();
    }
}