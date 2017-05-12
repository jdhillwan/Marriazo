angular.module('MarriazoApp').controller('RegisterFormController',
		[ '$rootScope', '$scope', '$http', function(rootScope, scope, $http) {

			scope.initializeAsset = function() {
				scope.cityList = {"Punjab" : ["Mohali", "Chandigarh", "Panchkula"], "Haryana" : ["Gurgaon", "Rohtak"], "Goa" : ["Goa"]}
				scope.stateList = Object.keys(scope.cityList);
			}
			scope.popup1 = {"opened" : false};
			scope.popup2 = {"opened" : false};
			scope.register = function() {
				$http({
					method : "POST",
					url : "../marriazo-portal/register.rest",
					data : scope.user
				}).then(function(response) {
					if(response.data.data != null){
						alert("User Successfully Registered");
					}else{
						alert("User Not Registered");
					}
				});
			}
			
			scope.open1 = function() {
			    scope.popup1.opened = true;
			 };
			 
			 scope.open2 = function() {
				    scope.popup2.opened = true;
				 };
			
			scope.initializeAsset();
			
		} ]);