angular.module('MarriazoApp').controller('SearchController',
		[ '$rootScope', '$scope', '$http', '$routeParams', function(rootScope, scope, $http, $routeParams) {

			scope.initializeAsset = function() {
				scope.state = $routeParams.state;
				scope.city = $routeParams.city;
				scope.fetchVenues();
			}
			
			scope.min=100;
			scope.max =100000;
			scope.fetchVenues = function() {
				var params = {"state" : scope.state, "city" : scope.city};
				params.price_range = {"min" : scope.min, "max" : scope.max};
				$http({
					method : "POST",
					url : "../marriazo-portal/venue/fetch-all.rest",
					data : params
				}).then(function(response) {
					scope.venues = response.data.data;
					$('#price_range').slider({});
					//console.log(JSON.stringify(scope.venues));
				});
			}
			
			scope.changePriceRange = function() {
				scope.fetchVenues();
			}
			
			scope.initializeAsset();
			
		} ]);