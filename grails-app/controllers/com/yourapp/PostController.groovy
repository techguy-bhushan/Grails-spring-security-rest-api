package com.yourapp

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PostController {

    def springSecurityService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", createNewPost: "POST"]

    // Admin can use all list of user's Post
    @Secured("permitAll")
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Post.list(params), [formats:['xml', 'json']]
    }

    @Secured('ROLE_USER')
    @Transactional
    def createNewPost(String content) {
        if (content == null) {
            notFound()
            return
        }
        User currentUser = (User)springSecurityService.currentUser
        Post post = new Post(content: content, postBy : currentUser)
        post.save flush:true
        respond   post, [formats:['xml', 'json']]
    }


    @Transactional
    def delete(Long id) {

        Post post = Post.get(id)
        if(!post) {
            notFound()
            return
        }
        post.delete(flush:true)
        '*'{ render status:  OK}
    }

    protected void notFound() {
        request.withFormat {
            '*'{ render status: NOT_FOUND }
        }
    }
}
