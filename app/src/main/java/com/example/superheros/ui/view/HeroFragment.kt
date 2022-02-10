package com.example.superheros.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.superheros.databinding.FragmentHeroBinding
import com.example.superheros.domain.model.Hero
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroFragment : Fragment() {

    private lateinit var binding: FragmentHeroBinding
    private lateinit var hero: Hero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            this.hero = it.getSerializable("hero") as Hero
            Log.d("hero", this.hero.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeroBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load(hero.images.lg).into(binding.ivHero)
        binding.tvSuperHeroName.text = hero.name
        binding.tvRealName.text = hero.biography.fullName
        binding.tvStats.text = hero.powerstats.toString()
        binding.tvAppareance.text = hero.appearance.toString()
        binding.tvBiography.text = hero.biography.toString()
        binding.tvWork.text = hero.work.toString()
        binding.tvConnections.text = hero.connections.toString()
    }


}