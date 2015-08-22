class UrlMappings {

	static mappings = {

        						'/rate'(view: 'rate')
		'/api/rate'(resources: 'rate')
'/conversion'(view: 'conversion')
		'/api/conversion'(resources: 'conversion')
'/currency'(view: 'currency')
		'/api/currency'(resources: 'currency')
"/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
