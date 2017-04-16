angular.module('MarriazoApp').controller('AppController',
		[ '$rootScope', '$scope', '$http', '$uibModal', function(rootScope, scope, $http, uibModal) {

			scope.initializeAsset = function() {
				
			}
			
			scope.loadSignUpForm = function() {
				scope.modalInstance = uibModal.open({
					animation : true,
					template : "<register-form></register-form>",
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