package com.ademozalp.rediscache.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "units")
data class Unit @JvmOverloads constructor (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var shortName:String,

    @Column(nullable = false)
    var isRemoved:Boolean = false,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdDate:LocalDateTime? = null,

    @LastModifiedDate
    @Column(insertable = false)
    var lastUpdate: LocalDateTime? = null
){
    constructor() : this(0L,"","",false, null,null)

    constructor(name:String, shortName: String): this(0L, name, shortName)
}
