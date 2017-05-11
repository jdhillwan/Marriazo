angular.module('MarriazoApp').controller(
		'AppController',
		[ '$rootScope', '$scope', '$http', '$uibModal',
				function(rootScope, scope, $http, uibModal) {

					scope.buttonText = "Log In";
					scope.initializeAsset = function() {
						if (rootScope.sessionLoggedin) {
							scope.buttonText = "Log In";
						}
					}

					scope.loadLoginForm = function() {
						scope.modalInstance = uibModal.open({
							animation : true,
							template : "<login-form></login-form>",
							size : 'lg',
							scope : scope
						});
						scope.modalInstance.result.then(function() {
						}, function() {
						});
					}

					scope.closeModal = function() {
						scope.modalInstance.close();
					}

					scope.initializeAsset();

				} ]);