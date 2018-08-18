angular.module('car').service('carService', function ($resource, SERVER_URL) {
    var service = this;

    var carResource = $resource(SERVER_URL + '/cars/:id', {}, {
        query: {
            method: 'GET',
            isArray: false,
            url: SERVER_URL + '/cars'
        },
        update: {
            method: 'PUT'
        }
    });

    service.get = function(id) {
        return carResource.get({
            'id': id
        }).$promise;
    };

    service.search = function(params) {
        return carResource.query(params).$promise;
    };

    service.create = function(car) {
        return carResource.save({}, car).$promise;
    };

    service.update = function(car) {
        return carResource.update({
            'id': car.id
        }, car).$promise;
    };

    service.remove = function(id) {
        return carResource.remove({
            'id': id
        }).$promise;
    }
});