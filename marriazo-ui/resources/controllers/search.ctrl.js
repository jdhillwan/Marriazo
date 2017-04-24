angular.module('MarriazoApp').controller('SearchController',
		[ '$rootScope', '$scope', '$http', '$routeParams', function(rootScope, scope, $http, $routeParams) {

			scope.initializeAsset = function() {
				scope.state = $routeParams.state;
				scope.city = $routeParams.city;
				scope.fetchVenues();
			}
			
			scope.fetchVenues = function() {
				$http({
					method : "POST",
					url : "../marriazo-portal/venue/fetch-all.rest",
					data : {"state" : scope.state, "city" : scope.city}
				}).then(function(response) {
					scope.venues = response.data.data;
					//console.log(JSON.stringify(scope.venues));
				});
			}
			
			scope.initializeAsset();
			
		} ]);