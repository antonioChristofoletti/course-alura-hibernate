package repository.person

import javax.persistence.EntityManager
import model.Person

class PersonRepository(val em: EntityManager): IPersonRepository {

    @Throws
    override fun save(person: Person) {
        try {
            em.transaction.begin()

            person.phones.forEach { em.persist(it) }
            em.persist(person)

            em.transaction.commit()
        } catch (e: Exception) {
            println(e.stackTraceToString())
            em.transaction.rollback()

            throw e
        } finally {
            em.close()
        }
    }

    override fun findById(id: Long) = em.find(Person::class.java, id)
}