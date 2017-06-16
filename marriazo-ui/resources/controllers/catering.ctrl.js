angular.module('MarriazoApp')
		.controller('CateringController',['$rootScope','$scope','$http','$location','NotificationService','$routeParams',
			function(rootScope, scope, $http, location,NotificationService,routeParams) {
				console.log("CateringController called");
				
				scope.min=100;
				scope.max =100000;
				scope.popup1 = {"opened" : false};
				scope.popup2 = {"opened" : false};
				scope.timeSlots = ["12:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00"];
				scope.params = {"state" : scope.state, "city" : scope.city};
				
				
				scope.init = function(){
					scope.state = routeParams.state;
					scope.city = routeParams.city;
					scope.fetchCaters();
				}
				
				scope.changePriceRange = function() {
					scope.fetchCaters();
				}
				
				scope.fetchCaters = function() {
					scope.params.price_range = {"min" : scope.min, "max" : scope.max};
					$http({
						method : "POST",
						url : "../marriazo-portal/catering/fetch-all.rest",
						data : scope.params
					}).then(function(response) {
						scope.catersList = response.data.data;
						$('#price_range').slider({});
						console.log(JSON.stringify(scope.catersList));
					});
				}
				scope.uiFilter = function(cater) {
					var retVal = false;
					if(!cater.capacity && (!scope.ratingFilters || scope.ratingFilters.length == 0 || scope.ratingFilters.indexOf(cater.rating) >= 0)){
						retVal = true;
					}
					return retVal;
				}
				
				scope.init();
							
							
} ]);