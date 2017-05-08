angular.module('MarriazoApp').controller(
        'GetTogetherController',
        ['$rootScope', '$scope', '$http', '$location', 'NotificationService',
            function(rootScope, scope, $http, location, NotificationService) {
              console.log("GetTogetherController called");
            }]);