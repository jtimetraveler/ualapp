package com.bosqueoeste.ualapp.presentation.detail

import com.bosqueoeste.ualapp.data.models.Meal
import com.bosqueoeste.ualapp.utils.notEmpty

data class MealDetailUseCase(
    val id: String?,
    val title: String,
    val instructions: String,
    val ingredients: List<String>
) {
    constructor(meal: Meal) : this(
        id = meal.idMeal,
        title = meal.strMeal.orEmpty(),
        instructions = meal.strInstructions.orEmpty(),
        ingredients = listOfNotNull(
            meal.strIngredient1.notEmpty(),
            meal.strIngredient2.notEmpty(),
            meal.strIngredient3.notEmpty(),
            meal.strIngredient4.notEmpty(),
            meal.strIngredient5.notEmpty(),
            meal.strIngredient6.notEmpty(),
            meal.strIngredient7.notEmpty(),
            meal.strIngredient8.notEmpty(),
            meal.strIngredient9.notEmpty(),
            meal.strIngredient10.notEmpty(),
            meal.strIngredient11.notEmpty(),
            meal.strIngredient12.notEmpty(),
            meal.strIngredient13.notEmpty(),
            meal.strIngredient14.notEmpty(),
            meal.strIngredient15.notEmpty(),
            meal.strIngredient16.notEmpty(),
            meal.strIngredient17.notEmpty(),
            meal.strIngredient18.notEmpty(),
            meal.strIngredient19.notEmpty(),
            meal.strIngredient20.notEmpty()
        )
    )

    val ingredientsLabel = ingredients.joinToString(
        separator = "\n-",
        prefix = "-"
    )
}