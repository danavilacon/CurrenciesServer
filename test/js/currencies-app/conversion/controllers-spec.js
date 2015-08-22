describe('Conversion Controllers: ', function() {

    var item = {'foo': 'bar', 'count': 100};

    beforeEach(module('currenciesApp.conversion.controllers'));

    describe('ShowCtrl: ', function() {
        var ctrl, scope;

        beforeEach(module(function($provide) {
            $provide.value('conversion', item);
        }));

        beforeEach(inject(
            function ($controller, $rootScope) {
                scope = $rootScope.$new();
                ctrl = $controller('ShowCtrl', { $scope: scope });
            }
        ));

        it('should have the conversion on the scope', function() {
            expect(ctrl.conversion).toEqual(item);
        });
    });

    describe('CreateEditCtrl: ', function() {
        var ctrl, scope;

        beforeEach(module(function($provide) {
            $provide.value('conversion', item);
			$provide.value('currencyFromList', []);
			$provide.value('currencyToList', []);
        }));

        beforeEach(inject(
            function ($controller, $rootScope) {
                scope = $rootScope.$new();
                ctrl = $controller('CreateEditCtrl', { $scope: scope });
            }
        ));

        it('should have the conversion on the scope', function() {
            expect(ctrl.conversion).toEqual(item);
        });
    });

    describe('ListCtrl: ', function() {
        var ctrl, scope, deferred;

        var items = [
            {id: 1, name: 'Item1'},
            {id: 2, name: 'Item2'}
        ];

        var items2 = [
            {id: 3, name: 'Item3'},
            {id: 4, name: 'Item4'}
        ];

        var PAGE_SIZE = 25;

        beforeEach(module(function($provide) {

            var mockCrudService = {
                list: function() {
                    deferred.resolve(items2);
                    return deferred.promise;
                }
            };

            $provide.value('ConversionResource', mockCrudService);
            $provide.value('conversionList', items);
			$provide.value('currencyFromList', []);
			$provide.value('currencyToList', []);
            $provide.value('pageSize', PAGE_SIZE);
        }));

        beforeEach(inject(
            function ($controller, $rootScope, $q) {
                deferred = $q.defer();
                scope = $rootScope.$new();
                ctrl = $controller('ListCtrl', { $scope: scope });
            }
        ));

        it('should have the conversionList and default values set on the scope', function() {
            expect(ctrl.pageSize).toEqual(PAGE_SIZE);
            expect(ctrl.conversionList).toEqual(items);
            expect(ctrl.page).toEqual(1);
        });

        it('reload should reset page', function() {
            ctrl.page = 2;
            ctrl.reload();
            scope.$digest();

            expect(ctrl.page).toEqual(1);
            expect(ctrl.conversionList).toEqual(items2);
        });

    });


});