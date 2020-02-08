package com.bosqueoeste.ualapp.presentation.detail

import com.bosqueoeste.ualapp.data.models.Meal

data class MealDetailUseCase(
    val id: String?,
    val title: String,
    val instructions: String
) {
    constructor(meal: Meal) : this(
        id = meal.idMeal,
        title = meal.strMeal.orEmpty(),
        instructions = meal.strInstructions.orEmpty()
    )
}