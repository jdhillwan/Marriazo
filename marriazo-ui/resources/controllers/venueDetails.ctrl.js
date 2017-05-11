angular.module('MarriazoApp').controller(
        'VenueDetailsController',
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
                var venueID = $routeParams.venueId;
                scope.fetchVenueById(venueID);
              }
              scope.fetchVenueById = function(venueID) {
                $http(
                        {
                          method: "POST",
                          url: "../marriazo-portal/venue/" + venueID
                                  + "/fetch-one.rest"
                        }).then(
                        function(response) {
                          if (response != null && response.data != null
                                  && response.data.data != null) {
                            scope.venue = response.data.data;
                            scope.mapFrame = $sce.trustAsResourceUrl(scope.venue.googleMap);
                          }
                        });

              }

              scope.initializeAsset();

            }]);