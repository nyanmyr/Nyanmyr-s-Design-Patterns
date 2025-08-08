package memento;

// originator
class Light {
    
    private boolean status;
    
    public void toggle() {
        status = !status;
    }
    
    public void observe() {
        System.out.println("The light is currently " + (status ? "on" : "off"));
    }
    
    public Meme save() {
        return new Meme(status);
    }
    
    public void load(Meme memento) {
        status = memento.status;
    }
    
    // memento
    public class Meme {
        
        private boolean status;
        
        private Meme(boolean status) {
            this.status = status;
        }
    }
}

// caretaker
public class Memento {

    public static void main(String[] args) {
        
        Light light = new Light();
        Light.Meme memento = light.save();
        
        light.observe();
        light.toggle();
        
        // memento in action
        light.observe();
        light.load(memento);
        light.observe();
    }
}
