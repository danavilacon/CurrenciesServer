//= require_self 
//= require controllers
//= require services 
//= require /currencies-app/conversion/services
//= require_tree /currencies-app/rate/templates/

'use strict';

angular.module('currenciesApp.rate', [
	'grails', 
	'currenciesApp.rate.controllers', 
	'currenciesApp.conversion.services',
	'currenciesApp.rate.services'
])
.value('defaultCrudResource', 'RateResource')
.config(function($routeProvider) {
	$routeProvider
        .when('/', {
            controller: 'ListCtrl as ctrl',
            templateUrl: 'list.html',
            resolve: {
                rateList: function($route, RateResource) {
                    var params = $route.current.params;
                    return RateResource.list(params);
                },
				conversionList: function(ConversionResource) {
					return ConversionResource.list();
				}	
 
            }
        })
        .when('/create', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                rate: function(RateResource) {
                    return RateResource.create();
                },
				conversionList: function(ConversionResource) {
					return ConversionResource.list();
				}	
 
            }
        })
        .when('/edit/:id', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                rate: function($route, RateResource) {
                    var id = $route.current.params.id;
                    return RateResource.get(id);
                },
				conversionList: function(ConversionResource) {
					return ConversionResource.list();
				}	
 
            }
        })
        .when('/show/:id', {
            controller: 'ShowCtrl as ctrl',
            templateUrl: 'show.html',
            resolve: {
                rate: function($route, RateResource) {
                    var id = $route.current.params.id;
                    return RateResource.get(id);
                }
            }
        })
        .otherwise({redirectTo: '/'});
});
