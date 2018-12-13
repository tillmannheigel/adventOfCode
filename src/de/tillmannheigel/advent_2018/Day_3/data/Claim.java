package de.tillmannheigel.advent_2018.Day_3.data;

public class Claim {
    private int id;
    private ClaimCoordinates coordinates;
    private ClaimSize size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClaimCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ClaimCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ClaimSize getSize() {
        return size;
    }

    public void setSize(ClaimSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id=" + id +
                ", coordinates=" + coordinates +
                ", size=" + size +
                '}';
    }
}
