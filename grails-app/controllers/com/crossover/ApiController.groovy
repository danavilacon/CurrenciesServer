package com.crossover
import com.crossover.*
import grails.converters.JSON

class ApiController {
	def getrange() { 
		// /api/getrange/$fromdate/$todate/$fromcode/$tocode
		// /api/getrange/2015-08-20/2015-08-21/EUR/USD
		// [{"date": "2015-08-20","value": 1.0089},{"date": "2015-08-21","value": 1.0089}]


		render params as JSON 
	}
	def getlatest() { 
		// /api/getlatest/$code
		// /api/getlatest/USD
		// [{"code": "EUR","value":0.894214432621},{"code": "CLP","value":700.21}]


		render params as JSON 
	}
	def getconversion() {
		// /api/getconversion/$fromcode/$tocode/$value
		// /api/getconversion/usd/eur/1
		// {"date": "2015-08-22","value":0.894214432621}


		render params as JSON
	}
	
}