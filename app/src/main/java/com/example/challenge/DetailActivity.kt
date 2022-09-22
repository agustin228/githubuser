package com.example.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_USER = "extra_user"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<User>(EXTRA_USER) as User
        val tv_Name = "${data.name}"
        val tv_Username = "${data.username}"
        val tv_Company = "${data.company}"
        val img_Photo = data.photo
        val tv_Location = "${data.location}"
        val tv_Repository = "${data.repository}"
        val tv_Following = " ${data.following}"
        val  tv_Followers = "${data.followers}"


        val tvUsername : TextView = findViewById(R.id.tv_username)
        val tvName : TextView = findViewById(R.id.tv_name)
        val tvCompany : TextView = findViewById(R.id.tv_company)
        val imgPhoto : ImageView = findViewById(R.id.img_item_profile)
        val tvLocation : TextView = findViewById(R.id.tv_location)
        val tvRepository : TextView = findViewById(R.id.tv_repository)
        val tvFollowing : TextView = findViewById(R.id.tv_following)
        val  tvFollowers : TextView = findViewById(R.id.tv_followers)


        tvUsername.text = tv_Username
        tvName.text = tv_Name
        tvCompany.text = tv_Company
        tvLocation.text = tv_Location
        tvRepository.text =tv_Repository
        tvFollowing.text = tv_Following
        tvFollowers.text = tv_Followers
        imgPhoto.setImageResource(img_Photo)


    }
}