'use strict'

angular
  .module('updatePost')
  .component('updatePost', {
    templateUrl: 'js/app/update-post/update-post.template.html',
    controller: ['$http', '$routeParams', '$location', function UpdatePostController($http, $routeParams, $location) {
      var self = this;
      $http.get('/post/' + $routeParams.postId).then(function (response) {
        self.post = response.data;
      });

      self.update = function update() {
        var data = JSON.stringify({
          title: self.post.title,
          content: self.post.content,
        });

        var config = {
          headers: {
            'Content-Type': 'application/json;'
          }
        };

        $http.put('post/' + $routeParams.postId, data, config).success(function () {
          $location.path('/board');
        }).error(function() {
          alert("failed with update post");
        });
      }

      self.onCancel = function onCancel() {
        $location.path('/post/' + $routeParams.postId);
      }
    }]
  });
