package com.crossover

class Currency {
	String code
	String country

    static constraints = {
    	code maxSize: 3
    }
}
