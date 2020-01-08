package models;
import java.util.*;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private String heroSquad;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, Integer age, String power, String weakness, String heroSquad){
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        this.heroSquad = heroSquad;
        instances.add(this);
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    public String getPower(){
        return power;
    }

    public String getWeakness(){
        return weakness;
    }

    public static ArrayList<Hero> getAllHeroes(){
        return instances;
    }

    public static void clearHeroes(){
        instances.clear();
    }

    public String getHeroSquad(){
        return heroSquad;
    }

    public static Hero findById(int id){
        return instances.get(id - 1);
    }

    public static Hero setUpNewHero(){
        return new Hero("Nehru", 22, "Thought", "Speed", "yellow");
    }

    public static Hero setUpNewHero1(){
        return new Hero("Kayla", 20, "Empathy", "Concentration", "red");
    }
}
