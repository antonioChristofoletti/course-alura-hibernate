import dao.util.DaoUtils
import model.Person
import model.Phone
import repository.person.PersonRepository

fun main() {
    val person = Person("Antonio", listOf(Phone("111"), Phone("222"), Phone("333")))

    PersonRepository(DaoUtils.getEntityManager()).save(person)
}