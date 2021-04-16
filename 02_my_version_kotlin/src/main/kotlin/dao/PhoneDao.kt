package dao

import javax.persistence.EntityManager
import model.Person
import model.Phone

class PhoneDao(val em: EntityManager) {
    fun insert(p: Phone) {
        this.em.persist(p)
    }

    fun update(p: Phone) {
        this.em.merge(p)
    }
}