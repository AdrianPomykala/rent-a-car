var carListModule = angular.module('car-list');

carListModule.controller('CarListController', function (carService, $location) {
    var vm = this;

    vm.params = {};

    vm.search = search;

    vm.remove = remove;

    vm.edit = edit;

    search();

    function search() {
        carService.search(vm.params)
            .then(function (response) {
                vm.cars = response.content;
            })
            .catch(function (response) {
                alert(response.data.message);
                vm.error = response.data.message;
            });
    }

    function remove(carId) {
        carService.remove(carId)
            .then(function () {
                search();
            })
    }

    function edit(id) {
        $location.path('/cars/edit/' + id);
    }
});