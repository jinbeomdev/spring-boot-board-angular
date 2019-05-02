'use strict'

angular.
  module('postDetail').
  component('postDetail', {
   templateUrl: 'js/app/post-detail/post-detail.template.html',
   controller: ['$http', '$routeParams', function postDetailController($http, $routeParams) {
       var self = this;

       $http.get('post/' + $routeParams.postId).then(function(response) {
         self.post = response.data;
       });
     }]
  });