angular.module('MarriazoApp').controller('LoginFormController',['$rootScope','$scope','$http','$location','NotificationService','$uibModal','$cookieStore',
    function(rootScope, scope, $http, location,NotificationService, uibModal, $cookieStore) {
	scope.loginMethod = {"loginBy" : "email"};

	(function init() {
		var userDetails = $cookieStore.get("username");
	});

	rootScope.$on('event:social-sign-in-success',function(event, userDetails) {
		if (userDetails != null && userDetails.uid != null) {
			$http({
				method : "POST",
				url : "../marriazo-portal/user-profile.rest",
				data : userDetails
				}).then(function(response) {
					NotificationService.success("Success","Successfully logged in");
					scope.$parent.closeModal();
					location.path('/');// temporary
					// code
					// need
					// to
					// set
					// it in
					// fb
					// account
					});
				}
		});

	rootScope.$on('event:social-sign-out-success',function(event, message) {
												if (message != null
														&& message == "success") {
													alert("Profile Successfully Saved");
												}
											});

							scope.loadSignUpForm = function() {
								scope.SignUpModal = uibModal
										.open({
											animation : true,
											template : "<register-form></register-form>",
											size : 'lg',
											scope : scope
										});
								scope.SignUpModal.result.then(function() {
								}, function() {
								});
							}

							scope.closeSignUpModal = function() {
								scope.SignUpModal.close();
							}

							scope.login = function(user, method) {
								if (user != null && user.username != null
										&& user.password != null) {

									$http({
										method : "POST",
										url : "../marriazo-portal/login.rest",
										params : {
											'username' : user.username,
											'password' : user.password
										}
									}).then(function(response) {
										//console.log(response);
										if (response != null && response.data != null && response.data.data != null) {
											if (response.data.response != null && response.data.response == "UserArleadyLoggedIn") {
												$cookieStore.put("userDetail",response.data.data.username);
												rootScope.sessionLogged = true;
												NotificationService.warning("Warning","User Already logged in");
											} else {
												if(response.data.data && response.data.data.user){
													$cookieStore.put("userDetail",response.data.data.user.email);
													rootScope.sessionLogged = true;
													NotificationService.success("Success","Successfully logged in");
												}else{
													NotificationService.error("Error",response.data.data.message);
												}
											}
										}
										scope.$parent.closeModal();
										location.path('/');// temporary
										// code need to
										// set it in fb account
										});
								}
							}
						} ]);