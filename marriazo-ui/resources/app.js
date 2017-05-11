var app = angular.module('MarriazoApp', [ 'socialLogin', 'ui.bootstrap',
		'ngRoute', 'toastr', 'ui-notification', 'ui-rangeSlider',
		'oc.lazyLoad', 'ngCookies' ]);

app.run(run);

run.$inject = [ '$rootScope', '$location', '$cookieStore' ];
function run($rootScope, $location, $cookieStore) {
	$rootScope.sessionLogged = false;
	var userDetail = $cookieStore.get("userDetail");
	console.log(userDetail);
	if (userDetail != undefined && userDetail != null) {
		$rootScope.sessionLogged = true;
	}
}
