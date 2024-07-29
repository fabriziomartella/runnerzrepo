package dev.martella.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/* Consente di fornire messaggi di errore significativi e rilevanti per il contesto dell'errore.*/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunNotFoundException extends RuntimeException {
    public RunNotFoundException() {
        super("Run not found");
    }
}
