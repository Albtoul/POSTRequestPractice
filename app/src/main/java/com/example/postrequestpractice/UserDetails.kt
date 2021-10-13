package com.example.postrequestpractice

class Users {

    var data: List<UserDetails>? = null

    class UserDetails {

        var name: String? = null
        var location: String? = null

        constructor(name: String?, location: String?) {
            this.name = name
            this.location = location
        }
    }
}