package de.tillmannheigel.advent_2018.Day_8_Memory_Maneuver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Day8 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((new FileInputStream("src/de/tillmannheigel/advent_2018/Day_8_Memory_Maneuver/input"))));
        Scanner scanner = new Scanner(bufferedReader);
        LinkedList<Integer> integers = new LinkedList<>();

        while (scanner.hasNextInt()) {
            integers.add(scanner.nextInt());
        }

        int result = parse(integers.poll(), integers.poll(), integers);

        System.out.println("A) " + result);

    }

    private static int parse(Integer childs, Integer metaData, LinkedList<Integer> integers) {
        if (childs == 0) {
            return parseMetaData(metaData, integers);
        }
        return parseChilds(childs - 1, integers.poll(), integers.poll(), integers) + parseMetaData(metaData, integers);
    }

    private static int parseChilds(Integer childs, Integer subChilds, Integer metaData, LinkedList<Integer> integers) {
        if (childs == 0) {
            return parse(subChilds, metaData, integers);
        }
        return parse(subChilds, metaData, integers) + parseChilds(childs - 1, integers.poll(), integers.poll(), integers);
    }

    private static int parseMetaData(Integer times, LinkedList<Integer> integers) {
        if (times == 0) {
            return 0;
        }
        return integers.poll() + parseMetaData(times - 1, integers);
    }
}
