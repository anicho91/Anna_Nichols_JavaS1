package com.company;

public class Study {

    private boolean hasDesktop;
    private int levelSound;
    private boolean hasBooks;
    private int numMonitors;
    private int sizeOfDesk;

    public boolean isHasDesktop() {
        return hasDesktop;
    }

    public void setHasDesktop(boolean hasDesktop) {
        this.hasDesktop = hasDesktop;
    }

    public int getLevelSound() {
        return levelSound;
    }

    public void setLevelSound(int levelSound) {
        this.levelSound = levelSound;
    }

    public boolean isHasBooks() {
        return hasBooks;
    }

    public void setHasBooks(boolean hasBooks) {
        this.hasBooks = hasBooks;
    }

    public int getNumMonitors() {
        return numMonitors;
    }

    public void setNumMonitors(int numMonitors) {
        this.numMonitors = numMonitors;
    }

    public int getSizeOfDesk() {
        return sizeOfDesk;
    }

    public void setSizeOfDesk(int sizeOfDesk) {
        this.sizeOfDesk = sizeOfDesk;
    }

    public Study(){}

    public void doHomework(){}

    public void readBook(){}

}
