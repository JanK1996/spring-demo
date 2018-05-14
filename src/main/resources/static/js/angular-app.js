var ciscoApp = angular.module("ciscoApp", ['ngProgressLite', 'ui.bootstrap']);
ciscoApp.controller("commandsCtrl",
    function ($scope, $http, $interval, $window, $q, ngProgressLite) {

    $scope.c1 = null;
    $scope.c2 = null;
    $scope.sendingForm = false;
    $scope.result = null;
    $scope.addComplexForm = function () {
        $scope.sendingForm = true;
        var complexRequest = {
            left: $scope.c1,
            right: $scope.c2
        };
        $http({
            method: 'POST',
            url: '/rest/complex/add',
            data: complexRequest
        })
            .then(function success(response) {
                $scope.result = response.data;
                $scope.sendingForm = false;
            }, function error(response) {
                $scope.sendingForm = false;
            });
    }
    });
