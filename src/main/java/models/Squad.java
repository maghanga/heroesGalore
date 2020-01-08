package models;

import java.util.ArrayList;

public class Squad {
    private int maxSize;
    private String squadName;
    private String cause;
    private static ArrayList<Squad> allSquads = new ArrayList<>();

    public Squad(int maxSize, String squadName, String cause){
        this.maxSize = maxSize;
        this.squadName = squadName;
        this.cause = cause;
        allSquads.add(this);
    }

    public int getMaxSize(){
        return maxSize;
    }

    public String getSquadName(){
        return squadName;
    }

    public String getCause(){
        return cause;
    }
}
