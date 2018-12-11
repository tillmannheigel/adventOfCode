package de.tillmannheigel.advent_2018.Day_3.data;

public class ClaimSizeData {
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ClaimSizeData(String height, String width){
        this.height = Integer.parseInt(height);
        this.width = Integer.parseInt(width);
    }

    @Override
    public String toString() {
        return "ClaimSizeData{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
