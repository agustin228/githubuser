package com.example.challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
   private lateinit var rvUser :RecyclerView
   private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_profile)
        rvUser.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()


    }

    private val listUsers : ArrayList<User>
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
        for (i in dataName.indices) {
            val user = User(dataUsername[i],dataName[i], dataCompany[i] , dataPhoto.getResourceId(i, -1),
            "Location : ${dataLocation[i]}", "Repository : ${dataRepository[i]}",
                "Following : ${dataFollowing[i]}", "Followers : ${dataFollowers[i]}")
            listUser.add(user)
        }
        return listUser
    }

    private fun showRecyclerList(){
        rvUser.layoutManager = LinearLayoutManager(this)
        val listProfilAdapter = ListProfileAdapter(list)
        rvUser.adapter = listProfilAdapter


        listProfilAdapter.setOnItemClickCallback(object : ListProfileAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra(DetailActivity.EXTRA_USER, data)
                startActivity(intentToDetail)
            }
        })
    }
}