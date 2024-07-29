package dev.martella.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.time.LocalDateTime;


public record Run (  Integer id,
                     //Vincoli che devono rispettare le variabili
                     @NotEmpty
                     String title,
                     LocalDateTime startedOn,
                     LocalDateTime completedOn,
                     @Positive
                     Integer miles,
                     Local location){


    //costruttore compatto quando viene creata istanza RUn controlla che completed on non sia prima di started on
    public Run{
        if(!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed on is before started on");

        }
    }


}




