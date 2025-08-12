package prototype;

abstract class ProtoSlime<T> implements Cloneable {
    public T copy(String name) throws CloneNotSupportedException {
        System.out.println(name + " is performing mitosis to create a clone!\n");
        return (T) super.clone();
    }
}

class Slime extends ProtoSlime<Slime> {
    String name;
    String color;
    
    Slime(String color, String name) {
        this.name = name;
        this.color = color;
    }
    
    public void bounce() {
        System.out.println(name + " the " + color + " slime is bouncing up and down!");
    }
    
    public void changeName(String name) {
        System.out.println(this.name + " is changing their name to " + name);
        this.name = name;
    }
    
    public void changeColor(String color) {
        System.out.println(name + " is changing their color to " + color);
        this.color = color;
    }
}

public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        
        Slime bluey = new Slime("blue", "Bluey");
        bluey.bounce();
        
        Slime reddy = bluey.copy(bluey.name);
        reddy.changeName("Reddy");
        reddy.changeColor("red");
        bluey.bounce();
        reddy.bounce();
    }
}
