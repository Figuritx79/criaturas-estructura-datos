package mx.edu.utez.criaturasestructuradatos.creature.model;

import jakarta.validation.constraints.NotNull;

public class CreatureDto {

    @NotNull(groups = {Register.class}, message = "Es necesario el nombre")
    private String name; // Nombre
    @NotNull(groups = {Register.class},message = "Es necesario el tamaño")
    private int size; // Tamano
    @NotNull(groups = {Register.class},message = "Es necesario saber si tiene alas")
    private int wings; // Tiene alas
    @NotNull(groups = {Register.class},message = "Es necesario saber si puede volar")
    private int fly; // Puede volar
    @NotNull(groups = {Register.class},message = "Es necesariosaber su fuerza")
    private int strength; // Fuerza
    @NotNull(groups = {Register.class},message = "Es necesario la velocidad")
    private int speed; // Velocidad
    @NotNull(groups = {Register.class},message = "Es necesaria la energia ")
    private int energy; // Energia
    @NotNull(groups = {Register.class},message = "Es necesario el nivel se salud")
    private int health; // Salud
    @NotNull(groups = {Register.class},message = "Es necesario la inteligencia")
    private int intelligene; // Inteligencia
    @NotNull(groups = {Register.class},message = "Es necesario saber el peso")
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWings() {
        return wings;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }

    public int getFly() {
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

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //interfaces
    public interface Register {
    }

}
