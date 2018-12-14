package de.tillmannheigel.advent_2018.Day_3.service;

import de.tillmannheigel.advent_2018.Day_3.data.Claim;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class GridService {

    public int[][] buildGrid(List<Claim> claims) {

        int[][] grid = new int[1000][1000];

        claims.forEach(claim -> drawClaimOnGrid(claim, grid));

        return grid;
    }

    public int calcSearchedTwiceFields(int[][] maxGrid) {
        int someoneSearchedHereBefore = 0;

        for (int[] lines : maxGrid) {
            for (int value : lines) {
                if (value > 1) someoneSearchedHereBefore++;
            }
        }
        return someoneSearchedHereBefore;
    }

    private int[][] drawClaimOnGrid(Claim claim, int[][] grid) {
        int x = claim.getCoordinates().getX();
        int y = claim.getCoordinates().getY();
        int width = claim.getSize().getWidth();
        int height = claim.getSize().getHeight();
        for (int j = y; j < y + height; j++) {
            for (int i = x; i < x + width; i++) {
                try {
                    grid[i][j]++;
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        return grid;
    }
}
