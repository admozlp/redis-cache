package com.ademozalp.rediscache.dto

import com.ademozalp.rediscache.model.Unit
import kotlinx.serialization.Serializable


@Serializable
data class UnitResponseDto(
    var id:Long?,
    var name:String,
    var shortName:String,
    var isRemoved:Boolean?,
//    @Serializable(with = LocalDateTimeSerializer::class) var createdDate: LocalDateTime? = null,
//    @Serializable(with = LocalDateTimeSerializer::class) var lastUpdate: LocalDateTime? = null
){
    companion object{
        @JvmStatic
        fun convert(from:Unit):UnitResponseDto{
            return UnitResponseDto(
                id = from.id,
                name = from.name,
                shortName = from.shortName,
                isRemoved = from.isRemoved,
//                createdDate = from.createdDate,
//                lastUpdate = from.lastUpdate
            )
        }
    }
}
