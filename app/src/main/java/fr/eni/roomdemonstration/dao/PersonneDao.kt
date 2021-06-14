package fr.eni.roomdemonstration.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.eni.roomdemonstration.model.Personne

@Dao
interface PersonneDao {
    /**
     * L'entier retourné représente l'identitifiant de la personne insérée en base de données.
     */
    @Insert
    fun insert(personne: Personne): Long

    @Query("SELECT * FROM Personne WHERE id = :id")
    operator fun get(id: Long): Personne

    @Query("SELECT * FROM Personne ORDER BY nom,prenom")
    fun get(): LiveData<List<Personne?>>

    @Update
    fun update(personne: Personne)

    @Delete
    fun delete(personne: Personne)
}
