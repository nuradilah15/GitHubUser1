package com.example.githubuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubuser.databinding.ActivityTampilanBinding

class TampilanActivity : AppCompatActivity() {

    companion object{
        const val dataUser = "DATA"

    }
    private lateinit var binding: ActivityTampilanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTampilanBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val data = intent.getParcelableExtra<User>(dataUser) as User
        binding.tvItemName.text = data.name
        binding.tvItemUsername.text = data.username
        binding.imgItemPhoto.setImageResource(data.avatar)
        binding.tvItemLocation.text = data.location
        binding.tvItemCompany.text = data.company
        binding.tvItemRepository.text = data.repository
        binding.tvItemFollowers.text = data.followers
        binding.tvItemFollowing.text = data.following
    }
}