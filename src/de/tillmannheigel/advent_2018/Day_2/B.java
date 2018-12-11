package de.tillmannheigel.advent_2018.Day_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class B {

    public static void main(String[] args) throws IOException {
        List<String> words = Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_2/input"))
                .collect(Collectors.toList());

        new ArrayList<>(words)
                .stream()
                .forEach(s -> {
                    for (String word:words) {
                        if(hasDistance(1, word, s)){
                            diff(word, s);
                            System.out.println();
                        }
                    }
                });

    }


    private static void diff(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] == charsB[i]) {
                System.out.print(charsA[i]);
            }
        }
    }

    private static boolean hasDistance(int distance, String a, String b){
        int distanceCounter = 0;

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        for (int i = 0; i < charsA.length; i++) {
            if(charsA[i] == charsB[i] && distanceCounter <= 1){
            } else {
                distanceCounter++;
                if (distanceCounter > distance) return false;
            }
        }
        return distanceCounter == 1;
    }

}
