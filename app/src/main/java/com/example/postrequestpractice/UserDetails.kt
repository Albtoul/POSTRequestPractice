package com.example.postrequestpractice

class Users {

    var data: List<UserDetails>? = null

    class UserDetails {

        var name: String? = null
        var location: String? = null
        var pk :Int?=null

        constructor(name: String?, location: String?,pk :Int?) {
            this.name = name
            this.location = location
            this.pk=pk
        }
    }
}