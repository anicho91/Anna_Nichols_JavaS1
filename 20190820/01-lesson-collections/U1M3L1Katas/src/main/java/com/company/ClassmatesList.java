package com.company;

import java.util.ArrayList;

public class ClassmatesList {

    private ArrayList<Classmate> classList = new ArrayList<>();

    public void add(Classmate newClass){

    }

    public Classmate get(int i) {
        for(i = 0; i<classList.size(); i++) {
            classList.get(i);
        }

        return classList.get(i);
    }

    public ArrayList<Classmate> getAll() {
        return classList;
    }
}
