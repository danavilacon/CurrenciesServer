package com.crossover.pages.rate

import geb.Module
import geb.Page

class RateListPage extends Page {

    static url = "rate"

    static at = { $('h2').text() == 'Rate List' }

    static content = {
		conversionFilter {$("select[ng-model='ctrl.filter.conversionId']")}
		dateFilter {$("input[ng-model='ctrl.filter.date']")}
		valueFilter {$("input[ng-model='ctrl.filter.value']")}
	
		conversionSort { $("table#list th[property='conversion']") }
		dateSort { $("table#list th[property='date']") }
		valueSort { $("table#list th[property='value']") }
    
	    createButton { $("button[crud-button='create']") }
        successMessage { $(".alert-success") }
		
        rows { moduleList RateListRow, $("table#list tbody tr") }
    }

}

class RateListRow extends Module {

	static content = {
		cell { $("td") }
        editButton {$("button[crud-button='edit']")}
        deleteButton {$("button[crud-button='delete']")}
    }

}