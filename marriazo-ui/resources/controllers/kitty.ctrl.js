angular.module('MarriazoApp').controller(
        'KittyController',
        ['$rootScope', '$scope', '$http', '$location', 'NotificationService',
            function(rootScope, scope, $http, location, NotificationService) {
              console.log("KittyController called");
            }]);