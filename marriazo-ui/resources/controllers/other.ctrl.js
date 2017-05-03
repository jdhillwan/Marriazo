angular.module('MarriazoApp').controller(
        'OtherController',
        ['$rootScope', '$scope', '$http', '$location', 'NotificationService',
            function(rootScope, scope, $http, location, NotificationService) {
              console.log("OtherController called");
            }]);