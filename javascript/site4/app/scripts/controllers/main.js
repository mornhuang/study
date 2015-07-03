'use strict';

/**
 * @ngdoc function
 * @name site4App.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the site4App
 */
angular.module('site4App')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  })
  .controller('TestParse', function($scope, $parse) {
    $scope.$watch('expr', function(newVal, oldVal, scope) {
      if (newVal != oldVal) {
        var parseFun = $parse(newVal);
        $scope.parsedValue = parseFun(scope);
      }
    });
  })
  .controller('TestIns', function($scope, $interpolate) {
    $scope.$watch('emailBody', function(body) {
      if (body) {
        var template = $interpolate(body);
        $scope.previewText = template({to: $scope.to});
      }
    });
  });
