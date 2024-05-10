package com.ademozalp.rediscache.service;


import com.ademozalp.rediscache.dto.CreateUnitDto;
import com.ademozalp.rediscache.dto.UnitResponseDto;
import com.ademozalp.rediscache.dto.UpdateUnitDto;
import com.ademozalp.rediscache.model.Unit;
import com.ademozalp.rediscache.repository.UnitRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Transactional
    public UnitResponseDto createUnit(CreateUnitDto createUnitDto) {
        Unit convert = CreateUnitDto.convert(createUnitDto);
        Unit save = unitRepository.save(convert);
        return UnitResponseDto.convert(save);
    }

    public List<UnitResponseDto> getAllUnits() {
        return unitRepository.findAll().stream()
                .filter(unit -> Boolean.FALSE.equals(unit.isRemoved()))
                .map(UnitResponseDto::convert)
                .toList();
    }

    public UnitResponseDto getById(Long id) {
        Unit unit = unitRepository.findByIdAndIsRemovedFalse(id).orElseThrow(
                () -> new RuntimeException("Unit doesn't exist"));

        return UnitResponseDto.convert(unit);
    }

    @Transactional
    public UnitResponseDto update(UpdateUnitDto updateUnitDto) {
        Unit unit = unitRepository.findByIdAndIsRemovedFalse(updateUnitDto.getId()).orElseThrow(
                () -> new RuntimeException("Unit doesn't exist"));

        Unit convert = UpdateUnitDto.convert(updateUnitDto, unit);

        Unit save = unitRepository.save(convert);

        return UnitResponseDto.convert(save);
    }

    @Transactional
    public String delete(Long id) {
        Unit unit = unitRepository.findByIdAndIsRemovedFalse(id).orElseThrow(
                () -> new RuntimeException("Unit doesn't exist"));
        unit.setRemoved(true);
        unitRepository.save(unit);
        return "Unit removed.";
    }
}
