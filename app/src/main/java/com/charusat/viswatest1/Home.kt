package com.charusat.viswatest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.Adapter
//import com.PersonAdapter
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        refreshrecycle()
        btninsert.setOnClickListener {
          var name  = edtname.text.toString()
//            edtlname.setText()
          var lname  = edtlname.text.toString()
          var db = DBhelper(this)
          var mytable = MyTable(name,lname)
          var isdatainsert = db.insert(mytable)
          if(isdatainsert){
              Toast.makeText(this,"insrted",Toast.LENGTH_LONG).show()
          }
          else{
              Toast.makeText(this,"not insrted",Toast.LENGTH_LONG).show()
          }
            refreshrecycle()

      }
    }

    private fun refreshrecycle() {
        var db = DBhelper(this)
        var arr:ArrayList<MyTable> = db.getdata()
        var tbadapter = Adapter(this ,arr)
        myrecylerview.adapter = tbadapter

    }
}