angular.module('car-create')
    .controller('CarCreateController', function (carService, $location) {
        var vm = this;

        vm.car = {};

        vm.create = create;

        function create() {
            carService.create(vm.car)
                .then(function () {
                    $location.path('/products')
                })
                .catch(function (response) {
                    vm.errors = response.data;
                })
        }
    });