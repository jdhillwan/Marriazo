angular.module('MarriazoApp')
		.controller(
				'CateringController',
				[
						'$rootScope',
						'$scope',
						'$http',
						'$location',
						'NotificationService',
						function(rootScope, scope, $http, location,
								NotificationService) {
							console.log("CateringController called");
						} ]);