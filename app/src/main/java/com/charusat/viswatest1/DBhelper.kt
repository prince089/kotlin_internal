package com.charusat.viswatest1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.security.AccessControlContext

class DBhelper(var context: Context) :SQLiteOpenHelper(context, DBNAME,null, DBVERSION){
    companion object{
        private var DBNAME = "viswa"
        private var DBVERSION = 2
        private var TBNAME = "MYTABLE"
        private var MYID = "id"
        private var MYNAME = "name"
        private  var MYLNAME ="LASTNAME"


    }

    override fun onCreate(p0: SQLiteDatabase?) {
//        TODO("Not yet implemented")
        var query = "CREATE TABLE $TBNAME ($MYID INTEGER PRIMARY KEY AUTOINCREMENT,$MYNAME TEXT,$MYLNAME TEXT)"
        p0?.execSQL(query)
    }


    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var query = "DROP TABLE $TBNAME IF EXISTS"
        p0?.execSQL(query)
        onCreate(p0)


    }
    fun insert(mytable:MyTable) : Boolean{
          var db = writableDatabase
            var cv = ContentValues()
      cv.put(MYNAME,mytable.name)
        cv.put(MYLNAME,mytable.lname)
        var responce = db.insert(TBNAME,null,cv)
        if(responce > 0){
            return true
        }
        else{
            return false
        }
        getdata()
    }

    fun getdata():ArrayList<MyTable> {
        var db = readableDatabase
        var cur =db.query(TBNAME,null,null,null,null,null,null)
        var arr:ArrayList<MyTable> = ArrayList()
        while (cur.moveToNext()){
            var id = cur.getInt(0)
            var name = cur.getString(1)
            var lname = cur.getString(2)
            print(id)
            print(name)
            print(lname)
            var kkpk = MyTable(id,name,lname)
            arr.add(kkpk)

        }
        return arr

    }
}