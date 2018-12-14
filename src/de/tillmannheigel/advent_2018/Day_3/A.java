package de.tillmannheigel.advent_2018.Day_3;

import de.tillmannheigel.advent_2018.Day_3.data.Claim;
import de.tillmannheigel.advent_2018.Day_3.service.GridService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    static ClaimParser parser = new ClaimParser();
    static GridService gridService = new GridService();

    public static void main(String[] args) throws IOException {

        List<Claim> claims = Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_3/input"))
                .map(parser::parseClaim)
                .collect(Collectors.toList());

        int[][] grid = gridService.buildGrid(claims);
        int result = gridService.calcSearchedTwiceFields(grid);
        System.out.println(result);

    }

}
