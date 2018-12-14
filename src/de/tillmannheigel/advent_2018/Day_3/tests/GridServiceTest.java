package de.tillmannheigel.advent_2018.Day_3.tests;

import de.tillmannheigel.advent_2018.Day_3.data.Claim;
import de.tillmannheigel.advent_2018.Day_3.data.ClaimCoordinates;
import de.tillmannheigel.advent_2018.Day_3.data.ClaimSize;
import de.tillmannheigel.advent_2018.Day_3.service.GridService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GridServiceTest {

    GridService gridService = new GridService();

    @Test
    public void testExample() {
        // given
        Claim aClaim = getClaim(1,"1","3","4","4");
        Claim bClaim = getClaim(2,"3","1","4","4");
        Claim cClaim = getClaim(3,"5","5","2","2");
        List<Claim> claims = Arrays.asList(aClaim, bClaim, cClaim);

        // when
        int[][] grid = gridService.buildGrid(claims);
        int searchedTwiceFields = gridService.calcSearchedTwiceFields(grid);
        this.drawGrid(grid);

        // then
        assert searchedTwiceFields == 4;

    }

    @Test
    public void testOnlyOne() {
        // given
        Claim aClaim = getClaim(1,"1","2","4","4");
        List<Claim> claims = Arrays.asList(aClaim);

        // when
        int[][] grid = gridService.buildGrid(claims);
        int searchedTwiceFields = gridService.calcSearchedTwiceFields(grid);
        this.drawGrid(grid); // just for fun

        // then
        assert searchedTwiceFields == 0;

    }

    private Claim getClaim(int id, String x, String y, String width, String height) {
        Claim claim = new Claim();
        claim.setId(id);
        claim.setCoordinates(new ClaimCoordinates(x,y));
        claim.setSize(new ClaimSize(width, height));
        return claim;
    }

    private void drawGrid(int[][] grid) {
        for (int[] lines : grid) {
            for (int value : lines) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

}