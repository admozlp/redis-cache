package com.ademozalp.rediscache.service;


import com.ademozalp.rediscache.dto.CreateUnitDto;
import com.ademozalp.rediscache.dto.UnitResponseDto;
import com.ademozalp.rediscache.model.Unit;
import com.ademozalp.rediscache.repository.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public UnitResponseDto createUnit(CreateUnitDto createUnitDto) {
        Unit convert = CreateUnitDto.convert(createUnitDto);
        Unit save = unitRepository.save(convert);
        return UnitResponseDto.convert(save);
    }

    public List<UnitResponseDto> getAllUnits() {
        return unitRepository.findAll().stream().map(UnitResponseDto::convert).toList();
    }

    public UnitResponseDto getById(Long id) {
        Unit unit = unitRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Unit doesn't exist"));

        return UnitResponseDto.convert(unit);
    }


}
