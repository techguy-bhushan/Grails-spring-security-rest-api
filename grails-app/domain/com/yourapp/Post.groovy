package com.yourapp

class Post {

    String content
    User postBy

    static constraints = {
        content nullable: false, maxSize: 256
        postBy nullable: false
    }
}
