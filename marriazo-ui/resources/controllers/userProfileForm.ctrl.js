angular.module('MarriazoApp').controller('UserProfileFormController',['$scope','$http','$location','NotificationService','$cookieStore','$rootScope',
	function(scope, $http, location, NotificationService,$cookieStore, $rootScope) {
	var username = $cookieStore.get("userDetail");
	var init = function() {
		console.log("ctrl called");
		fetchUserByUserName();
	};

	init();

	function fetchUserByUserName() {
		$http({
				method : "POST",
				url : "../marriazo-portal/user/" + username + "/fetch.rest",
				params : {}
			}).then(function(response) {
				console.log(response);
				if (response != null && response.data != null && response.data.data != null) {
					scope.userDetails = response.data.data[0];
					scope.firstName = scope.userDetails.name
							.split(" ")[0];
					scope.lastName = scope.userDetails.name
							.split(" ")[1];
				}
				});
	}
	
	scope.logOut = function() { 
		$http({
			method : "POST",
			url : "../marriazo-portal/logout.rest",
			params : {}
			}).then(function(response) {
				console.log(response);
				if (response != null && response.data != null && response.data.response != null) {
					$cookieStore.remove("userDetail");
					NotificationService.success("Success","Successfully logged out");
					$rootScope.sessionLogged = false;
					location.path('/');
				}
				});
	}

	scope.updateUser = function() {
		scope.userDetails.name = scope.firstName + " " + scope.lastName;
		$http({
				method : "PUT",
				url : "../marriazo-portal/user/update.rest",
				data : scope.userDetails
			}).then(function(response) {
				if (response != null && response.data != null && response.data.response != null) {
					scope.userDetails = "";
					fetchUserByUserName();
					NotificationService.success("Success","Profile Updated Successfully");
				}
		});
	}
} ]);