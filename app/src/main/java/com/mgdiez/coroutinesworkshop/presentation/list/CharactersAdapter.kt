package com.mgdiez.coroutinesworkshop.presentation.list

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.mgdiez.coroutinesworkshop.R
import com.mgdiez.coroutinesworkshop.presentation.model.CharacterViewModel
import com.mgdiez.coroutinesworkshop.presentation.model.Network
import com.mgdiez.coroutinesworkshop.presentation.extensions.inflate
import com.mgdiez.coroutinesworkshop.presentation.extensions.load
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.characters_adapter.view.*

class CharactersAdapter(val onItemClickListener: (CharacterViewModel, ImageView) -> Unit) :
    RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {

    private var items: MutableList<CharacterViewModel> = mutableListOf()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder =
        CharactersViewHolder(parent.inflate(R.layout.characters_adapter))

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) =
        holder.bind(items[position]) { item, imageView -> onItemClickListener(item, imageView) }

    fun addItems(items: List<CharacterViewModel>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class CharactersViewHolder constructor(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: CharacterViewModel, listener: (CharacterViewModel, ImageView) -> Unit) =
            with(itemView) {
                ViewCompat.setTransitionName(ivCharacter, item.id.toString())
                tvName.text = item.name
                ivNetwork.setImageResource(
                    when (item.network) {
                        Network.Online -> R.drawable.icv_cloud
                        Network.Offline -> R.drawable.icv_save
                    }
                )
                ivCharacter.load(item.image)
                setOnClickListener { listener(item, ivCharacter) }
            }
    }
}
