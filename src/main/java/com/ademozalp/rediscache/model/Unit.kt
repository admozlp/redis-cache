package com.ademozalp.rediscache.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Entity
data class Unit @JvmOverloads constructor (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val shortName:String,

    val isRemoved:Boolean? = false,

    @CreatedDate
    val createdDate:LocalDateTime? = null,

    @LastModifiedDate
    val lastUpdate: LocalDateTime? = null
){
    constructor() : this(0L,"","",null, null,null)
}
