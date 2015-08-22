package com.crossover.pages.conversion

import geb.Page

class ConversionShowPage extends Page {

    static at = { $('h2').text().startsWith 'Show Conversion' }

    static content = {
        successMessage { $(".alert-success") }
    }

}