angular.module('MarriazoApp')
		.controller(
				'FlowerDecorationController',
				[
						'$rootScope',
						'$scope',
						'$http',
						'$location',
						'NotificationService',
						function(rootScope, scope, $http, location,
								NotificationService) {
							console.log("FlowerDecorationController called");
						} ]);