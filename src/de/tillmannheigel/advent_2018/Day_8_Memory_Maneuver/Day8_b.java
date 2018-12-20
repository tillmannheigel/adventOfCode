package de.tillmannheigel.advent_2018.Day_8_Memory_Maneuver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Day8_b {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((new FileInputStream("src/de/tillmannheigel/advent_2018/Day_8_Memory_Maneuver/input"))));
        Scanner scanner = new Scanner(bufferedReader);
        LinkedList<Integer> integers = new LinkedList<>();

        while (scanner.hasNextInt()) {
            integers.add(scanner.nextInt());
        }

        int result = parse(integers.poll(), integers.poll(), integers);

        System.out.println("B) " + result);

    }

    private static int parse(Integer childs, Integer metaData, LinkedList<Integer> integers) {
        if (childs == 0) {
            return specialFunction(new LinkedList<>(), parseMetaData(metaData, integers));
        }
        return specialFunction(parseChilds(childs - 1, integers.poll(), integers.poll(), integers), parseMetaData(metaData, integers));
    }

    private static int specialFunction(LinkedList<Integer> childs, LinkedList<Integer> metaData) {
        if (childs.size() == 0) return sum(metaData);
        if (metaData.size() == 0) return 0;
        Integer next = metaData.poll();
        if (childs.size() < next) return specialFunction(childs, metaData);
        return childs.get(next - 1) + specialFunction(childs, metaData);
    }

    private static int sum(LinkedList<Integer> metaData) {
        if (metaData.size() > 0) return metaData.poll() + sum(metaData);
        return 0;
    }


    private static LinkedList<Integer> parseChilds(Integer childs, Integer subChilds, Integer metaData, LinkedList<Integer> integers) {
        LinkedList<Integer> childList = new LinkedList<>();
        childList.add(parse(subChilds, metaData, integers));
        if (childs > 0) {
            childList.addAll(parseChilds(childs - 1, integers.poll(), integers.poll(), integers));
        }
        return childList;
    }

    private static LinkedList<Integer> parseMetaData(Integer times, LinkedList<Integer> integers) {
        if (times == 0) {
            return new LinkedList<>();
        }
        LinkedList<Integer> result = parseMetaData(times - 1, integers);
        result.add(integers.poll());
        return result;
    }
}
