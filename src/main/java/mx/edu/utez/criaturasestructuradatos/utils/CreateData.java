package mx.edu.utez.criaturasestructuradatos.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import mx.edu.utez.criaturasestructuradatos.creature.model.Creature;

public class CreateData {

    private static ArrayList<String> names = new ArrayList<>();

    public static void documentData(String documentName) {
        names.add("Terrestres");
        names.add("Marinos");
        names.add("Voladores");
        names.add("Anfibibios");

        try (FileWriter fw = new FileWriter(documentName, true); BufferedWriter writer = new BufferedWriter(fw);) {
            for (int i = 1; i < 1000; i++) {
                if (i == 1) {
                    writer.write("name,size,wings,fly,strength,speed,energy,health,intelligene,weight");
                    writer.newLine();
                }
                String name = names.get(new Random().nextInt(4));
                var wings = (name.equals("Voladores")) ? 1 : 0;
                Creature newCreature = new Creature(name, new Random().nextInt(3) + 1, wings, new Random().nextInt(2),
                        new Random().nextInt(11),
                        new Random().nextInt(11),
                        new Random().nextInt(11),
                        new Random().nextInt(11),
                        new Random().nextInt(11),
                        new Random().nextInt(3) + 1);
                writer.write(newCreature.getName() + ",");
                writer.write(newCreature.getSize() + ",");
                writer.write(newCreature.isWings() + ",");
                writer.write(newCreature.isFly() + ",");
                writer.write(newCreature.getStrength() + ",");
                writer.write(newCreature.getSpeed() + ",");
                writer.write(newCreature.getEnergy() + ",");
                writer.write(newCreature.getHealth() + ",");
                writer.write(newCreature.getIntelligene() + ",");
                writer.write(newCreature.getWeight() + "");
                writer.newLine();

            }
            System.out.println("The creature's file is now created");
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }

    public static void main(String[] args) {
        documentData("creature.csv");
        ArrayList<Creature> dataSet = CsvReader.trainKnn("creature.csv");
        Creature target = new Creature("Unknow", 3, 1, 0, 10, 5, 3, 7, 9, 1);

        var k = 6;
        var predictedType = Knn.classify(target, dataSet, k);

        System.out.println("Tu criatura se parace a : " + predictedType);

    }
}
