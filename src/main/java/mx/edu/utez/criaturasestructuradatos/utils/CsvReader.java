package mx.edu.utez.criaturasestructuradatos.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import mx.edu.utez.criaturasestructuradatos.creature.model.Creature;
import org.springframework.web.multipart.MultipartFile;

public class CsvReader {

    public static ArrayList<Creature> trainKnn(MultipartFile file) {
        ArrayList<Creature> fileCreatures = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            int lineNumber = 0;

            // Leer línea por línea el archivo
            while ((line = reader.readLine()) != null) {
                if (lineNumber == 0) { // Salta la primera línea si tiene encabezados
                    lineNumber++;
                    continue;
                }

                // Procesar cada línea del archivo
                String[] values = line.split(",");
                Creature creature = new Creature(
                        values[0],
                        Integer.parseInt(values[1]),
                        Integer.parseInt(values[2]),
                        Integer.parseInt(values[3]),
                        Integer.parseInt(values[4]),
                        Integer.parseInt(values[5]),
                        Integer.parseInt(values[6]),
                        Integer.parseInt(values[7]),
                        Integer.parseInt(values[8]),
                        Integer.parseInt(values[9])
                );
                fileCreatures.add(creature);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileCreatures;
    }
}
