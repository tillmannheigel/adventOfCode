package de.tillmannheigel.advent_2018.Day_3.service;

import de.tillmannheigel.advent_2018.Day_3.data.Claim;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GridService {

    public int[][] drawGrid(List<Claim> claims) {

        int[][] maxGrid = getMaxGrid(claims);

        claims.forEach(claim -> drawClaimOnGrid(claim,maxGrid));

        int someoneSearchedHereBefore = 0;

        for (int[] lines: maxGrid) {
            for (int value:lines) {
                if (value > 1) someoneSearchedHereBefore++;
            }
        }

        System.out.println(someoneSearchedHereBefore);
        return maxGrid;
    }

    private int[][] drawClaimOnGrid(Claim claim, int[][] grid) {
        System.out.println(claim);
        int x = claim.getCoordinates().getX();
        int y = claim.getCoordinates().getY();
        int width = claim.getSize().getWidth();
        int height = claim.getSize().getHeight();
        for (int i = x; i < x+width; i++) {
            for (int j = y; j < y+height; j++) {
                grid[i][j]++;
                System.out.println("coord " + i + ", " + j + " = " + grid[i][j]);
            }
        }
        return grid;
    }

    private int[][] getMaxGrid(List<Claim> claims) {
        int maxGridWidth = getMaxGridWidth(claims);
        System.out.println("maxGridWidth: " + maxGridWidth);
        int maxGridHeight = getMaxGridHeight(claims);
        System.out.println("maxGridHeight: " + maxGridHeight);
        return new int[maxGridWidth][maxGridHeight];
    }

    private int getMaxGridWidth(List<Claim> claims) {
        Optional<Claim> maxGridClaim = claims.stream().max(Comparator.comparing(this::getGridWidth));
        if (maxGridClaim.isPresent()) return getGridWidth(maxGridClaim.get());
        return 0;
    }

    private int getMaxGridHeight(List<Claim> claims) {
        Optional<Claim> maxGridClaim = claims.stream().max(Comparator.comparing(this::getGridHeight));
        if (maxGridClaim.isPresent()) return getGridHeight(maxGridClaim.get());
        return 0;
    }

    private int getGridWidth(Claim claim) {
        return claim.getCoordinates().getX() + claim.getSize().getWidth();
    }

    private int getGridHeight(Claim claim) {
        int height = claim.getCoordinates().getY() + claim.getSize().getHeight();
        System.out.println("#" + claim.getId()+": "+ height);
        return height;
    }

}
