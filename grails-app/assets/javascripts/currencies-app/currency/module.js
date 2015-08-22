//= require_self 
//= require controllers
//= require services 
//= require_tree /currencies-app/currency/templates/

'use strict';

angular.module('currenciesApp.currency', [
	'grails', 
	'currenciesApp.currency.controllers', 
	'currenciesApp.currency.services'
])
.value('defaultCrudResource', 'CurrencyResource')
.config(function($routeProvider) {
	$routeProvider
        .when('/', {
            controller: 'ListCtrl as ctrl',
            templateUrl: 'list.html',
            resolve: {
                currencyList: function($route, CurrencyResource) {
                    var params = $route.current.params;
                    return CurrencyResource.list(params);
                } 
            }
        })
        .when('/create', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                currency: function(CurrencyResource) {
                    return CurrencyResource.create();
                } 
            }
        })
        .when('/edit/:id', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                currency: function($route, CurrencyResource) {
                    var id = $route.current.params.id;
                    return CurrencyResource.get(id);
                } 
            }
        })
        .when('/show/:id', {
            controller: 'ShowCtrl as ctrl',
            templateUrl: 'show.html',
            resolve: {
                currency: function($route, CurrencyResource) {
                    var id = $route.current.params.id;
                    return CurrencyResource.get(id);
                }
            }
        })
        .otherwise({redirectTo: '/'});
});
