'use strict';

function ListCtrl($scope, ConversionResource, conversionList, currencyFromList, currencyToList, pageSize) {
    var self = this;
    self.conversionList = conversionList;
	self.currencyFromList = currencyFromList;
self.currencyToList = currencyToList;
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

        ConversionResource.list(params).then(function(items) {
            self.conversionList = items;
        });
    };

    self.reload = function() {
        self.page = 1;
        self.load();
    }
}

function ShowCtrl(conversion) {
    var self = this;
    self.conversion = conversion;
};

function CreateEditCtrl(conversion, currencyFromList, currencyToList ) {
    var self = this;
	self.currencyFromList = currencyFromList;
self.currencyToList = currencyToList;
    self.conversion = conversion;
}

angular.module('currenciesApp.conversion.controllers', [])
    .controller('ListCtrl', ListCtrl)
    .controller('ShowCtrl', ShowCtrl)
    .controller('CreateEditCtrl', CreateEditCtrl);