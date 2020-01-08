package models;
import java.util.*;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, Integer age, String power, String weakness){
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        instances.add(this);
        this.id = instances.size();
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

    public int getId(){
        return id;
    }

    public static Hero findById(int id){
        return instances.get(id - 1);
    }

    public static Hero setUpNewHero(){
        return new Hero("Nehru", 22, "Thought", "Speed");
    }

    public static Hero setUpNewHero1(){
        return new Hero("Kayla", 20, "Empathy", "Concentration");
    }
}
