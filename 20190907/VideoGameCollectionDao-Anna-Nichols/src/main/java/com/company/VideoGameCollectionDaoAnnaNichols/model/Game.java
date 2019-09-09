package com.company.VideoGameCollectionDaoAnnaNichols.model;

import java.util.Objects;

public class Game {

    private int id;
    private int consoleId;
    private int publisherId;
    private int typeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id &&
                consoleId == game.consoleId &&
                publisherId == game.publisherId &&
                typeId == game.typeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, consoleId, publisherId, typeId);
    }
}
