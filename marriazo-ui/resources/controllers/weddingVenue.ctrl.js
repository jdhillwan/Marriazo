angular.module('MarriazoApp')
		.controller(
				'WeddingVenueController',
				[
						'$rootScope',
						'$scope',
						'$http',
						'$location',
						'NotificationService',
						function(rootScope, scope, $http, location,
								NotificationService) {
							console.log("WeddingVenueController called");
						} ]);