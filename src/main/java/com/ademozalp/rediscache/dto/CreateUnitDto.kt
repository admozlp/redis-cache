package com.ademozalp.rediscache.dto

import com.ademozalp.rediscache.model.Unit
import jakarta.validation.constraints.NotEmpty


data class CreateUnitDto(
    @field:NotEmpty val name: String,
    @field:NotEmpty val shortName:String
){
    companion object{
        @JvmStatic
        fun convert(from : CreateUnitDto) : Unit {
            return Unit(
                name = from.name,
                shortName = from.shortName
            )
        }
    }
}
