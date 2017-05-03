angular.module('MarriazoApp').controller(
        'WeddingAnniversaryController',
        ['$rootScope', '$scope', '$http', '$location', 'NotificationService',
            function(rootScope, scope, $http, location, NotificationService) {
              console.log("WeddingAnniversaryController called");
            }]);