package mx.edu.utez.criaturasestructuradatos.utils;

import mx.edu.utez.criaturasestructuradatos.creature.model.Creature;

public class CreatureDistance {
    Creature creature;
    double distance;

    public CreatureDistance(Creature creature, double distance) {
        this.creature = creature;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }
}
