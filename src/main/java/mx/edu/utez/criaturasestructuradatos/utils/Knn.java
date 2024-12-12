package mx.edu.utez.criaturasestructuradatos.utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import mx.edu.utez.criaturasestructuradatos.creature.model.Creature;

public class Knn {

    public static double euclideanDistance(int[] features1, int[] features2) {
        double sum = 0.0;
        for (int i = 0; i < features1.length; i++) {
            sum += Math.pow(features1[i] - features2[i], 2);
        }
        return Math.sqrt(sum);
    }

    public static String classify(Creature target, ArrayList<Creature> dataSet, int k) {
        PriorityQueue<CreatureDistance> pq = new PriorityQueue<>(
                Comparator.comparingDouble(CreatureDistance::getDistance));
        for (int i = 0; i < dataSet.size(); i++) {
            Creature creature = dataSet.get(i);
            double distance = euclideanDistance(target.getFeatures(), creature.getFeatures());
            pq.add(new CreatureDistance(creature, distance));
        }
        Map<String, Integer> typeCounts = new HashMap<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            Creature closest = pq.poll().creature;
            typeCounts.put(closest.getName(), typeCounts.getOrDefault(closest.getName(), 0) + 1);
        }
        return typeCounts.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

}
