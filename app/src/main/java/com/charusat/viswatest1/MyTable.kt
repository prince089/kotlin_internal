package com.charusat.viswatest1

data class MyTable(var name:String , var lname:String){
    var id:Int = 0
    constructor(id:Int, name:String,lname:String):this(name,lname){
        this.id = id
    }
}