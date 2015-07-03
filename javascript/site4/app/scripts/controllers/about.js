'use strict';

/**
 * @ngdoc function
 * @name site4App.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the site4App
 */
angular.module('site4App')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
