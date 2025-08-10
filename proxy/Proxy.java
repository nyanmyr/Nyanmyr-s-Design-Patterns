package proxy;

// shared interface
interface Border {
    
    void enter(Immigrant immigrant);
}

// proxy
class BorderCheckpoint implements Border {
    
    BorderExit borderExit;
    
    BorderCheckpoint(BorderExit borderExit) {
        this.borderExit = borderExit;
    }
    
    public void enter(Immigrant immigrant) {
        System.out.println(immigrant.name + "'s credentials are checked at the checkpoint.");
        if (immigrant.matchingCredentials) {
            System.out.println(immigrant.name + "'s credentials match and is granted passage.");
            borderExit.enter(immigrant);
        } else {
            System.out.println(immigrant.name + "'s credentials are found to be fradulent and is denied passage.\n");
        }
    }
}

// subject
class BorderExit implements Border {
    
    public void enter(Immigrant immigrant) {
        System.out.println(immigrant.name + " exits the border checkpoint and enters the glorious state of Arstotzka.\n");
    }
}

// client
class Immigrant {
    
    String name;
    boolean matchingCredentials;
    
    Immigrant(String name, boolean matchingCredentials) {
        this.name = name;
        this.matchingCredentials = matchingCredentials;
    }
}

public class Proxy {

    public static void main(String[] args) {
        // clients instantiation
        Immigrant boris = new Immigrant("Boris", true);
        Immigrant mikhail = new Immigrant("Mikhail", true);
        Immigrant jorji = new Immigrant("Jorji", false);
        
        // proxy and subject instantiation
        BorderCheckpoint grestinBorderCheckpoint = new BorderCheckpoint(new BorderExit());
        
        // clients proxy interaction
        grestinBorderCheckpoint.enter(boris);
        grestinBorderCheckpoint.enter(mikhail);
        grestinBorderCheckpoint.enter(jorji);
    }
}
