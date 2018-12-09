package de.tillmannheigel.advent_2018.Day_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    public static void main(String[] args) throws IOException {
        List<ChecksumData> collect = Files
                .lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_2/input"))
                .map(A::numberOfChars)
                .map(A::checksum)
                .collect(Collectors.toList());
        long countTwos = new ArrayList<>(collect).stream().filter(checksumData -> checksumData.twos).count();
        long countThrees = new ArrayList<>(collect).stream().filter(checksumData -> checksumData.threes).count();

        System.out.println(countTwos);
        System.out.println("*");
        System.out.println(countThrees);
        System.out.println("=");
        System.out.println(countTwos*countThrees);
    }

    private static ChecksumData checksum(List<Integer> charsAppearance) {
        ChecksumData checksum = new ChecksumData();
            checksum.twos = charsAppearance.contains(2);
            checksum.threes = charsAppearance.contains(3);
        return checksum;
    }

    private static List<Integer> numberOfChars(String line) {
        List<Integer> collect = line.chars()
                .mapToObj(i -> String.valueOf((char) i))
                .map(string -> line.length() - line.replace(string, "").length())
                .collect(Collectors.toList());
        return collect;
    }
}
