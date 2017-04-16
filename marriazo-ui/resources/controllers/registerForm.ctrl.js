angular.module('MarriazoApp').controller('RegisterFormController',
		[ '$rootScope', '$scope', '$http', function(rootScope, scope, $http) {

			scope.initializeAsset = function() {
				scope.cityList = {"Punjab" : ["Mohali", "Chandigarh", "Panchkula"], "Haryana" : ["Gurgaon", "Rohtak"], "Goa" : ["Goa"]}
				scope.stateList = Object.keys(scope.cityList);
			}
			
			scope.register = function() {
				$http({
					method : "POST",
					url : "../marriazo-portal/register.rest",
					data : scope.user
				}).then(function(response) {
					alert("User Successfully Registered");
				});
			}
			
			scope.initializeAsset();
			
		} ]);