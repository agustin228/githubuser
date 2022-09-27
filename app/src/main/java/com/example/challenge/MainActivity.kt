package com.example.challenge

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var rvUser: RecyclerView
    private lateinit var searchList: ArrayList<User>
    private lateinit var tempList: ArrayList<User>
    private val list = ArrayList<User>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_profile)
        rvUser.setHasFixedSize(true)
        tempList = ArrayList<User>()

        list.addAll(listUsers)
        showRecyclerList()


    }

    private val listUsers: ArrayList<User>
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val listUser = ArrayList<User>()

            ///getUserData Method
            for (i in dataName.indices) {
                val user = User(
                    dataUsername[i], dataName[i], dataCompany[i], dataPhoto.getResourceId(i, -1),
                    "Location : ${dataLocation[i]}", "Repository : ${dataRepository[i]}",
                    "Following : ${dataFollowing[i]}", "Followers : ${dataFollowers[i]}"
                )
                listUser.add(user)

            }
            tempList.addAll(listUser)
            return listUser

        }

    private fun showRecyclerList() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val listProfilAdapter = ListProfileAdapter(tempList)
        rvUser.adapter = listProfilAdapter


        listProfilAdapter.setOnItemClickCallback(object : ListProfileAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra(DetailActivity.EXTRA_USER, data)
                startActivity(intentToDetail)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search).actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            /*
             method ketika search selesai ditekan
             */

            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
                searchView.clearFocus()
                return true
            }

            /*
             method untuk merespon tiap perubahan huruf pada searchView
             */
            override fun onQueryTextChange(newText: String): Boolean {
                tempList.clear()
                val searchUser = newText!!.lowercase(Locale.getDefault())
                if (searchUser.isNotEmpty()) {

                    list.forEach {
                        if (it.username.lowercase(Locale.getDefault()).contains(searchUser))

                            tempList.add(it)


                    }
                    rvUser.adapter!!.notifyDataSetChanged()
                } else {
                    tempList.clear()
                    tempList.addAll(list)
                    rvUser.adapter!!.notifyDataSetChanged()


                }
                return false

            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}




