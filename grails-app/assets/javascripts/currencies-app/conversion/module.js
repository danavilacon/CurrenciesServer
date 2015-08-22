//= require_self 
//= require controllers
//= require services 
//= require /currencies-app/currency/services

//= require /currencies-app/currency/services
//= require_tree /currencies-app/conversion/templates/

'use strict';

angular.module('currenciesApp.conversion', [
	'grails', 
	'currenciesApp.conversion.controllers', 
	'currenciesApp.currency.services',
	'currenciesApp.currency.services',
	'currenciesApp.conversion.services'
])
.value('defaultCrudResource', 'ConversionResource')
.config(function($routeProvider) {
	$routeProvider
        .when('/', {
            controller: 'ListCtrl as ctrl',
            templateUrl: 'list.html',
            resolve: {
                conversionList: function($route, ConversionResource) {
                    var params = $route.current.params;
                    return ConversionResource.list(params);
                },
				currencyList: function(CurrencyResource) {
					return CurrencyResource.list();
				}	
, 
				currencyList: function(CurrencyResource) {
					return CurrencyResource.list();
				}	
 
            }
        })
        .when('/create', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                conversion: function(ConversionResource) {
                    return ConversionResource.create();
                },
				currencyList: function(CurrencyResource) {
					return CurrencyResource.list();
				}	
, 
				currencyList: function(CurrencyResource) {
					return CurrencyResource.list();
				}	
 
            }
        })
        .when('/edit/:id', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                conversion: function($route, ConversionResource) {
                    var id = $route.current.params.id;
                    return ConversionResource.get(id);
                },
				currencyList: function(CurrencyResource) {
					return CurrencyResource.list();
				}	
, 
				currencyList: function(CurrencyResource) {
					return CurrencyResource.list();
				}	
 
            }
        })
        .when('/show/:id', {
            controller: 'ShowCtrl as ctrl',
            templateUrl: 'show.html',
            resolve: {
                conversion: function($route, ConversionResource) {
                    var id = $route.current.params.id;
                    return ConversionResource.get(id);
                }
            }
        })
        .otherwise({redirectTo: '/'});
});
