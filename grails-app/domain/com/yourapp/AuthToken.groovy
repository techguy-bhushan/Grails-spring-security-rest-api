package com.yourapp

class AuthToken {

    String username
    String token
    static constraints = {
        username nullable: false
        token nullable: false
    }
}
