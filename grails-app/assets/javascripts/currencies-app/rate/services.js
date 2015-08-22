'use strict';

function RateResource(CrudResourceFactory) {
    return CrudResourceFactory('/api/rate', 'Rate');
}

angular.module('currenciesApp.rate.services', ['grails'])
    .factory('RateResource', RateResource);
