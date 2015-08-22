package com.crossover

import grails.converters.JSON

class CustomMarshallerRegistrar {
    
    void registerMarshallers() {

		JSON.registerObjectMarshaller(com.crossover.Rate) {
			def map = [:]
			map['id'] = it?.id
			map['conversion'] = it?.conversion
			map['date'] = it?.date
			map['value'] = it?.value
	    	map['toText'] = it?.toString()
			return map 
		}

		JSON.registerObjectMarshaller(com.crossover.Conversion) {
			def map = [:]
			map['id'] = it?.id
			map['currencyFrom'] = it?.currencyFrom
			map['currencyTo'] = it?.currencyTo
	    	map['toText'] = it?.toString()
			return map 
		}

		JSON.registerObjectMarshaller(com.crossover.Currency) {
			def map = [:]
			map['id'] = it?.id
			map['code'] = it?.code
			map['country'] = it?.country
	    	map['toText'] = it?.toString()
			return map 
		} 
	}

}