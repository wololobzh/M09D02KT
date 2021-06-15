package fr.eni.roomdemonstration.viewmodel.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.eni.roomdemonstration.dao.utils.AppDatabase
import fr.eni.roomdemonstration.viewmodel.RandomPersonneViewModel

class ViewModelFactory(private val application: Application) : ViewModelProvider.Factory
{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RandomPersonneViewModel::class.java)) {
            var personneDao = AppDatabase.getInstance(application).personneDao()
            return RandomPersonneViewModel(
                personneDao,
                application
            ) as T
        }
        throw IllegalArgumentException("ViewModel inconnu")
    }
}
