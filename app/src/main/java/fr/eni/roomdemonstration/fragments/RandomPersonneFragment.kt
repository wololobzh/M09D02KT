package fr.eni.roomdemonstration.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import fr.eni.roomdemonstration.R
import fr.eni.roomdemonstration.databinding.FragmentRandomPersonneBinding
import fr.eni.roomdemonstration.viewmodel.RandomPersonneViewModel
import fr.eni.roomdemonstration.viewmodel.utils.ViewModelFactory

class RandomPersonneFragment : Fragment() {
    private lateinit var binding: FragmentRandomPersonneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_random_personne, container, false)

        //Permet de recupéré le contexte, seule composante neessaire pour la factory
        val application = requireNotNull(this.activity).application

        //Ici est la ligne permettant de bien saisir l'interet de l'injection de dependance.
        //Nous recuperons un objet de type RandomPersonneViewModel sans nous soucier de ce qui est necessaire pour le construire
        val randomPersonneViewModel = ViewModelProvider(this, ViewModelFactory(application)).get(RandomPersonneViewModel::class.java)

        //Permet de lier le viewModel à l'IHM
        binding.randomPersonneViewModel = randomPersonneViewModel

        return binding.root
    }
}
