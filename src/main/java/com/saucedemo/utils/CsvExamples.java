package com.saucedemo.utils;

import java.nio.file.*;
import java.util.*;

public class CsvExamples {

    public static void main(String[] args) throws Exception {

        Path csvPath = Paths.get("src/test/resources/data/data.csv");
        Path featurePath = Paths.get(
                "src/test/resources/features/paginaCompra.feature"
        );

        List<String> csvLines = Files.readAllLines(csvPath);
        String[] headers = csvLines.get(0).split(",");

        List<String> featureLines = Files.readAllLines(featurePath);
        List<String> output = new ArrayList<>();

        for (String line : featureLines) {
            if (line.trim().startsWith("Examples:")) {
                break;
            }
            output.add(line);
        }

        output.add("      Examples:");
        output.add("        | " + String.join(" | ", headers) + " |");

        for (int i = 1; i < csvLines.size(); i++) {
            output.add("        | " +
                    String.join(" | ", csvLines.get(i).split(",")) +
                    " |");
        }

        Files.write(featurePath, output);
    }
}