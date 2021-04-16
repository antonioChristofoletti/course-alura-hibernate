package repository.person

import model.Person

interface IPersonRepository {

    fun save(person: Person)
    fun findById(id: Long): Person
}