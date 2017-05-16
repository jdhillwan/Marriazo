angular
		.module('MarriazoApp')
		.controller(
				'RegisterFormController',
				[
						'$rootScope',
						'$scope',
						'$http',
						'NotificationService',
						'$location',
						'$uibModal',
						function(rootScope, scope, $http, NotificationService,
								location, uibModal) {

							scope.initializeAsset = function() {
								scope.cityList = {
									"Punjab" : [ "Mohali", "Chandigarh",
											"Panchkula" ],
									"Haryana" : [ "Gurgaon", "Rohtak" ],
									"Goa" : [ "Goa" ]
								}
								scope.stateList = Object.keys(scope.cityList);
							}
							scope.popup1 = {
								"opened" : false
							};
							scope.popup2 = {
								"opened" : false
							};
							scope.register = function() {
								$http({
									method : "POST",
									url : "../marriazo-portal/register.rest",
									data : scope.user
								})
										.then(
												function(response) {
													if (response.data.data != null) {
														NotificationService
																.success(
																		"success",
																		"Registered Successfully!! Please Login");
														scope.$parent.closeSignUpModal();
														location.path("/");

													} else {
														NotificationService
																.success(
																		"error",
																		"Error in registeration");
													}
												});
							}

							scope.closePopup = function() {
								uibModalInstance.dismiss('cancel');
							}

							scope.open1 = function() {
								scope.popup1.opened = true;
							};

							scope.open2 = function() {
								scope.popup2.opened = true;
							};

							scope.initializeAsset();

						} ]);