package de.tillmannheigel.advent_2018.Day_3.tests;

import de.tillmannheigel.advent_2018.Day_3.ClaimParser;
import de.tillmannheigel.advent_2018.Day_3.data.Claim;
import org.junit.Test;

public class ClaimParserTest {

    ClaimParser claimParser = new ClaimParser();

    @Test
    public void testParseClaim() {
        // given
        String claimString = "#18 @ 954,514: 28x10 ";

        // when
        Claim claim = claimParser.parseClaim(claimString);

        // then
        assert claim.getId() == 18;
        assert claim.getCoordinates().getX() == 954;
        assert claim.getCoordinates().getY() == 514;
        assert claim.getSize().getHeight() == 28;
        assert claim.getSize().getWidth() == 10;
    }
}