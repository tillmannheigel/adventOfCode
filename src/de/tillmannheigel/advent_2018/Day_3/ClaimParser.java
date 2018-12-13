package de.tillmannheigel.advent_2018.Day_3;

import de.tillmannheigel.advent_2018.Day_3.data.Claim;
import de.tillmannheigel.advent_2018.Day_3.data.ClaimCoordinates;
import de.tillmannheigel.advent_2018.Day_3.data.ClaimSize;

public class ClaimParser {

    private static final String ID_MARKER = "#";
    private static final String COORD_MARKER = "@ ";
    private static final String SIZE_MARKER = ": ";
    private static final String SPACE = " ";
    private static final String COORD_SPLIT = ",";
    private static final String SIZE_SPLIT = "x";

    public Claim parseClaim(String claimString) {
        Claim claim = new Claim();

        // id
        String idString = parseStringBetween(claimString, ID_MARKER, SPACE);
        int id = Integer.parseInt(idString);
        claim.setId(id);

        // coordinates
        String coordinatesString = parseStringBetween(claimString, COORD_MARKER, SIZE_MARKER);
        ClaimCoordinates coord = parseCoordinates(coordinatesString);
        claim.setCoordinates(coord);

        // size
        String sizeString = parseStringBetween(claimString, SIZE_MARKER, SPACE);
        ClaimSize size = parseSize(sizeString);
        claim.setSize(size);
        return claim;
    }

    private String parseStringBetween(String claim, String start, String stop) {
        return claim.split(start)[1].split(stop)[0];
    }

    private ClaimSize parseSize(String sizeString) {
        String[] split = sizeString.split(SIZE_SPLIT);
        return new ClaimSize(split[0],split[1]);
    }

    private ClaimCoordinates parseCoordinates(String coordinatesString){
        String[] split = coordinatesString.split(COORD_SPLIT);
        return new ClaimCoordinates(split[0],split[1]);
    }
}
