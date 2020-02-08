package com.bosqueoeste.ualapp.data.api

import com.bosqueoeste.ualapp.data.api.response.MealListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface UalappApi {

    @GET("search.php")
    fun getMeals(
        @Query("s") search: String = ""
    ): Observable<MealListResponse>
}