package fr.eni.roomdemonstration

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.eni.roomdemonstration.dao.PersonneDao
import fr.eni.roomdemonstration.dao.utils.AppDatabase
import fr.eni.roomdemonstration.model.Personne
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * Classe permettant de teswter la classe PersonneDao.
 * L'annotation @RunWith(AndroidJUnit4::class) indique que les tests doivent être effectués par JUnit.
 */
@RunWith(AndroidJUnit4::class)
class PersonneDaoTest {
    private lateinit var personneDao: PersonneDao
    private lateinit var db: AppDatabase

    /**
     * Fonction exécutée avant tous les tests.
     * Elle crée la connexion à la base de données.
     */
    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
        personneDao = db.personneDao()
    }

    /**
     * Fonction exécutée après tous les tests.
     * Elle ferme la connexion à la base de données.
     */
    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    /**
     * Fonction de test.
     * Cette fonction test la fonction d'insertion de personne.
     */
    @Test
    @Throws(Exception::class)
    fun insert() {
        val userAvant = Personne(0,"Cosson","Leïla")
        val id = personneDao.insert(userAvant)

        val userApres = personneDao.get(id)

        assertEquals(userAvant.nom,userApres.nom)
        assertEquals(userAvant.prenom,userApres.prenom)
    }
}