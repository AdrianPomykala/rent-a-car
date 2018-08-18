var productListModule = angular.module("car-list");

productListModule.config(function($routeProvider) {
    $routeProvider.when('/cars', {
        templateUrl: 'car-list/car-list.html',
        controller: 'CarListController',
        controllerAs: 'vm'
    })
});