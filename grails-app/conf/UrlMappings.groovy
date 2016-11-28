class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/api/guest/index"(controller:'post',action:'index')
        "/api/post/create"(controller:'post',action:'createNewPost')
        "/api/user/index"(controller:'user',action:'index')
	}
}
