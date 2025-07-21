package state;

abstract class CatState {

    abstract void changeState(Cat cat);

    abstract void observe();
}

class IdleState extends CatState {

    @Override
    public void changeState(Cat cat) {
        System.out.println("The cat decides to eat cat food.");
        cat.state = new EatingState();
    }

    @Override
    public void observe() {
        System.out.println("The cat is idling.");
    }
}

class EatingState extends CatState {

    @Override
    public void changeState(Cat cat) {
        System.out.println("The cat decides to drink some water.");
        cat.state = new DrinkingState();
    }

    @Override
    public void observe() {
        System.out.println("The cat is eating cat food.");
    }
}

class DrinkingState extends CatState {

    @Override
    public void changeState(Cat cat) {
        System.out.println("The cat decides to idle.");
        cat.state = new IdleState();
    }

    @Override
    public void observe() {
        System.out.println("The cat is drinking water.");
    }
}

class Cat {

    CatState state;

    public Cat() {
    }

    public void changeState() {
        state.changeState(this);
    }

    public void observe() {
        state.observe();
    }
}

public class State {

    public static void main(String[] args) {

        Cat myCat = new Cat();
        myCat.observe();
        myCat.changeState();
        myCat.observe();
        myCat.changeState();
        myCat.observe();
        myCat.changeState();
        myCat.observe();
    }
}
