package com.ademozalp.rediscache.dto

import com.ademozalp.rediscache.model.Unit
import jakarta.validation.constraints.NotNull

data class UpdateUnitDto(
    @field:NotNull val id:Long,
    val name:String?,
    val shortName:String?
){

    companion object{
        @JvmStatic
        fun convert(from : UpdateUnitDto, to:Unit): Unit{
            to.name = from.name?: to.name
            to.shortName = from.shortName?:to.shortName
            return to
        }
    }
}
