package dev.martella.runnerz.run.service;

import dev.martella.runnerz.run.model.Run;

import java.util.List;
import java.util.Optional;

public interface RunService {
    void saveRun(Run run);
    List<Run> getAllRun();
    Optional<Run> getRunById(Integer id);
    Optional<Run> updateRun(Integer id, Run run);
    void deleteRun(Integer id);
}
