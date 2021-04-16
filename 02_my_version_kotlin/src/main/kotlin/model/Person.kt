package model

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "people")
open class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open lateinit var id: BigDecimal

    open lateinit var name: String

    @OneToMany(targetEntity = Phone::class)
    open lateinit var phones: List<Phone>

    constructor()

    constructor(name: String, phones: List<Phone>) {
        this.name = name
        this.phones = phones
    }
}