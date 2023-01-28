package com.example.githubuser

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val dataUser = "DATA"

    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var userRv: RecyclerView
    private val list = ArrayList<User>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        userRv = findViewById(R.id.rv_user)
        userRv.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()
    }

    private val listUser: ArrayList<User>
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listUser = ArrayList<User>()
            for (i in dataName.indices) {
                val dataUser = User(
                    dataUsername[i],
                    dataName[i],
                    dataPhoto.getResourceId(i, -1),
                    dataLocation[i],
                    dataCompany[i],
                    dataRepository[i],
                    dataFollowers[i],
                    dataFollowing[i]

                )
                listUser.add(dataUser)
            }
            return listUser
        }

    private fun showRecyclerList() {
        userRv.layoutManager = GridLayoutManager(this, 2)
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            userRv.layoutManager = GridLayoutManager(this, 2)
    }else {
        userRv.layoutManager = LinearLayoutManager(this)
    }

    val ListUserAdapter = ListUserAdapter(listUser)
        userRv.adapter=ListUserAdapter

        ListUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
        override fun onItemClicked(data: User) {
            val moveIntent = Intent(this@MainActivity, TampilanActivity::class.java)
            moveIntent.putExtra(dataUser, data)
            startActivity(moveIntent)

        }
    })
}

}
