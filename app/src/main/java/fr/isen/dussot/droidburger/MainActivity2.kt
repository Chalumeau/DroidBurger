package fr.isen.dussot.droidburger

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import android.content.SharedPreferences








class MainActivity2 : AppCompatActivity(),
    OnItemSelectedListener {

    lateinit var sharedPreferences: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val mPickTimeBtn = findViewById<Button>(R.id.pickTimeBtn)
        val textView = findViewById<TextView>(R.id.timeTv)

        mPickTimeBtn.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                textView.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
        // Récupération des réponses
        val nbrecup1 = findViewById<View>(R.id.PhoneET) as EditText
        val nbrecup2 = findViewById<View>(R.id.PostalAdressET) as EditText
        val nbrecup3 = findViewById<View>(R.id.FirstNameET) as EditText

        val nbrecup4 = findViewById<View>(R.id.LastNameET) as EditText
        val nbrecup5 = findViewById<View>(R.id.spinner) as Spinner
        val nbrecup6 = findViewById<View>(R.id.pickTimeBtn) as Button


        val recup1: String
        val recup2: String
        val recup3: String
        val recup4: String
        val recup5: String
        val recup6: String

        recup1 = nbrecup1.text.toString()
        recup2 = nbrecup2.text.toString()
        recup3 = nbrecup3.text.toString()
        recup4 = nbrecup4.text.toString()
        recup5 = nbrecup5.textAlignment.toString()
        recup6 = nbrecup6.text.toString()

        if (recup1 == "" || recup2 == "" || recup3 == "" || recup4 == "" || recup5 == "" || recup6 == "") {
            Toast.makeText(this, "Vous devez renseigner tous les champs !", Toast.LENGTH_SHORT).show()
            return
        }

        // Spinner element
        val spinner = findViewById<View>(R.id.spinner) as Spinner

        // Spinner click listener
        spinner.onItemSelectedListener = this

        // Spinner Drop down elements
        val categories: MutableList<String> = ArrayList()
        categories.add("Burger du chef")
        categories.add("Cheese burger")
        categories.add("Burger Montagnard")
        categories.add("Burger Italien")
        categories.add("Burger Végétarien")

        // Creating adapter for spinner
        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // attaching data adapter to spinner
        spinner.adapter = dataAdapter


        sharedPreferences = getSharedPreferences("Données utilisateur", Context.MODE_PRIVATE)

        val intent = Intent(this, PrefActivity::class.java)
        startActivity(intent)
        finish()






    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        // On selecting a spinner item
        val item = parent.getItemAtPosition(position).toString()

        // Showing selected spinner item
        Toast.makeText(parent.context, "Selected: $item", Toast.LENGTH_LONG).show()
    }



    override fun onNothingSelected(arg0: AdapterView<*>?) {

    }
}