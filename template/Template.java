package template;

// template
abstract class RouteToNextCity {

    protected abstract void startRoute();

    protected abstract void takeBreak();

    protected abstract void reachCapital();
    
    public final void start() {
        startRoute();
        takeBreak();
        reachCapital();
    }
}

// concrete templates
class LeftRoute extends RouteToNextCity {

    @Override
    protected void startRoute() {
        System.out.println("The traveller takes the left route.");
    }

    @Override
    protected void takeBreak() {
        System.out.println("The traveller takes a rest beside the river.");
    }

    @Override
    protected void reachCapital() {
        System.out.println("The traveller reaches the next city and enters through the west gate.\n");
    }
}

class RightRoute extends RouteToNextCity {

    @Override
    protected void startRoute() {
        System.out.println("The traveller takes the right route.");
    }

    @Override
    protected void takeBreak() {
        System.out.println("The traveller takes a rest beside the lake.");
    }

    @Override
    protected void reachCapital() {
        System.out.println("The traveller reaches the next city and enters through the east gate.\n");
    }
}

// client
class Traveller {

    RouteToNextCity route;

    Traveller(RouteToNextCity route) {
        this.route = route;
    }

    public void takeRoute() {
        route.start();
    }

    public void changeRoute(RouteToNextCity route) {
        this.route = route;
    }
}

public class Template {

    public static void main(String[] args) {
        
        Traveller traveller = new Traveller(new LeftRoute());
        traveller.takeRoute();
        
        traveller.changeRoute(new RightRoute());
        traveller.takeRoute();
    }
}
