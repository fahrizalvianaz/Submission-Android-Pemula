package com.example.checktif

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPlace: RecyclerView
    private val list = ArrayList<Place>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPlace = findViewById(R.id.rv_place)
        rvPlace.setHasFixedSize(true)

        list.addAll(getListPlace())
        showRecylerList()




    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intentAbout = Intent (this, AboutActivity::class.java)
                startActivity(intentAbout)
            }

        }
        return super.onOptionsItemSelected(item)
    }
    private fun getListPlace(): ArrayList<Place> {
        val dataName = resources.getStringArray(R.array.placeName)
        val dataAddress = resources.getStringArray(R.array.placeAddress)
        val dataImages = resources.obtainTypedArray(R.array.placeImages)
        val dataDesctiption = resources.getStringArray(R.array.placeDescription)
        val dataFullAddress = resources.getStringArray(R.array.placeFullAddress)
        val dataTiket = resources.getStringArray(R.array.placeTicket)
        val listPlace = ArrayList<Place>()
        for( i in dataName.indices) {
            val place = Place(dataName[i], dataAddress[i], dataImages.getResourceId(i,-1), dataDesctiption[i],dataFullAddress[i],dataTiket[i])
            listPlace.add(place)
        }

        return listPlace
    }
    private fun showRecylerList() {
        rvPlace.layoutManager = GridLayoutManager(this, 2)
        val listPlaceAdapter = ListPlaceAdapter(list)
        rvPlace.adapter = listPlaceAdapter
        listPlaceAdapter.onItemClick = {
            val intent = Intent (this, DetailActivity::class.java)
            intent.putExtra("key_place", it)
            startActivity(intent)
        }
    }
}