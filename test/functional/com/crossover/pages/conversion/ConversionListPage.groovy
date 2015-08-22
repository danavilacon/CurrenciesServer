package com.crossover.pages.conversion

import geb.Module
import geb.Page

class ConversionListPage extends Page {

    static url = "conversion"

    static at = { $('h2').text() == 'Conversion List' }

    static content = {
		currencyFromFilter {$("select[ng-model='ctrl.filter.currencyFromId']")}
		currencyToFilter {$("select[ng-model='ctrl.filter.currencyToId']")}
	
		currencyFromSort { $("table#list th[property='currencyFrom']") }
		currencyToSort { $("table#list th[property='currencyTo']") }
    
	    createButton { $("button[crud-button='create']") }
        successMessage { $(".alert-success") }
		
        rows { moduleList ConversionListRow, $("table#list tbody tr") }
    }

}

class ConversionListRow extends Module {

	static content = {
		cell { $("td") }
        editButton {$("button[crud-button='edit']")}
        deleteButton {$("button[crud-button='delete']")}
    }

}