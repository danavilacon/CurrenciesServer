package com.crossover.pages.conversion

import geb.Module
import geb.Page

class ConversionCreatePage extends Page {

    static url = "conversion#/create"

    static at = { $('h2').text() == 'Create Conversion' }

    static content = { 
		currencyFromField {$("select[ng-model='ctrl.conversion.currencyFrom']")}
		currencyToField {$("select[ng-model='ctrl.conversion.currencyTo']")}
        saveButton { $('button[crud-button="save"]') }
    }

}