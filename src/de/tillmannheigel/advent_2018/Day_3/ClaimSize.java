package de.tillmannheigel.advent_2018.Day_3;

public class ClaimSize {
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    ClaimSize(String height, String width){
        this.height = Integer.parseInt(height);
        this.width = Integer.parseInt(width);
    }
}
