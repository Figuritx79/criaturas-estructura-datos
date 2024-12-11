package mx.edu.utez.criaturasestructuradatos.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import mx.edu.utez.criaturasestructuradatos.creature.model.Creature;

public class CsvReader {

    public static ArrayList<Creature> trainKnn(String fileName) {
        ArrayList<Creature> fileCreatures = new ArrayList<>();
        try (FileReader file = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(file);) {

            for (int i = 1; i < 1000; i++) {
                if (i == 1) {
                    reader.readLine();
                }
                var readLine = reader.readLine();

                // Split regresa un array de strings
                String[] values = readLine.split(",");

                Creature creature = new Creature(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]),
                        Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]),
                        Integer.parseInt(values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8]),
                        Integer.parseInt(values[9]));
                fileCreatures.add(creature);

                System.out.println(creature.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileCreatures;
    }

}
