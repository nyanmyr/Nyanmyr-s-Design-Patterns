package com.mycompany.strategy;

interface MovementStrategy {
    
    int move();
}

class ClimbStrategy implements MovementStrategy {
    
    @Override
    public int move() {
        return 1;
    }
}

class SwimStrategy implements MovementStrategy {
    
    @Override
    public int move() {
        return 2;
    }
}

class CrawlStrategy implements MovementStrategy {
    
    @Override
    public int move() {
        return 3;
    }
}

class Struggle {
    
   int struggle;
   
   Struggle() {
       struggle = 1;
       presentStruggle();
   }
   
   public void presentStruggle() {
       switch (struggle) {
           case 1 -> {
               System.out.println("You encounter a large rock.");
           } case 2 -> {
               System.out.println("You encounter a big body of water.");
           } case 3 -> {
               System.out.println("You find a small hole.");
           } case 4 -> {
               System.out.println("You have successfully completed the trials.");
           }
       }
   }
   
   public void solveStruggle(MovementStrategy strategy) {
       
       if (strategy.move() == struggle) {
           System.out.println("You succesfully overcame the struggle.\n");
           struggle++;
           presentStruggle();
       } else {
           System.out.println("You failed to overcome the struggle. Try a different strategy.");
       }
   }
   
}

public class Strategy {

    public static void main(String[] args) {
        
        Struggle struggle = new Struggle();
        
        struggle.solveStruggle(new SwimStrategy());
        struggle.solveStruggle(new ClimbStrategy());
        
        struggle.solveStruggle(new ClimbStrategy());
        struggle.solveStruggle(new CrawlStrategy());
        struggle.solveStruggle(new SwimStrategy());
        
        struggle.solveStruggle(new SwimStrategy());
        struggle.solveStruggle(new ClimbStrategy());
        struggle.solveStruggle(new SwimStrategy());
        struggle.solveStruggle(new CrawlStrategy());
    }
}
