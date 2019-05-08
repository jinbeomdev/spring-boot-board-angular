'use strict'

angular.
  module('postDetail').
  component('postDetail', {
   templateUrl: 'js/app/post-detail/post-detail.template.html',
   controller: ['$rootScope', '$http', '$routeParams', '$location',
    function postDetailController($rootScope, $http, $routeParams, $location) {
       var self = this;

       $http.get('post/' + $routeParams.postId).then(function(response) {
         self.post = response.data;
         self.isWriter = (angular.equals($rootScope.curUsername, self.post.author));
       });

       self.onUpdate = function onUpdate() {
        $location.path('post/' + $routeParams.postId +'/update');
       };
     }]
  });