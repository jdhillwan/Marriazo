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
			scope.timeSlots = ["12:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00"];
			scope.params = {"state" : scope.state, "city" : scope.city};
			
			scope.fetchVenues = function() {
				scope.params.price_range = {"min" : scope.min, "max" : scope.max};
				$http({
					method : "POST",
					url : "../marriazo-portal/venue/fetch-all.rest",
					data : scope.params
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
			
			scope.addDateFilter = function() {
				delete scope.params.date_range;
				if(scope.startDate && scope.endDate && scope.startTime && scope.endTime){
					scope.startDate.setHours(scope.startTime);
					scope.endDate.setHours(scope.endTime);
					var start = scope.startDate.getTime();
					var end = scope.endDate.getTime();
					scope.params.date_range = {"date_from" : start, "date_to" : end};
					scope.fetchVenues();
				}
			}
			
			scope.ratingChanged = function() {
				scope.ratingFilters = [];
				var ratings = $("input[name=rating]:checked").map(
					     function () {return this.value;}).get().join(",");
				if(ratings != ""){
					scope.ratingFilters = ratings.split(",");
				}
			}
			
			scope.uiFilter = function(venue) {
				var retVal = false;
				if((!scope.capacity || (scope.capacity >= venue.capacity.banquet.min && scope.capacity <= venue.capacity.banquet.max)) && (!scope.ratingFilters || scope.ratingFilters.length == 0 || scope.ratingFilters.indexOf(venue.rating) >= 0)){
					retVal = true;
				}
				return retVal;
			}
			
			scope.initializeAsset();
			
		} ]);