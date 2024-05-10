package com.ademozalp.rediscache.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Entity
data class Unit @JvmOverloads constructor (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var shortName:String,

    var isRemoved:Boolean? = false,

    @CreatedDate
    var createdDate:LocalDateTime? = null,

    @LastModifiedDate
    var lastUpdate: LocalDateTime? = null
){
    constructor() : this(0L,"","",null, null,null)
}
