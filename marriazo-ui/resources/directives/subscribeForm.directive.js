angular.module('MarriazoApp').directive('subscribeForm',
[ '$rootScope','$timeout', function(rootScope, $timeout) {
	return {
		restrict : 'E',
		scope : {
			
			},
		controller: 'SubscribeFormController',
		templateUrl : 'resources/views/subscribe-form.tpl.html',
		compile : function(element,attrs,transclude){
			return {
				pre : function(scope, element, attrs){
					scope.ASSET_INSTANCE = attrs.key;
				}
			}
		},
	};
} ]);