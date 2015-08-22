'use strict';

function ListCtrl($scope, RateResource, rateList, conversionList, pageSize) {
    var self = this;
    self.rateList = rateList;
	self.conversionList = conversionList;
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

        RateResource.list(params).then(function(items) {
            self.rateList = items;
        });
    };

    self.reload = function() {
        self.page = 1;
        self.load();
    }
}

function ShowCtrl(rate) {
    var self = this;
    self.rate = rate;
};

function CreateEditCtrl(rate, conversionList ) {
    var self = this;
	self.conversionList = conversionList;
    self.rate = rate;
}

angular.module('currenciesApp.rate.controllers', [])
    .controller('ListCtrl', ListCtrl)
    .controller('ShowCtrl', ShowCtrl)
    .controller('CreateEditCtrl', CreateEditCtrl);