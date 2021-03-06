package com.crossover.pages.currency

import geb.Module
import geb.Page

class CurrencyEditPage extends Page {

    static url = "currency#/create"

    static at = { $('h2').text() == 'Edit Currency' }

    static content = {
		codeField {$("input[ng-model='ctrl.currency.code']")}
		countryField {$("input[ng-model='ctrl.currency.country']")}
        saveButton { $('button[crud-button="save"]') }
    }

}