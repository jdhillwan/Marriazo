angular.module('MarriazoApp')
		.controller(
				'BirthdayPartyController',
				[
						'$rootScope',
						'$scope',
						'$http',
						'$location',
						'NotificationService',
						function(rootScope, scope, $http, location,
								NotificationService) {
							console.log("BirthdayPartyController called");
						} ]);