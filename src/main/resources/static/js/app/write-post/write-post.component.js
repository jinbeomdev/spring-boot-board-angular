'user strict'

angular.
  module('writePost').
  component('writePost', {
    templateUrl: 'js/app/write-post/write-post.template.html',
    controller: ['$http', '$location', '$rootScope', function($http, $location, $rootScope) {
      this.onWrite = function onWrite() {
        var self = this;
        var data = JSON.stringify({
          title: self.post.title,
          author: $rootScope.curUsername,
          content: self.post.content
        });

        console.log("write-post");
        console.log(data);

        var config = {
          headers: {
            'Content-Type': 'application/json;'
          }
        };

        $http.post('/writePost', data, config).success(function () {
          $location.path("/board");
        }).error(function () {
          alert("failed with write post")
        });
      };

      this.onCancel = function onCancel() {
        $location.path("/board");
      };
    }]
  });