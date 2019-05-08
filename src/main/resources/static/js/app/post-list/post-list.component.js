'use strict'

angular.
  module('postList').
  component('postList', {
    templateUrl: 'js/app/post-list/post-list.template.html',
    controller: ['$http', '$location', function postListController($http, $location) {
      var self = this;

      $http.get('/posts').then(function(response) {
        self.posts = response.data;
      });

      self.onWrite = function onWrite() {
        $location.path('/writePost');
      };
    }]
   });