angular.module('MarriazoApp').controller('UserProfileFormController',['$scope','$http','$location','NotificationService','$cookieStore','$rootScope',
	function(scope, $http, location, NotificationService,$cookieStore, $rootScope) {
	var username = $cookieStore.get("userDetail");

	function fetchUserDetails() {
		$http({
				method : "POST",
				url : "../marriazo-portal/user/fetch.rest"
			}).then(function(response) {
				if (response != null && response.data != null && response.data.data != null) {
					scope.userDetails = response.data.data;
				}
				});
	}
	
	scope.logOut = function() { 
		$http({
			method : "POST",
			url : "../marriazo-portal/logout.rest",
			params : {}
			}).then(function(response) {
				if (response != null && response.data != null && response.data.response != null) {
					$cookieStore.remove("userDetail");
					NotificationService.success("Success","Successfully logged out");
					$rootScope.sessionLogged = false;
					location.path('/');
				}
				});
	}

	scope.updateUser = function() {
		$http({
				method : "PUT",
				url : "../marriazo-portal/user/update.rest",
				data : scope.userDetails
			}).then(function(response) {
				if (response != null && response.data != null && response.data.response != null) {
					fetchUserDetails();
					NotificationService.success("Success","Profile Updated Successfully");
				}
		});
	}
	
	fetchUserDetails();
} ]);