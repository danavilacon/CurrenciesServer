package com.crossover
import com.crossover.*
import grails.converters.JSON

class ApiController {
	def getrange() { 
		// /api/getrange/$fromdate/$todate/$fromcode/$tocode
		// /api/getrange/2015-08-20/2015-08-21/EUR/USD
		// [{"date": "2015-08-20","value": 1.0089},{"date": "2015-08-21","value": 1.0089}]
		def currencyFrom = Currency.findByCode(params.fromcode)
		def currencyTo = Currency.findByCode(params.tocode)
		def conversion = Conversion.findByCurrencyFromAndCurrencyTo(currencyFrom,currencyTo)
		def rates = Rate.findAllByConversionAndDateBetween(conversion, Date.parse('yyyy-MM-dd',params.fromdate),Date.parse('yyyy-MM-dd',params.todate))

		render(contentType: "application/json") {
        	array {
            	for (r in rates) {
                	rat date: r.date.format( 'yyyy-MM-dd' ), value: r.value
            	}
        	}
    	}
	}
	def getlatest() { 
		// /api/getlatest/$code
		// /api/getlatest/USD
		// [{"code": "EUR","value":0.894214432621},{"code": "CLP","value":700.21}]
		def currency = Currency.findByCode(params.code)
		def conversion = Conversion.findAllByCurrencyFrom(currency)
		def rates = Rate.findAllByConversionInList(conversion,[sort:"date", order:"desc"])

		render(contentType: "application/json") {
        	array {
            	for (r in rates) {
                	rat code: r.conversion.currencyTo.code , value: r.value
            	}
        	}
    	}
	}
	def getconversion() {
		// /api/getconversion/$fromcode/$tocode/$value
		// /api/getconversion/USD/EUR/1
		// {"date": "2015-08-22","value":0.894214432621}
		def currencyFrom = Currency.findByCode(params.fromcode)
		def currencyTo = Currency.findByCode(params.tocode)
		def conversion = Conversion.findByCurrencyFromAndCurrencyTo(currencyFrom,currencyTo)
		def rates = Rate.findByConversion(conversion,[sort:"date", order:"desc"])
		double paramValue = params.double('value')
		def resp = [date:rates.date.format( 'yyyy-MM-dd' ),value:(rates.value*paramValue)]
		render resp as JSON
	}
	
}