angular.module('MarriazoApp').controller(
		'LoginFormController',
		[
				'$rootScope',
				'$scope',
				'$http',
				'$location',
				'NotificationService',
				function(rootScope, scope, $http, location,NotificationService) {

					rootScope.$on('event:social-sign-in-success', function(
							event, userDetails) {
						if (userDetails != null && userDetails.uid != null) {
							$http({
								method : "POST",
								url : "../marriazo-portal/user-profile.rest",
								data : userDetails
							}).then(function(response) {
								NotificationService.success("success","successfully logged in");
								scope.$parent.closeModal();
								location.path('/');// temporary code need to
													// set it in fb account
							});
						}
					});

					rootScope.$on('event:social-sign-out-success', function(
							event, message) {
						if (message != null && message == "success") {
							alert("Profile Successfully Saved");
						}
					});

				} ]);