package com.example.checktif

import android.content.Intent
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private lateinit var btnShare: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btnShare = findViewById(R.id.btn_share)
        val place = intent.getParcelableExtra<Place>("key_place")
        if (place != null) {
            val image: ImageView = findViewById(R.id.imageView)
            val name: TextView = findViewById(R.id.description_tittle)
            val description: TextView = findViewById(R.id.description)
            val fullAddres : TextView = findViewById(R.id.address_body)
            val tiket : TextView = findViewById(R.id.ticket_body)

            image.setImageResource(place.placeImages)
            name.text = place.placeName
            description.text = place.placeDescription
            fullAddres.text = place.placeFullAddress
            tiket.text = place.placeTicket

            val massage = "${name.text}\n\n${description.text}\n\nAlamat : \n${fullAddres.text}\n\nTiket Masuk : \n${tiket.text}"


            btnShare.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, massage)
                val chooser = Intent.createChooser(intent, "Share using....")
                startActivity(chooser)
            }
        }




    }

}