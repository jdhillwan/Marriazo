angular.module('MarriazoApp').controller('SearchController',
		[ '$rootScope', '$scope', '$http', '$routeParams', function(rootScope, scope, $http, $routeParams) {

			scope.initializeAsset = function() {
				scope.state = $routeParams.state;
				scope.city = $routeParams.city;
				scope.fetchVenues();
			}
			
			scope.min=100;
			scope.max =100000;
			scope.popup1 = {"opened" : false};
			scope.popup2 = {"opened" : false};
			
			scope.fetchVenues = function() {
				var startDate = new Date(2017, 4, 17, 13, 0, 0, 0).getTime();
				var endDate = new Date(2017, 4, 17, 18, 0, 0, 0).getTime();
				var params = {"state" : scope.state, "city" : scope.city, "date_range" : {"date_from" : startDate, "date_to" : endDate}};
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
			
			scope.open1 = function() {
			    scope.popup1.opened = true;
			 };
			  
			 scope.open2 = function() {
				 scope.popup2.opened = true;
			 };
			
			scope.changePriceRange = function() {
				scope.fetchVenues();
			}
			
			scope.initializeAsset();
			
		} ]);