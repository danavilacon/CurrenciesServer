package com.crossover.pages.rate

import geb.Module
import geb.Page

class RateEditPage extends Page {

    static url = "rate#/create"

    static at = { $('h2').text() == 'Edit Rate' }

    static content = {
		conversionField {$("select[ng-model='ctrl.rate.conversion']")}
		dateField {$("input[ng-model='ctrl.rate.date']")}
		valueField {$("input[ng-model='ctrl.rate.value']")}
        saveButton { $('button[crud-button="save"]') }
    }

}