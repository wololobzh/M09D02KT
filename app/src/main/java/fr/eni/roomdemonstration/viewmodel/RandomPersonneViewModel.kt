package fr.eni.roomdemonstration.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import fr.eni.roomdemonstration.dao.PersonneDao
import fr.eni.roomdemonstration.model.Personne

class RandomPersonneViewModel(val personneDao: PersonneDao, application: Application) : AndroidViewModel(application) {
    val personne = MutableLiveData<Personne>();

    fun randomPersonne() {
        //TODO Mettre à jour la variable "personne"
    }
}
