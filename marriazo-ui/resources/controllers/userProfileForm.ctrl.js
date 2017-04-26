angular.module('MarriazoApp').controller(
		'UserProfileFormController',
		[ '$scope', '$http', '$location', 'NotificationService',
				function(scope, $http, location, NotificationService) {

					function init(){
						console.log("ctrl called");
					}
			
				} ]);