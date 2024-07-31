
package dev.martella.runnerz.run.controller;

import dev.martella.runnerz.run.model.Run;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface Controller {

    void createRun(Run run);
    List<Run> findAllRun();
    ResponseEntity<Object> findRunById(Integer id);
    ResponseEntity<Object> updateRun(Integer id, Run run);
    void deleteRun(Integer id);


}



