package org.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Day1 {
    InputStream input = getClass().getClassLoader().getResourceAsStream("Day1.txt");
    String text = new BufferedReader(
            new InputStreamReader(input, StandardCharsets.UTF_8))
            .lines()
            .collect(Collectors.joining("\n"));
    public void solve() {
        Integer[] countArray = new Integer[250];
        String[] input = text.split("\\R\\R");
        int i=0;
        int calCount = 0;
        int totalCal = 0;
        int maxAt = 0;
        for (String elf:input){
            calCount = 0;
            String[] calories = elf.split("\\R");
            for (String unit : calories){
                calCount += Integer.parseInt(unit);
            }
            countArray[i] = calCount;
            i++;
        }
        for (int k=0; k<3; k++){
            for (int j = 0; j < countArray.length; j++) {
                maxAt = countArray[j] > countArray[maxAt] ? j : maxAt;
            }
            totalCal += countArray[maxAt];
            System.out.println(countArray[maxAt]);
            System.out.println();

            countArray[maxAt] = 0;

            maxAt = 0;
        }
        System.out.println(totalCal);

    }
}
