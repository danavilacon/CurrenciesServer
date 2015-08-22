'use strict';

function ListCtrl($scope, CurrencyResource, currencyList, pageSize) {
    var self = this;
    self.currencyList = currencyList;
	
    self.pageSize = pageSize;
    self.page = 1;
    self.filter = {};

    $scope.$watchCollection(function() { return self.filter }, function() {
        self.reload();
    });

    self.load = function() {
        var params = {page: self.page};

        if (self.sort) {
            angular.extend(params, self.sort);
        }
		if (self.filter) {
			params.filter = self.filter
		}

        CurrencyResource.list(params).then(function(items) {
            self.currencyList = items;
        });
    };

    self.reload = function() {
        self.page = 1;
        self.load();
    }
}

function ShowCtrl(currency) {
    var self = this;
    self.currency = currency;
};

function CreateEditCtrl(currency ) {
    var self = this;
	
    self.currency = currency;
}

angular.module('currenciesApp.currency.controllers', [])
    .controller('ListCtrl', ListCtrl)
    .controller('ShowCtrl', ShowCtrl)
    .controller('CreateEditCtrl', CreateEditCtrl);