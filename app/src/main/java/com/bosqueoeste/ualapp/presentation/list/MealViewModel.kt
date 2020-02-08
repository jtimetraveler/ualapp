package com.bosqueoeste.ualapp.presentation.list

import com.bosqueoeste.ualapp.data.models.Meal

data class MealViewModel(
    override val title: String,
    override val category: String,
    override val imageUrl: String?
) : ItemMeal {
    constructor(meal: Meal) : this(
        title = meal.strMeal.orEmpty(),
        category = meal.strCategory.orEmpty(),
        imageUrl = meal.strMealThumb
    )
}