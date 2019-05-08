'use strict'

angular.
  module('navigation').
  component('navigation', {
    templateUrl: 'js/app/navigation/navigation.template.html',
    controller: ['$rootScope', '$location', function navigationController($rootScope, $location) {
      this.onClick = function onClick($event) {
        $event.preventDefault();

        var href = $event.target.href;
        href = href.substring(href.indexOf("#/") + 1);

        var isLogin = angular.equals(href, "/login") || angular.equals(href, "/");

        if(!isLogin && !$rootScope.authenticated) {
          $location.path("/login");
        } else {
          $location.path(href);
        }
      };

      this.logout = function logout() {
        $rootScope.authenticated = false;
        location.path('/');
      }
    }]
  });
