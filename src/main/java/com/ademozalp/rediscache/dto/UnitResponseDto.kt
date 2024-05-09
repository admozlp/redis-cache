package com.ademozalp.rediscache.dto

import com.ademozalp.rediscache.model.Unit
import java.time.LocalDateTime

data class UnitResponseDto constructor(
    val id:Long?,
    val name:String,
    val shortName:String,
    val isRemoved:Boolean?,
    val createdDate: LocalDateTime?,
    val lastUpdate: LocalDateTime? = null
){
    companion object{
        @JvmStatic
        fun convert(from:Unit):UnitResponseDto{
            return UnitResponseDto(
                id = from.id,
                name = from.name,
                shortName = from.shortName,
                isRemoved = from.isRemoved,
                createdDate = from.createdDate,
                lastUpdate = from.lastUpdate
            )
        }
    }
}
