package com.yourapp

import grails.plugin.springsecurity.annotation.Secured
class UserController {

    @Secured('ROLE_ADMIN')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), [formats:['xml', 'json']]
    }

}
