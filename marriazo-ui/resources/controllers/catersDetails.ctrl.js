angular.module('MarriazoApp').controller(
        'CatersDetailsController',
        [
            '$rootScope',
            '$scope',
            '$http',
            '$location',
            'NotificationService',
            '$routeParams',
            '$sce',
            function(rootScope, scope, $http, location, NotificationService,
                    $routeParams,$sce) {

              scope.initializeAsset = function() {
                var catersId = $routeParams.catersId;
                scope.fetchCatersById(catersId);
              }
              scope.fetchCatersById = function(catersId) {
                $http(
                        {
                          method: "POST",
                          url: "../marriazo-portal/catering/" + catersId
                                  + "/fetch-one.rest"
                        }).then(
                        function(response) {
                          if (response != null && response.data != null
                                  && response.data.data != null) {
                            scope.caters = response.data.data;
                            console.log(scope.caters);
                            scope.mapFrame = $sce.trustAsResourceUrl(scope.caters.googleMap);
                          }
                        });

              }

              scope.initializeAsset();

            }]);