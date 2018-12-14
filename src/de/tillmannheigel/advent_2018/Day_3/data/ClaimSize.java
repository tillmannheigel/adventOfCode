package de.tillmannheigel.advent_2018.Day_3.data;

public class ClaimSize {
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ClaimSize(String width, String height){
        this.height = Integer.parseInt(height);
        this.width = Integer.parseInt(width);
    }

    @Override
    public String toString() {
        return "ClaimSize{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
