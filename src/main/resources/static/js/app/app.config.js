angular.
  module('boardApp').
    config(['$routeProvider', '$httpProvider',
      function config($routeProvider, $httpProvider) {
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
          .when('/login', {
            template: '<login></login>'
          })
          .when('/writePost', {
            template: '<write-post></write-post>'
          })
          .when('/post/:postId/update', {
            template: '<update-post></update-post>'
          })
          .otherwise('/');
      }
    ]).
    run(['$rootScope', function run($rootScope) {
      $rootScope.db = {};
      $rootScope.db.username = "admin";
      $rootScope.db.password = "1111";
    }]);