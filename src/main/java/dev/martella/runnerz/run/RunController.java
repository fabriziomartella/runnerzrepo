package dev.martella.runnerz.run;

import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }


    @GetMapping("")
    List<Run> findAll(){
        return runRepository.findAll();
    }


   @GetMapping("/{id}")
    Run findByRunId(@PathVariable Integer id){
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return run.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void save(@Valid @RequestBody Run run){
        runRepository.create(run);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@PathVariable Integer id, @RequestBody Run run){
        Optional<Run> runOptional = runRepository.findById(id);
        if(runOptional.isEmpty()){
            throw new RunNotFoundException();
        }
        runRepository.update(run,id);
    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        Optional<Run> runOptional = runRepository.findById(id);
        if(runOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        runRepository.delete(id);

    }






}
