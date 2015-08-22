'use strict';

function CurrencyResource(CrudResourceFactory) {
    return CrudResourceFactory('/api/currency', 'Currency');
}

angular.module('currenciesApp.currency.services', ['grails'])
    .factory('CurrencyResource', CurrencyResource);
