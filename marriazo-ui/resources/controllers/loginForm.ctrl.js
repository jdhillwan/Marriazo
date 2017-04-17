angular.module('MarriazoApp').controller(
		'LoginFormController',
		[
				'$rootScope',
				'$scope',
				'$http',
				function(rootScope, scope, $http) {

					scope.login = function() {
						console.log("login function called");
					}

					rootScope.$on('event:social-sign-in-success', function(
							event, userDetails) {
						if (userDetails != null && userDetails.uid != null) {
							$http({
								method : "POST",
								url : "../marriazo-portal/user-profile.rest",
								data : userDetails
							}).then(function(response) {
								alert("Profile Successfully Saved");

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