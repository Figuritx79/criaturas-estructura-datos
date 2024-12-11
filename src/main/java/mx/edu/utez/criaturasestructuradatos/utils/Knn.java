package mx.edu.utez.criaturasestructuradatos.utils;

import mx.edu.utez.criaturasestructuradatos.creature.model.Creature;

public class Knn {

    private int k;

    private ArrayList<Creature> creaturesFile = new ArrayList<>();

    // Tiempo que toma clasificar un nuevo dato
    private double executionTime;

    /**
     * Este método valida la elección de k del usuario y la acepta si no es cero, no
     * es igual
     * al número total de clases y si no es par. Si es cero, el método devuelve
     * falso y kNN
     * no se ejecuta. Si es par o un múltiplo del número de clases, se incrementa
     * para evitar empates.
     * 
     * @param k       dado k
     * @param classes número de clases
     * @return true si se ha establecido k
     */
    private boolean setK(int k, int classes) {
        if (k <= 0) {
            System.out.println("k tiene que se mayor a cero");
            return false;
        }

        if (k % 2 == 0) {
            System.out.println("Incrementar k para evitar que ambos tengan el mismo valor");
            k++;
        }

        if (k % classes == 0) {
            this.k = k + 2;
            System.out.println("K no puede ser igual a numero de clases para evitar empate");
        } else {
            this.k = k;
        }
        return true;
    }

}
