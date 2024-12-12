package mx.edu.utez.criaturasestructuradatos.creature.controller;

import mx.edu.utez.criaturasestructuradatos.creature.model.Creature;
import mx.edu.utez.criaturasestructuradatos.creature.model.CreatureDto;
import mx.edu.utez.criaturasestructuradatos.utils.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;


@Service

public class CreatureService {

     private ArrayList<Creature> dataSet;


    public ResponseEntity<Object> clasificador(CreatureDto dto){
        ArrayList<String> validationErrors = new ArrayList<>();
        // 1. Validación de nombre
        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            validationErrors.add("El nombre es obligatorio");
        } else if (dto.getName().length() < 3) {
            validationErrors.add("El nombre no puede ser menor a 3 caracteres");
        } else {
//            // Validar que el nombre sea uno de los permitidos
//            List<String> allowedNames = Arrays.asList("Terrestres", "Marinos", "Voladores", "Anfibios");
//            if (!allowedNames.contains(dto.getName())) {
//                validationErrors.add("Nombre inválido. Debe ser: Terrestres, Marinos, Voladores o Anfibios");
//            }
        }

        // 2. Validación de tamaño
        if (dto.getSize() < 1 || dto.getSize() > 3) {
            validationErrors.add("Tamaño debe ser 1 (pequeño), 2 (mediano) o 3 (grande)");
        }

        // 3. Validación de alas (0 o 1)
        if (!"0".equals(dto.getWings()) && !"1".equals(dto.getWings())) {
            validationErrors.add("Alas debe ser 0 (Falso) o 1 (Verdadero)");
        }

        // 4. Validación de vuelo (0 o 1)
        if (!"0".equals(dto.getFly()) && !"1".equals(dto.getFly())) {
            validationErrors.add("Vuela debe ser 0 (Falso) o 1 (Verdadero)");
        }

        // 5. Validación de fuerza (1-10)
        if (dto.getStrength() < 1 || dto.getStrength() > 10) {
            validationErrors.add("Fuerza debe estar entre 1 y 10");
        }

        // 6. Validación de velocidad (1-10)
        if (dto.getSpeed() < 1 || dto.getSpeed() > 10) {
            validationErrors.add("Velocidad debe estar entre 1 y 10");
        }

        // 7. Validación de energía (1-10)
        if (dto.getEnergy() < 1 || dto.getEnergy() > 10) {
            validationErrors.add("Energía debe estar entre 1 y 10");
        }

        // 8. Validación de salud (1-10)
        if (dto.getHealth() < 1 || dto.getHealth() > 10) {
            validationErrors.add("Salud debe estar entre 1 y 10");
        }

        // 9. Validación de inteligencia (1-10)
        if (dto.getIntelligene() < 1 || dto.getIntelligene() > 10) {
            validationErrors.add("Inteligencia debe estar entre 1 y 10");
        }

        // 10. Validación de peso (1-3)
        if (dto.getWeight() < 1 || dto.getWeight() > 3) {
            validationErrors.add("Peso debe ser 1 (flaco), 2 (normal) o 3 (pesado)");
        }

        // Validaciones específicas de coherencia
        // Si tiene alas, debe poder volar
        if ("1".equals(dto.getWings()) && !"1".equals(dto.getWings())) {
            validationErrors.add("Si tiene alas, debe poder volar");
        }


        // Si hay errores, devolver respuesta de error
        if (validationErrors.isEmpty()) {
            return new ResponseEntity<>(
                    new ReponseObject(validationErrors,"Errores al ingresra los datos", Type.WARN),
                    HttpStatus.BAD_REQUEST
            );
        }

        // Si pasa todas las validaciones, proceder con la clasificación
        // Aquí podrías llamar al método de clasificación KNN

        Creature creature = new Creature(dto.getName(),dto.getSize(),dto.getWings(), dto.getFly(), dto.getStrength()
                , dto.getSpeed(), dto.getEnergy(), dto.getHealth(), dto.getIntelligene(), dto.getWeight());
        String clasificacion = Knn.classify(creature,dataSet,6);


        return ResponseEntity.ok(
                //clasificacion
                new ReponseObject(clasificacion,"Clasificación exitosa", Type.SUCCESS)
        );
    }

    public ResponseEntity<Object> cargarcsv(MultipartFile file) throws IOException {
        if (dataSet != null ){
            dataSet.clear();
        }


        if(file.isEmpty()){
            return new ResponseEntity<>(new ReponseObject("Archivo no cargado", Type.WARN), HttpStatus.BAD_REQUEST);
        }
         dataSet = CsvReader.trainKnn(file);
        if(dataSet.size() == 0){
            return new ResponseEntity<>(new ReponseObject("Error al cargar los datos", Type.WARN),
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new ReponseObject("Datos cargados ", Type.SUCCESS), HttpStatus.OK);

    }
}
