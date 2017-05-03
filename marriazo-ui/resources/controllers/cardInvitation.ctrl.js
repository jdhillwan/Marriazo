angular.module('MarriazoApp')
		.controller(
				'CardInvitationController',
				[
						'$rootScope',
						'$scope',
						'$http',
						'$location',
						'NotificationService',
						function(rootScope, scope, $http, location,
								NotificationService) {
							console.log("CardInvitationController called");
						} ]);