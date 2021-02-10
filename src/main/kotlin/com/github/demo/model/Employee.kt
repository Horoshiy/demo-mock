package com.github.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Employee(@Id @GeneratedValue val id: Long,
                    @field:NotBlank(message = "Name could not be blank") var name: String,
                    var salary: Int,
                    var age: Int)