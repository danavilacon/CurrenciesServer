package com.crossover.pages.conversion

import geb.Module
import geb.Page

class ConversionEditPage extends Page {

    static url = "conversion#/create"

    static at = { $('h2').text() == 'Edit Conversion' }

    static content = {
		currencyFromField {$("select[ng-model='ctrl.conversion.currencyFrom']")}
		currencyToField {$("select[ng-model='ctrl.conversion.currencyTo']")}
        saveButton { $('button[crud-button="save"]') }
    }

}