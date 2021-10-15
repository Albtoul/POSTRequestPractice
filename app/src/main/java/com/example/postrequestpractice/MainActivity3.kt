package com.example.postrequestpractice

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity3 : AppCompatActivity() {
    lateinit var userID :EditText
    val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        val name = findViewById<View>(R.id.editTextTextPersonName2) as EditText
        val location = findViewById<View>(R.id.editTextTextPersonName3) as EditText
        val delete = findViewById<View>(R.id.button) as Button
        val update = findViewById<View>(R.id.button) as Button

        userID = findViewById(R.id.editTextTextPersonName)

        update.setOnClickListener {
            var f = Users.UserDetails(name.text.toString(), location.text.toString(), userID.text.toString().toInt())

            update(f)
        }
        delete.setOnClickListener {

            var f = Users.UserDetails(name.text.toString(), location.text.toString(), userID.text.toString().toInt())
            apiInterface?.delete(userID)?.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                }

                override fun onFailure(call: Call<Void>, t: Throwable) {

                }
            })



                }


    }

    private fun update(f: Users.UserDetails) {
        val progressDialog = ProgressDialog(this@MainActivity3)
        progressDialog.setMessage("Please wait")
        progressDialog.show()

        if (apiInterface != null) {
            apiInterface.update(userID.text.toString().toInt(),f).enqueue(object : Callback<Users.UserDetails> {
                override fun onResponse(
                    call: Call<Users.UserDetails>,
                    response: Response<Users.UserDetails>
                ) {

                    progressDialog.dismiss()
                }

                override fun onFailure(call: Call<Users.UserDetails>, t: Throwable) {

                    Toast.makeText(applicationContext, "Error!", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss()

                }
            })
        }

    }






    fun viewusers(view: android.view.View) {
        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }



}



