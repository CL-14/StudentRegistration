package com.example.studentregistration.entities

class Booking(val Name: String, val NoPeople: Int, val Days: Int) {
    var amtToPay = 0.0
    /* Function to calculate amount due for booking */
    fun CalculateAmt(): Double{
        this.amtToPay = (this.NoPeople * 50.5*this.Days).toDouble()
        return this.amtToPay
    }

    fun GetName(): String{
        return this.Name
    }
}