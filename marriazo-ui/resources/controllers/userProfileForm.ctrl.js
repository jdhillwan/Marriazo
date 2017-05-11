angular.module('MarriazoApp').controller(
		'UserProfileFormController',
		[
				'$scope',
				'$http',
				'$location',
				'NotificationService',
				'$cookieStore',
				function(scope, $http, location, NotificationService,
						$cookieStore) {

					var username = $cookieStore.get("userDetail");
					var init = function() {
						console.log("ctrl called");
						fetchUserByUserName();
					};

					init();

					function fetchUserByUserName() {
						$http(
								{
									method : "POST",
									url : "../marriazo-portal/user/" + username
											+ "/fetch.rest",
									params : {

									}
								}).then(
								function(response) {
									console.log(response);
									if (response != null
											&& response.data != null
											&& response.data.data != null) {
										scope.userDetails = response.data.data[0];

									}

								});

					}
				} ]);