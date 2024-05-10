package com.ademozalp.rediscache.repository;

import com.ademozalp.rediscache.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UnitRepository extends JpaRepository<Unit, Long> {

    Optional<Unit> findByIdAndIsRemovedFalse(Long id);
}
