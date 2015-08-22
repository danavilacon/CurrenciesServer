package com.crossover.pages.rate

import geb.Page

class RateShowPage extends Page {

    static at = { $('h2').text().startsWith 'Show Rate' }

    static content = {
        successMessage { $(".alert-success") }
    }

}