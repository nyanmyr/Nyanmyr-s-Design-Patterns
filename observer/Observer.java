package observer;

import java.util.LinkedList;
import java.util.List;

interface WeatherObserver {

    void update(String weather);
}

class NewsChannel implements WeatherObserver {

    private String name;
    
    public NewsChannel(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String weather) {
        switch (weather) {
            case "Sunny" -> {
                System.out.printf("%s reports about the sunny weather.\n", name);
            }
            case "Cloudy" -> {
                System.out.printf("%s reports about the cloudy weather.\n", name);
            }
            case "Rainy" -> {
                System.out.printf("%s reports about the rainy weather.\n", name);
            }
        }
    }
}

class WeatherEnvironment {
    
    private String currentWeather;
    private List<WeatherObserver> observers = new LinkedList<>();
    
    public void addObserver(WeatherObserver obs) {
        observers.add(obs);
    }
    
    public void removeObserver(WeatherObserver obs) {
        observers.remove(obs);
    }
    
    public void updateWeather(String newWeather) {
        System.out.println("Weather changed to: " + newWeather);
        currentWeather = newWeather;
        notifyObservers();
        System.out.println();
    }
    
    private void notifyObservers() {
        for (var obs : observers) {
            obs.update(currentWeather);
        }
    }
}

public class Observer {

    public static void main(String[] args) {
        var weatherEnvironment = new WeatherEnvironment();
        
        NewsChannel channel1 = new NewsChannel("AMC");
        NewsChannel channel2 = new NewsChannel("CNM");
        
        weatherEnvironment.addObserver(channel1);
        weatherEnvironment.addObserver(channel2);
        weatherEnvironment.updateWeather("Rainy");
        weatherEnvironment.updateWeather("Cloudy");
        
        weatherEnvironment.removeObserver(channel2);
        weatherEnvironment.updateWeather("Sunny");
    }
}
