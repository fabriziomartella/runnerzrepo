package dev.martella.runnerz.run.controller.impl;

import dev.martella.runnerz.run.controller.Controller;
import dev.martella.runnerz.run.model.Run;
import dev.martella.runnerz.run.service.RunService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import java.util.Optional;

//Annotazione Lombok che genera un costruttore con i parametri per ogni campo della classe
@AllArgsConstructor
@RestController
@RequestMapping("/api/runs")
public class RunController implements Controller {


    private final RunService runService;

//chiedere nomi generici tipo findAll findById ecc perchè NO!!!!

    @ResponseStatus(HttpStatus.CREATED)
    @Override
    @PostMapping("")
    public void createRun(@RequestBody Run run) {
        runService.saveRun(run);

    }


   @Override
    @GetMapping("")
    public List<Run> findAllRun() {
        return runService.getAllRun();
        /*TODO Va bene che non ritorni nulla o vogliamo che ritorni un messaggio anche qua ?*/
    }

     @Override
    //Optional perchè potrebbe non esistere una corsa con l'id cercato
    @GetMapping("/{id}")
    public ResponseEntity<Object> findRunById(@PathVariable Integer id) {
       Optional<Run> optional =  runService.getRunById(id);
       if(optional.isPresent()) {
           return ResponseEntity.status(HttpStatus.FOUND).body(optional.get());
       }
       else{
           return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("id non trovato");
       }
    }
    @Override
    @PutMapping("{id}")
    public ResponseEntity<Object>  updateRun(@PathVariable Integer id, @RequestBody Run run) {
        Optional<Run> optional =  runService.updateRun(id, run);
        //uguale all'if sopra scritto solo con una sintassi diversa
        return optional.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.FOUND).body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("la corsa con questo id non esiste"));
    }

    @Override
    @DeleteMapping("{id}")
    public void deleteRun(@PathVariable Integer id) {
        runService.deleteRun(id);
    }







}
