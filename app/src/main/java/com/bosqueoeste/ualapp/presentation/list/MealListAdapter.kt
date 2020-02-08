package com.bosqueoeste.ualapp.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bosqueoeste.ualapp.R
import com.bosqueoeste.ualapp.utils.loadUrl
import kotlinx.android.synthetic.main.item_meal.view.*

class MealListAdapter(
    private val onItemClickListener: (ItemMeal) -> Unit
) :
    androidx.recyclerview.widget.RecyclerView.Adapter<MealListAdapter.ViewHolder>() {

    private var meals = listOf<ItemMeal>()

    fun refreshData(newMeals: List<ItemMeal>) {
        meals = newMeals
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return meals.size
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.run {
            meals[position].let { meal ->
                onBind(meal)
                itemView.setOnClickListener { onItemClickListener.invoke(meal) }
            }
        }
    }

    class ViewHolder(itemView: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        fun onBind(meal: ItemMeal) {
            itemView.run {
                titleItemMeal.text = meal.title
                categoryItemMeal.text = meal.category
                meal.imageUrl?.let {
                    imageItemMeal.loadUrl(it, R.drawable.ic_image)
                } ?: kotlin.run {
                    imageItemMeal.setImageDrawable(resources.getDrawable(R.drawable.ic_image))
                }
            }
        }
    }
}



