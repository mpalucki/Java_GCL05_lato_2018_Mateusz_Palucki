var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl : "gallery.html",
            controller : "galleryCtrl"

        })
        .when("/panel", {
            templateUrl : "panel.html",
            controller : "galleryCtrl"
        });
});
app.controller('mainCtrl', function($scope) {
});
