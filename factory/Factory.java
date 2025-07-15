package factory;

// product interface
interface Pet {

    void makeNoise();
}

// <editor-fold desc="product examples">
class Dog implements Pet {

    @Override
    public void makeNoise() {
        System.out.println("Woof! Woof!");
    }
}

class Cat implements Pet {

    @Override
    public void makeNoise() {
        System.out.println("Meow! Meow!");
    }
}
// </editor-fold>

// factory
class PetStore {

    public Pet adoptPet(String pet) {
        switch(pet) {
            case "Dog" -> {
                return new Dog();
            }
            case "Cat" -> {
                return new Cat();
            }
            default -> throw new RuntimeException();
        }
    }
}

// example environment
public class Factory {

    public static void main(String[] args) {
        var petStore = new PetStore();
        
        Pet pet = petStore.adoptPet("Dog");
        pet.makeNoise();
        
        pet = petStore.adoptPet("Cat");
        pet.makeNoise();
    }
}
