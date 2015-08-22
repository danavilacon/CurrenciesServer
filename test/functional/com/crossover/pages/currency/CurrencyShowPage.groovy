package com.crossover.pages.currency

import geb.Page

class CurrencyShowPage extends Page {

    static at = { $('h2').text().startsWith 'Show Currency' }

    static content = {
        successMessage { $(".alert-success") }
    }

}