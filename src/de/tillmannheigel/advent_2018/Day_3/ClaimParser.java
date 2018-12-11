package de.tillmannheigel.advent_2018.Day_3;

import de.tillmannheigel.advent_2018.Day_3.data.ClaimCoordinatesData;
import de.tillmannheigel.advent_2018.Day_3.data.ClaimData;
import de.tillmannheigel.advent_2018.Day_3.data.ClaimSizeData;

public class ClaimParser {

    private static final String ID_MARKER = "#";
    private static final String COORD_MARKER = "@ ";
    private static final String SIZE_MARKER = ": ";
    private static final String SPACE = " ";
    private static final String COORD_SPLIT = ",";
    private static final String SIZE_SPLIT = "x";

    public ClaimData parseClaim(String claimString) {
        ClaimData claimData = new ClaimData();

        // id
        String idString = parseStringBetween(claimString, ID_MARKER, SPACE);
        int id = Integer.parseInt(idString);
        claimData.setId(id);

        // coordinates
        String coordinatesString = parseStringBetween(claimString, COORD_MARKER, SIZE_MARKER);
        ClaimCoordinatesData coord = parseCoordinates(coordinatesString);
        claimData.setCoordinates(coord);

        // size
        String sizeString = parseStringBetween(claimString, SIZE_MARKER, SPACE);
        ClaimSizeData size = parseSize(sizeString);
        claimData.setSize(size);
        return claimData;
    }

    private String parseStringBetween(String claim, String start, String stop) {
        return claim.split(start)[1].split(stop)[0];
    }

    private ClaimSizeData parseSize(String sizeString) {
        String[] split = sizeString.split(SIZE_SPLIT);
        return new ClaimSizeData(split[0],split[1]);
    }

    private ClaimCoordinatesData parseCoordinates(String coordinatesString){
        String[] split = coordinatesString.split(COORD_SPLIT);
        return new ClaimCoordinatesData(split[0],split[1]);
    }
}
