package com.example.layoutapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Access the view using the resource ID
        val btnSend: Button = findViewById(R.id.btnSend)
        val etMonday = findViewById<EditText>(R.id.etMonday)
        val etTuesday = findViewById<EditText>(R.id.etTuesday)
        val etWednesday = findViewById<EditText>(R.id.etWednesday)
        val etThursday = findViewById<EditText>(R.id.etThursday)
        val etFriday = findViewById<EditText>(R.id.etFriday)

        //
        btnSend.setOnClickListener() {
            composeEmail(etMonday, etTuesday, etWednesday, etThursday, etFriday)
        }

    }


    /*
        composeEmail takes the user input and creates an email
        to: Fabrizio.Musco@primo.cafe
        subject: Woche Umsatz"
        content: t
        params: m (monday) t(tuesday) w(wednesday) th(thursday) f(friday)
    */
    fun composeEmail(m: EditText, t: EditText, w: EditText, th: EditText, f: EditText) {

        // takes the user input and converts it from double to string
        var monday = m.text.toString()
        var tuesday = t.text.toString()
        var wednesday = w.text.toString()
        var thursday = th.text.toString()
        var friday = f.text.toString()

        //Array String to store all email recipient
        val recipientList = arrayOf("Fabrizio.Musco@primo.cafe")
        //stores the subject of the email
        val subject = "Woche Umsatz"
        // stores the body of the email
        var emailBOdy = """
            Montag: $monday
            Dienstag: $tuesday
            Mitwoch: $wednesday
            Donnerstag: $thursday
            Freitag: $friday
            """.trimIndent()

        // Implicit intent Action that composes the email
        var i = Intent(Intent.ACTION_SENDTO)
        i.setData(Uri.parse("mailto:"))
        i.putExtra(Intent.EXTRA_SUBJECT, subject)
        i.putExtra(Intent.EXTRA_EMAIL, recipientList)
        i.putExtra(Intent.EXTRA_TEXT, emailBOdy)

        startActivity(i)
    }
}