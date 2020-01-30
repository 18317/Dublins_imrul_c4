package com.dublin.dublins

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

import java.util.ArrayList
//(MD .IMRUL MAHAMUD
//STUDENT ID:18317
//MD.ROKIBUL ISLAM
//STUDENT ID:18315

class RV_dublin_adopter(var list: ArrayList<DUBLIN_MODEL?>?, var context: Context)
    : RecyclerView.Adapter<RV_dublin_adopter.RVDA>() {


        //To make a list from recyler view widget

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVDA {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cv_dublin_city, parent, false)
        return RVDA(v)
    }

    override fun onBindViewHolder(h: RVDA, position: Int)
    {
        // All value from the RVDA class to declare that every item speate uniqe value
        h.number.setText(list?.get(position)?.number);
        h.contract_name.setText(list?.get(position)?.contract_name);
        h.name.setText(list?.get(position)?.name);
        h.postion.setText(list?.get(position)?.postion);
        h.bouns.setText(list?.get(position)?.bouns);
        h.bike_stand.setText(list?.get(position)?.bike_stand);
        h.avil_bike_stand.setText(list?.get(position)?.available_bike_stand);
        h.avil_bikes.setText(list?.get(position)?.available_bikes);
        h.address.setText(list?.get(position)?.address);
        h.banking.setText(list?.get(position)?.banking);
        h.status.setText(list?.get(position)?.status);
        // open the details of next page about the station
        h.card.setOnClickListener {
            var intent = Intent(context,Information::class.java)
            intent.putExtra("number",list?.get(position)?.number)
            intent.putExtra("contract_name",list?.get(position)?.contract_name)
            intent.putExtra("name",list?.get(position)?.name)
            intent.putExtra("postion",list?.get(position)?.postion)
            intent.putExtra("bouns",list?.get(position)?.bouns)
            intent.putExtra("bike_stand",list?.get(position)?.bike_stand)
            intent.putExtra("available_bike_stand",list?.get(position)?.available_bike_stand)
            intent.putExtra("available_bikes",list?.get(position)?.available_bikes)
            intent.putExtra("address",list?.get(position)?.address)
            intent.putExtra("banking",list?.get(position)?.banking)
            intent.putExtra("status",list?.get(position)?.status)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return this.list!!.size
    }

    inner class RVDA(itemView: View) : ViewHolder(itemView) {
        var number: TextView
        var contract_name: TextView
        var name: TextView
        var address: TextView
        var postion: TextView
        var banking: TextView
        var bike_stand: TextView
        var avil_bike_stand: TextView
        var avil_bikes: TextView
        var status: TextView
        var bouns: TextView
        var card : CardView
        var s :String= ""
        // setup veribale
        init {
            number = itemView.findViewById(R.id.cv_number)
            this.contract_name = itemView.findViewById(R.id.cv_contract_name)
            name = itemView.findViewById(R.id.cv_name)
            postion = itemView.findViewById(R.id.cv_postion)
            bouns = itemView.findViewById(R.id.cv_bonus)
            address = itemView.findViewById(R.id.cv_address)
            bike_stand = itemView.findViewById(R.id.cv_bike_stand)
            avil_bike_stand = itemView.findViewById(R.id.cv_avilable_bike_stand)
            avil_bikes = itemView.findViewById(R.id.cv_avilable_bikes)
            banking = itemView.findViewById(R.id.cv_banking)
            status = itemView.findViewById(R.id.cv_status)
            card = itemView.findViewById(R.id.cv_card)
        }
    }

}