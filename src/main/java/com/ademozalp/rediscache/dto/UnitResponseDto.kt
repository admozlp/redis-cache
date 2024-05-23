package com.ademozalp.rediscache.dto

import com.ademozalp.rediscache.model.Unit
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable


@Serializable
data class UnitResponseDto @JsonCreator constructor(
    @JsonProperty("id") var id:Long,
    @JsonProperty("name") var name:String,
    @JsonProperty("shortName") var shortName:String,
    @JsonProperty("removed") var removed:Boolean,
    @JsonProperty("createdDate") var createdDate: String? = null,
    @JsonProperty("lastUpdate") var lastUpdate: String? = null
){
    companion object{
        @JvmStatic
        fun convert(from:Unit):UnitResponseDto{
            return UnitResponseDto(
                id = from.id?:0,
                name = from.name,
                shortName = from.shortName,
                removed = from.isRemoved,
                createdDate = from.createdDate.toString(),
                lastUpdate = from.lastUpdate.toString()
            )
        }
    }
}
