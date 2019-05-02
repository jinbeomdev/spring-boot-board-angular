angular.
  module('boardApp').
    config(['$routeProvider',
      function config($routeProvider) {
        $routeProvider.
          when('/', {
            template: '<hello-world></hello-world>'
          }).
          when('/board', {
            template: '<post-list></post-list>'
          })
          .when('/post/:postId', {
            template: '<post-detail></post-detail>'
          })
          .otherwise('/');
      }
    ]);