package com.anamnesis.AnamnesisService.repository;

import com.anamnesis.AnamnesisService.model.NoPathologicalPersonalHistory;
import org.springframework.data.repository.CrudRepository;

public interface NoPatPersonalHistoryRepository extends CrudRepository<NoPathologicalPersonalHistory, Integer> {
}
