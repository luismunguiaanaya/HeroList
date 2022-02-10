package com.example.superheros.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheros.R
import com.example.superheros.databinding.FragmentHerosListBinding
import com.example.superheros.domain.model.Hero
import com.example.superheros.ui.adapters.HeroAdapter
import com.example.superheros.ui.viewmodel.HeroListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HerosListFragment : Fragment() {

    private lateinit var binding: FragmentHerosListBinding
    private val heroListViewModel: HeroListViewModel by viewModels()
    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHerosListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        heroListViewModel.onCreate()
        binding.rvHeros.layoutManager = LinearLayoutManager(this.context)

        setList()
        setLoading()
    }

    fun setList(){
        heroListViewModel.list.observe(viewLifecycleOwner, Observer {
            setRecycler(it)
        })
    }

    fun setLoading(){
        heroListViewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.progress.isVisible = isLoading
        })
    }

    fun setRecycler(heros: List<Hero>){
            adapter = HeroAdapter(heros, { hero -> navigateToHero(hero)})
            binding.rvHeros.adapter = adapter
    }

    fun navigateToHero(hero: Hero){
            val bundle = Bundle()
            bundle.putSerializable("hero", hero)
            view?.findNavController()?.navigate(R.id.action_list_to_detail, bundle)
    }

}