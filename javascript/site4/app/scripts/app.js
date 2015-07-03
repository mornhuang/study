'use strict';

/**
 * @ngdoc overview
 * @name site4App
 * @description
 * # site4App
 *
 * Main module of the application.
 */
angular
  .module('site4App', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/parse', {
        templateUrl: 'views/hello.html',
        controller: 'TestParse'
      })
      .when('/ins', {
        templateUrl: 'views/hello.html',
        controller: 'TestIns'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
