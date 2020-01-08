package models;

import java.util.ArrayList;

public class Squad {
    private int maxSize;
    private String squadName;
    private String cause;
    private static ArrayList<Squad> allSquads = new ArrayList<>();

    public Squad(Integer maxSize, String squadName, String cause){
        this.maxSize = maxSize;
        this.squadName = squadName;
        this.cause = cause;
        allSquads.add(this);
    }
}
