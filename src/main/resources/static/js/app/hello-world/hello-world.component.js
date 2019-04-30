'use strict'

angular.
    module('helloWorld').
    component('helloWorld', {
        templateUrl: 'js/app/hello-world/hello-world.template.html',
        controller: function helloWorldController() {
            this.helloWorldStr = 'hello world!';
        }
    });