package com.example.superheros.ui.adapters

import android.graphics.ColorSpace.Model
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheros.R
import com.example.superheros.databinding.ItemHeroBinding
import com.example.superheros.domain.model.Hero
import com.squareup.picasso.Picasso


class HeroAdapter(val heros: List<Hero>,  private val onItemClicked: (Hero) -> Unit): RecyclerView.Adapter<HeroAdapter.HeroHolder>() {


    class HeroHolder(val view: View): RecyclerView.ViewHolder(view){
        val binding = ItemHeroBinding.bind(view)

        fun render(hero: Hero){
            binding.tvSuperHeroName.text = hero.name
            binding.tvRealName.text = hero.biography.fullName
            binding.tvAlignment.text = if(hero.biography.alignment != "") hero.biography.alignment else "??"
            Picasso.get().load(hero.images.md).into(binding.ivHero)
//            binding.itemHeroContainer.setOnClickListener({ hero ->
//
//            })
        }


    }

//    interface OnItemClickListener {
//        fun onItemClick(hero: Hero)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_hero, parent, false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(heros[position])
        holder.itemView.setOnClickListener { onItemClicked(heros[position]) }
    }

    override fun getItemCount(): Int  = heros.size

}

