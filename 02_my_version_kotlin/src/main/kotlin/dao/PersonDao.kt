package dao

import javax.persistence.EntityManager
import model.Person

class PersonDao(val em: EntityManager) {
    fun insert(p: Person) {
        this.em.persist(p)
    }

    fun update(p: Person) {
        this.em.merge(p)
    }
}