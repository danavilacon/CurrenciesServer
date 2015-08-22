package com.crossover.pages.currency

import geb.Module
import geb.Page

class CurrencyListPage extends Page {

    static url = "currency"

    static at = { $('h2').text() == 'Currency List' }

    static content = {
		codeFilter {$("input[ng-model='ctrl.filter.code']")}
		countryFilter {$("input[ng-model='ctrl.filter.country']")}
	
		codeSort { $("table#list th[property='code']") }
		countrySort { $("table#list th[property='country']") }
    
	    createButton { $("button[crud-button='create']") }
        successMessage { $(".alert-success") }
		
        rows { moduleList CurrencyListRow, $("table#list tbody tr") }
    }

}

class CurrencyListRow extends Module {

	static content = {
		cell { $("td") }
        editButton {$("button[crud-button='edit']")}
        deleteButton {$("button[crud-button='delete']")}
    }

}