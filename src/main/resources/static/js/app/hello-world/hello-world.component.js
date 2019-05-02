'use strict'

angular.
    module('helloWorld').
    component('helloWorld', {
        templateUrl: 'js/app/hello-world/hello-world.template.html',
        controller: ['$http', function helloWorldController($http) {
            var self = this;
            self.helloWorldStr = 'hello world!';
        }]
    });