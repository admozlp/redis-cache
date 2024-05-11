package com.ademozalp.rediscache.controller;

import com.ademozalp.rediscache.dto.CreateUnitDto;
import com.ademozalp.rediscache.dto.UnitResponseDto;
import com.ademozalp.rediscache.dto.UpdateUnitDto;
import com.ademozalp.rediscache.service.UnitService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/units")
public class UnitController {
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping
    public ResponseEntity<UnitResponseDto> createUnit(@RequestBody @Valid CreateUnitDto createUnitDto){
        return ResponseEntity.ok().body(unitService.createUnit(createUnitDto));
    }

    @GetMapping
    public Set<UnitResponseDto> getUnits(){
        return unitService.getAllUnits();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<UnitResponseDto> getById(@RequestParam Long id){
        return ResponseEntity.ok().body(unitService.getById(id));
    }

    @PutMapping
    public ResponseEntity<UnitResponseDto> update(@RequestBody UpdateUnitDto updateUnitDto){
        return ResponseEntity.ok().body(unitService.update(updateUnitDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok().body(unitService.delete(id));
    }

}
