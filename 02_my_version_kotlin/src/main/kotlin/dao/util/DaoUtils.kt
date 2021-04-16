package dao.util

import javax.persistence.EntityManager
import javax.persistence.Persistence

abstract class DaoUtils {
    companion object {
        val databaseTempFactory = Persistence.createEntityManagerFactory("databaseTemp")

        fun getEntityManager(): EntityManager = databaseTempFactory.createEntityManager()
    }
}