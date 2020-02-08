package com.bosqueoeste.ualapp.presentation.list

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bosqueoeste.ualapp.R
import com.bosqueoeste.ualapp.presentation.base.BaseActivity
import com.bosqueoeste.ualapp.presentation.detail.MealDetailActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_meal_list.*
import javax.inject.Inject

class MealListActivity : BaseActivity(), MealListContract.View {

    @Inject
    lateinit var presenter: MealListContract.Presenter<MealListContract.View>

    private lateinit var mealListAdapter: MealListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_list)
        setSupportActionBar(toolbarMealList)
        setupViews()
        presenter.view = this
        presenter.updateMealList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_meal_list, menu)

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchItem.collapseActionView()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                presenter.updateMealList(newText.orEmpty())
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    private fun setupViews() {
        mealListAdapter = MealListAdapter {
            presenter.selectMealItem(it)
        }
        recyclerMealList?.run {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = mealListAdapter
        }
    }

    override fun showMeals(meals: List<ItemMeal>) {
        mealListAdapter.refreshData(meals)
    }

    override fun goToMealDetail(mealId: String) {
        startActivity(MealDetailActivity.getIntent(this, mealId))
    }
}
