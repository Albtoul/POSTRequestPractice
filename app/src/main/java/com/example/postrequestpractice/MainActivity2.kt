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

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val name = findViewById<View>(R.id.editTextTextPersonName) as EditText
        val location = findViewById<View>(R.id.editTextTextPersonName2) as EditText
        val savebtn = findViewById<View>(R.id.button) as Button

        savebtn.setOnClickListener {

            var f = Users.UserDetails(name.text.toString(), location.text.toString(),0)

            addSingleuser(f)
        }
    }



      private fun addSingleuser(f: Users.UserDetails) {

          val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
          val progressDialog = ProgressDialog(this@MainActivity2)
          progressDialog.setMessage("Please wait")
          progressDialog.show()

          if (apiInterface != null) {
              apiInterface.addUser(f).enqueue(object : Callback<Users.UserDetails> {
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





    fun addnew(view: android.view.View) {
        intent = Intent(applicationContext, MainActivity2::class.java)
        startActivity(intent)
    }

    fun viewusers(view: android.view.View) {
        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }



}