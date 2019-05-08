'use strict'

angular.
  module('login').
  component('login', {
    templateUrl: 'js/app/login/login.template.html',
    controller: ['$location', '$rootScope',
      function loginController($location, $rootScope) {
      var self = this;
      self.credentials = {};
      self.login = function() {
        if(angular.equals(self.credentials.username, $rootScope.db.username) &&
          angular.equals(self.credentials.password, $rootScope.db.password)) {

          $rootScope.authenticated = true;
          $rootScope.curUsername = self.credentials.username;

          self.error = false;
          $location.path("/");
         } else {
          $rootScope.authenticated = false;
          self.error = true;
          $location.path("/login");
         }
        }
      }]
    });