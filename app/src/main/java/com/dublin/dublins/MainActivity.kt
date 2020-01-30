package com.dublin.dublins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList
//(MD .IMRUL MAHAMUD
//STUDENT ID:18317
//MD.ROKIBUL ISLAM
//STUDENT ID:18315

class MainActivity : AppCompatActivity() {
    // API URL
//    val url : String = "https://api.jcdecaux.com/vls/v1/stations?contract=dublin&apiKey=feb54e2e8dd2f7c99631122b11957d78c0d510b5";

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var RV : RecyclerView;
//    private lateinit var btn_refres : Button;

//    @BindView(R.id.btn_map_page)  btn_map as Button;


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Just pres when data is not come successfully
        supportActionBar?.hide()
        btn_refresh_page.setOnClickListener {
            list = ArrayList<DUBLIN_MODEL?>()
            list!!.clear()

            request()
        }
// to show the list of all station on map
        btn_map_page.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            // To pass any data to next activity
//            intent.putExtra("keyIdentifier", value)
            // start your next activity
            startActivity(intent)
        }


        request();
        RV= findViewById(R.id.RV_MAIN) as RecyclerView
        linearLayoutManager = LinearLayoutManager(this)
        RV.layoutManager = linearLayoutManager
    }
    // HTTP request
    public fun request()
    {
        list = ArrayList<DUBLIN_MODEL?>()
        list!!.clear();

        val mRequestQueue = Volley.newRequestQueue(this)
        // station api link
        val basePath = "https://api.jcdecaux.com/vls/v1/stations?contract=dublin&apiKey=feb54e2e8dd2f7c99631122b11957d78c0d510b5"


        //String Request initialized
        val mStringRequest = object : StringRequest(Request.Method.GET, basePath, Response.Listener { response ->
            Toast.makeText(applicationContext, "Logged In Successfully", Toast.LENGTH_SHORT).show()


            try {
                val j = JSONArray(response)
                for (i in 0 until j.length())
                {
//                  retriving data from the api
                    val json_object = j.getJSONObject(i)
                    var number = json_object.getString("number")
                    var contract_name = json_object.getString("contract_name")
                    var name = json_object.getString("name")
                    var address = json_object.getString("address")
                    var position = json_object.getString("position")
                    var banking = json_object.getString("banking")
                    var bonus = json_object.getString("bonus")
                    var bike_stands = json_object.getString("bike_stands")
                    var available_bike_stands = json_object.getString("available_bike_stands")
                    var available_bikes = json_object.getString("available_bikes")
                    var status = json_object.getString("status")
                    var last_update = json_object.getString("last_update")

                    val d = DUBLIN_MODEL(number,contract_name,name,address,position,banking,bonus,bike_stands,available_bike_stands,available_bikes,status,last_update)

                    list!!.add(d)


                }

                val rrv = RV_dublin_adopter(list,this);
                // set the list adopter show list
                RV.adapter = rrv;

            }
            catch (e: JSONException)
            {
                e.printStackTrace()
                Toast.makeText(applicationContext,e.toString(),Toast.LENGTH_LONG).show();
            }








        }, Response.ErrorListener { error ->
            Log.i("This is the error", "Error :" + error.toString())
            Toast.makeText(applicationContext, "Please make sure you enter correct password and username", Toast.LENGTH_SHORT).show()
        }) {
            override fun getBodyContentType(): String {
                return "application/json"
            }

            @Throws(AuthFailureError::class)
            override fun getBody(): ByteArray {
                // GET veriable to pass in api
                val params2 = HashMap<String, String>()
                params2.put("contract","dublin" )
                params2.put("apiKey", "feb54e2e8dd2f7c99631122b11957d78c0d510b5")
                return JSONObject(params2 as Map<*, *>).toString().toByteArray()
            }

        }
        mRequestQueue!!.add(mStringRequest)

    }

    companion object {
        var list: ArrayList<DUBLIN_MODEL?>? = null

    }
}
