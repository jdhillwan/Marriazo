angular.module('MarriazoApp')
		.controller(
				'PhotoGrapherController',
				[
						'$rootScope',
						'$scope',
						'$http',
						'$location',
						'NotificationService',
						function(rootScope, scope, $http, location,
								NotificationService) {
							console.log("PhotoGrapherController called");
						} ]);