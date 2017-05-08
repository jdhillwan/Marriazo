angular.module('MarriazoApp').directive('registerForm',
[ '$rootScope','$timeout', function(rootScope, $timeout) {
	return {
		restrict : 'E',
		scope : {
			
			},
		controller: 'RegisterFormController',
		templateUrl : 'resources/views/register-form.tpl.html',
		compile : function(element,attrs,transclude){
			return {
				pre : function(scope, element, attrs){
					scope.ASSET_INSTANCE = attrs.key;
				}
			}
		},
	};
} ]);