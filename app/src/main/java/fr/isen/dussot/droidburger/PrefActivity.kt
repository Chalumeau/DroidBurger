package fr.isen.dussot.droidburger

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PrefActivity : AppCompatActivity() {


    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pref)


        preferences = getSharedPreferences("Données utilisateur", Context.MODE_PRIVATE)

        val name = preferences.getString("name", "")
        FirstNameTv.text = name
        val adress = preferences.getString("adress", "")
        AdressTv.text = adress
        val lastName = preferences.getString("last name", "")
        LastName.Tv.text = lastName



    }
}