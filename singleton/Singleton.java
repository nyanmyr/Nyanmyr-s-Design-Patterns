package singleton;

class Philippines {
    
    public static final Philippines INSTANCE = new Philippines();
    
    private static String capital = "Manila";
    private static String languages = "Filipino, English";
    private static String location = "South East Asia";
    
    private Philippines() {
    }
    
    public String getCapital() {
        return capital;
    }
    
    public String getLanguages() {
        return languages;
    }
    
    public String getLocation() {
        return location;
    }
}

public class Singleton {

    public static void main(String[] args) {
        
        System.out.println("The capital of the Philippines is " + Philippines.INSTANCE.getCapital());
        System.out.println("The languages of the Philippines are " + Philippines.INSTANCE.getLanguages());
        System.out.println("The Philippines is located in " + Philippines.INSTANCE.getLocation());
    }
}
