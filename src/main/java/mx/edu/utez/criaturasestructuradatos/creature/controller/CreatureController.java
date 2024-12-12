package mx.edu.utez.criaturasestructuradatos.creature.controller;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import mx.edu.utez.criaturasestructuradatos.creature.model.CreatureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/creaturas")
public class CreatureController {


    private final CreatureService creatureService;

    @Autowired
    public CreatureController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }


    @PostMapping("/classify")
    public ResponseEntity<Object> classifyCreature(@RequestBody CreatureDto dto) {
        return creatureService.clasificador(dto);
    }
     @PostMapping("/csv")
     public ResponseEntity<Object> csvCreature(@RequestParam("file") MultipartFile file) throws IOException {
        return creatureService.cargarcsv(file);
     }



}

//class CreatureClassificationRequest {
//    private Creature target;
//    private ArrayList<Creature> dataSet;
//    private int k;
//
//    // Getters y setters
//    // ...
//
//    public Creature getTarget() {
//        return target;
//    }
//
//    public void setTarget(Creature target) {
//        this.target = target;
//    }
//
//    public ArrayList<Creature> getDataSet() {
//        return dataSet;
//    }
//
//    public void setDataSet(ArrayList<Creature> dataSet) {
//        this.dataSet = dataSet;
//    }
//
//    public int getK() {
//        return k;
//    }
//
//    public void setK(int k) {
//        this.k = k;
//    }

