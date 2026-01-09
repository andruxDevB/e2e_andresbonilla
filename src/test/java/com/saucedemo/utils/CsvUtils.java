package com.saucedemo.utils;

import com.saucedemo.models.Data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CsvUtils {

    private static final String FILE_PATH = "data/data.csv";

    public static Data readCheckoutData() {
        try {
            InputStream inputStream = CsvUtils.class
                    .getClassLoader()
                    .getResourceAsStream(FILE_PATH);

            if (inputStream == null) {
                throw new RuntimeException("No se encontró el archivo CSV: " + FILE_PATH);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Saltar encabezado
            reader.readLine();

            // Leer primera fila
            String line = reader.readLine();
            String[] values = line.split(",");

            return new Data(
                    values[0].trim(), // username
                    values[1].trim(), // password
                    values[2].trim(), // firstName
                    values[3].trim(), // lastName
                    values[4].trim()  // postalCode
            );

        } catch (Exception e) {
            throw new RuntimeException("Error leyendo CSV", e);
        }
    }
}
