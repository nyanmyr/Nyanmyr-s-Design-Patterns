package visitor;

// Visitor interface
interface Visits {
    void visit(Business business);
}

// Concrete Visitor
class TaxCollector implements Visits {
    @Override
    public void visit(Business business) {
        double collectedTax = business.getMoney() * 0.2;
        System.out.println("The Tax Collector collects " + collectedTax + " from " + business.getName());
    }
}

// Element interface
interface Visitable {
    void accept(Visits visitor);
}

// Concrete Element
class Business implements Visitable {
    private String name;
    private double money;

    Business(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public void accept(Visits visitor) {
        visitor.visit(this); // Double dispatch!
    }
}

public class Visitor {

    public static void main(String[] args) {
        
        Visits taxCollector = new TaxCollector();

        Business miners = new Business("Miners Co.", 1000);
        Business loggers = new Business("Loggers Co.", 1500);

        miners.accept(taxCollector);
        loggers.accept(taxCollector);
    }
}
