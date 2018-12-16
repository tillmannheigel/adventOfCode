package de.tillmannheigel.advent_2018.Day_5_Alchemical_Reduction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static de.tillmannheigel.advent_2018.Commons.readCharacters;

public class A {

    public static void main(String[] args) throws IOException {
        ArrayList<Character> characters = readCharacters("src/de/tillmannheigel/advent_2018/Day_5_Alchemical_Reduction/input");

        int reductionResult = recursiveReduction(characters);

        System.out.println(reductionResult);
    }

    private static int recursiveReduction(List<Character> characters) {
        List<Character> reducedCharacters = reduce(characters);
        return (characters.size() == reducedCharacters.size()) ? reducedCharacters.size() : recursiveReduction(reducedCharacters);
    }

    private static List<Character> reduce(List<Character> characters) {
        ListIterator<Character> listIterator = characters.listIterator();
        List<Character> result = new ArrayList<>();
        while (listIterator.hasNext()) {
            Character next = listIterator.next();
            if (!result.isEmpty()) {
                Character last = result.get(result.size() - 1);
                if(reduce(next, last)){
                    result.remove(result.size() - 1);
                } else {
                    result.add(next);
                }
            } else {
                result.add(next);
            }
        }
        return result;
    }

    private static boolean reduce(char next, char last) {
        return isSameLetter(next,last) && isDifferentCase(next,last);
    }

    private static boolean isSameLetter(char next, char last) {
        return Character.toLowerCase(next) == Character.toLowerCase(last);
    }

    private static boolean isDifferentCase(char next, char last) {
        return Character.isUpperCase(next) == Character.isLowerCase(last);
    }
}
