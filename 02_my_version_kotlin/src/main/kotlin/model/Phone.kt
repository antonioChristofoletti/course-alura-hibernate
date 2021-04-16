package model

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity @Table(name = "phones")
open class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open lateinit var id: BigDecimal

    open lateinit var number: String

    @OneToOne
    open lateinit var person: Person

    constructor()

    constructor(number: String) {
        this.number = number
    }
}