package dev.martella.runnerz.run.service;


import dev.martella.runnerz.run.repository.RunRepository;
import dev.martella.runnerz.run.model.Run;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RunServiceImpl implements RunService {


    private RunRepository runRepository;

    @Override
    public void saveRun(Run run) {
        runRepository.save(run);
    }

    @Override
    public List<Run> getAllRun() {
        return runRepository.findAll();
    }

    @Override
    public Optional<Run> getRunById(Integer id) {
        return runRepository.findById(id);
    }

    //aggiorna la run con l'id passato come parametro se esiste, sennò non fa niente
    @Override
    public Optional<Run> updateRun(Integer id, Run run) {
        if (runRepository.existsById(id)) {
            run.setId(id);
            return Optional.of(runRepository.save(run));
        } else {
            return Optional.empty();
        }

    }

    @Override
    public void deleteRun(Integer id) {
        runRepository.deleteById(id);
    }

}
