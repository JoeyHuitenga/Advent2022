package org.example;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


public class Day2 {

    InputStream input = getClass().getClassLoader().getResourceAsStream("Day2.txt");
    String text = new BufferedReader(
            new InputStreamReader(input, StandardCharsets.UTF_8))
            .lines()
            .collect(Collectors.joining("\n"));

    public void solve(){
        MultiValuedMap<String, String> strategyMap = new ArrayListValuedHashMap<String, String>();
        String[] rounds;
        String[] options;
        int score = 0;

        rounds = text.split("\\R");

        for (String round : rounds) {
            options = round.split(" ");
            strategyMap.put(options[0], options[1]);
        }
        for (String decision : strategyMap.get("A")) {

            if (decision.equals("X")){
                score += 3+0;
            } else if (decision.equals("Y")){
                score += 1+3;
            } else {
                score += 2+6;
            }
        }
        for (String decision : strategyMap.get("B")) {
            if (decision.equals("X")){
                score += 1+0;
            } else if (decision.equals("Y")){
                score += 2+3;
            } else {
                score += 3+6;
            }
        }
        for (String decision : strategyMap.get("C")) {
            if (decision.equals("X")){
                score += 2+0;
            } else if (decision.equals("Y")){
                score += 3+3;
            } else {
                score += 1+6;
            }
        }
        System.out.println(score);
    }
}
