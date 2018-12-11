package de.tillmannheigel.advent_2018.Day_3;

import org.junit.Test;

public class ClaimParserTest {

    ClaimParser claimParser = new ClaimParser();

    @Test
    public void testParseClaim() {
        // given
        String claimString = "#18 @ 954,514: 28x10 ";

        // when
        ClaimData claimData = claimParser.parseClaim(claimString);

        // then
        assert claimData.getId() == 18;
        assert claimData.getCoordinates().x == 954;
        assert claimData.getCoordinates().y == 514;
        assert claimData.getSize().getHeight() == 28;
        assert claimData.getSize().getWidth() == 10;
    }
}