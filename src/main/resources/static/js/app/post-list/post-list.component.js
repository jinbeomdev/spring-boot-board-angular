'use strict'

angular.
  module('postList').
  component('postList', {
    templateUrl: 'js/app/post-list/post-list.template.html',
    controller: ['$http', function postListController($http) {
      var self = this;

      $http.get('/posts').then(function(response) {
        self.posts = response.data;
      });
    }]
   });