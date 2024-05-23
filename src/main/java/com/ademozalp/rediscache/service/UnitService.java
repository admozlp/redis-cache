package com.ademozalp.rediscache.service;


import com.ademozalp.rediscache.dto.CreateUnitDto;
import com.ademozalp.rediscache.dto.UnitResponseDto;
import com.ademozalp.rediscache.dto.UpdateUnitDto;
import com.ademozalp.rediscache.model.Unit;
import com.ademozalp.rediscache.repository.UnitRepository;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UnitService {
    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Transactional
    @CacheEvict(value = {"units", "unit_id"}, allEntries = true)
    public UnitResponseDto createUnit(CreateUnitDto createUnitDto) {
        Unit convert = CreateUnitDto.convert(createUnitDto);
        Unit save = unitRepository.save(convert);
        return UnitResponseDto.convert(save);
    }

    @Cacheable(value = "units", key = "#root.methodName", unless = "#result == null")
    public Set<UnitResponseDto> getAllUnits() {
        unitRepository.findByIsRemovedFalse();
        return unitRepository.findByIsRemovedFalse().stream()
                .map(UnitResponseDto::convert)
                .collect(Collectors.toSet());
    }

    @Cacheable(cacheNames = "unit_id", key = "#root.methodName + #id", unless = "#result == null")
    public UnitResponseDto getById(Long id) {
        Unit unit = unitRepository.findByIdAndIsRemovedFalse(id).orElseThrow(
                () -> new RuntimeException("Unit doesn't exist"));

        return UnitResponseDto.convert(unit);
    }

    @Transactional
    @CachePut(cacheNames = "unit_id", key = "'getById' + #updateUnitDto.id", unless = "#result == null")
    @CacheEvict(value = {"units"}, allEntries = true)
    public UnitResponseDto update(UpdateUnitDto updateUnitDto) {
        Unit unit = unitRepository.findByIdAndIsRemovedFalse(updateUnitDto.getId())
                .orElseThrow(() -> new RuntimeException("Unit doesn't exist"));

        Unit convert = UpdateUnitDto.convert(updateUnitDto, unit);

        Unit save = unitRepository.save(convert);

        return UnitResponseDto.convert(save);
    }

    @Transactional
    @CacheEvict(value = {"units", "unit_id"}, allEntries = true)
    public String delete(Long id) {
        Unit unit = unitRepository.findByIdAndIsRemovedFalse(id).orElseThrow(
                () -> new RuntimeException("Unit doesn't exist"));
        unit.setRemoved(true);
        unitRepository.save(unit);
        return "Unit removed.";
    }
}
