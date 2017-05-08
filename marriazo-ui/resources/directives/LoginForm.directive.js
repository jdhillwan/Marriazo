angular.module('MarriazoApp').directive('loginForm',
		[ '$rootScope', '$timeout', function(rootScope, $timeout) {
			return {
				restrict : 'E',
				scope : {

				},
				controller : 'LoginFormController',
				templateUrl : 'resources/views/login-form.tpl.html',
				compile : function(element, attrs, transclude) {
					return {
						pre : function(scope, element, attrs) {
							scope.ASSET_INSTANCE = attrs.key;
						}
					}
				},
			};
		} ]);