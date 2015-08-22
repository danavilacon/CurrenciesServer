class UrlMappings {

	static mappings = {
        "/api/getrange/$fromdate/$todate/$fromcode/$tocode"(controller: "api", action: "getrange",method: "GET")
        "/api/getlatest/$code"(controller: "api", action: "getlatest",method: "GET")
        "/api/getconversion/$fromcode/$tocode/$value"(controller: "api", action: "getconversion",method: "GET")
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
