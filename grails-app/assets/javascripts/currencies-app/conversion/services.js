'use strict';

function ConversionResource(CrudResourceFactory) {
    return CrudResourceFactory('/api/conversion', 'Conversion');
}

angular.module('currenciesApp.conversion.services', ['grails'])
    .factory('ConversionResource', ConversionResource);
