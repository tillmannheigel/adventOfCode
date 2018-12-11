package de.tillmannheigel.advent_2018.Day_3.data;

public class ClaimData {
    private int id;
    private ClaimCoordinatesData coordinates;
    private ClaimSizeData size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClaimCoordinatesData getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ClaimCoordinatesData coordinates) {
        this.coordinates = coordinates;
    }

    public ClaimSizeData getSize() {
        return size;
    }

    public void setSize(ClaimSizeData size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ClaimData{" +
                "id=" + id +
                ", coordinates=" + coordinates +
                ", size=" + size +
                '}';
    }
}
