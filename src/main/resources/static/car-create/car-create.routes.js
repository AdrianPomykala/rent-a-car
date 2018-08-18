carCreateModule = angular.module('car-create')
    .config(function ($routeProvider) {
        $routeProvider.when('/cars/add', {
            templateUrl: '/car-create/car-create.html',
            controller: 'CarCreateController',
            controllerAs: 'vm'
        });
    });