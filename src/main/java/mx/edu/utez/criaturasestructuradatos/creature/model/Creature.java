package mx.edu.utez.criaturasestructuradatos.creature.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import mx.edu.utez.criaturasestructuradatos.utils.ArrayList;

public class Creature {
    private String name; // Nombre
    private int size; // Tamano
    private int wings; // Tiene alas
    private int fly; // Puede volar
    private int strength; // Fuerza
    private int speed; // Velocidad
    private int energy; // Energia
    private int health; // Salud
    private int intelligene; // Inteligencia
    private int weight; // Peso

    /**
     *
     * @param name
     * @param size
     * @IF THE SIZE IS ONE = IS LITTLE
     * @IF THE SIZE IS TWO = IS MEDIUM
     * @IF THE SIZE IS THREE = IS BIG
     * @param wings
     * @param fly
     * @param strength
     * @param speed
     * @param energy
     * @param health
     * @param intelligene
     * @param weight
     * @IF THE WEIGHT IS ONE = IS THIN
     * @IF THE WEIGHT IS TWO= IS NORMAL
     * @IF THE WEIGHT IS THREE = IS FAT
     */
    public Creature(String name, int size, int wings, int fly, int strength, int speed, int energy, int health,
            int intelligene, int weight) {
        this.name = name;
        this.size = size;
        this.wings = wings;
        this.fly = fly;
        this.strength = strength;
        this.speed = speed;
        this.energy = energy;
        this.health = health;
        this.intelligene = intelligene;
        this.weight = weight;
    }

    public Creature() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @IF THE SIZE IS ONE = IS LITTLE
     * @IF THE SIZE IS TWO = IS MEDIUM
     * @IF THE SIZE IS THREE = IS BIG
     * @return NOTHING
     */
    public int getSize() {
        return size;
    }

    /**
     * @IF THE SIZE IS ONE = IS LITTLE
     * @IF THE SIZE IS TWO = IS MEDIUM
     * @IF THE SIZWE IS THREE = IS BIG
     * 
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    public int isWings() {
        return wings;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }

    public int isFly() {
        return fly;
    }

    public void setFly(int fly) {
        this.fly = fly;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getIntelligene() {
        return intelligene;
    }

    public void setIntelligene(int intelligene) {
        this.intelligene = intelligene;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * @IF THE WEIGHT IS 1 = THIN
     * @IF THE WEIGHT IS 2 = NORMAL
     * @IF THE WEIGHT IS THREE = FAT
     * 
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Creature [name=" + name + ", size=" + size + ", wings=" + wings + ", fly=" + fly + ", strength="
                + strength + ", speed=" + speed + ", energy=" + energy + ", health=" + health + ", intelligene="
                + intelligene + ", weight=" + weight + "]";
    }

}
