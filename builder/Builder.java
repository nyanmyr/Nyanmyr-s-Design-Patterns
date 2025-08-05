package builder;

// building/ product
class House {

    int doors;
    int windows;
    int rooms;
    String name;

    House(int doors, int windows, int rooms, String name) {
        this.doors = doors;
        this.windows = windows;
        this.rooms = rooms;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s has %s doors, %s windows, and %s rooms.", name, doors, windows, rooms);
    }
}

class Architect {

    int doors;
    int windows = 0;
    int rooms = 0;
    String name;

    Architect(int doors, String name) {
        if (doors < 1) {
            throw new RuntimeException("House cannot have no doors!");
        } else if (name == null) {
            throw new RuntimeException("Name cannot have no doors!");
        }
        this.doors = doors;
        this.name = name;
    }

    public Architect addWindows(int windows) {
        this.windows += windows;
        return this;
    }

    public Architect addRooms(int rooms) {
        this.rooms += rooms;
        return this;
    }

    public House build() {
        return new House(doors, windows, rooms, name);
    }
}

// builder
public class Builder {

    public static void main(String[] args) {
        House smallHouse = new Architect(1, "Small House")
                .addRooms(2)
                .addWindows(4)
                .build();

        House bigHouse = new Architect(2, "Big House")
                .addRooms(4)
                .addWindows(8)
                .build();
        
        System.out.println(smallHouse.toString());
        System.out.println(bigHouse.toString());
    }
}
