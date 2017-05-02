var app = angular.module('MarriazoApp', [ 'socialLogin','ui.bootstrap', 'ngRoute','toastr','ui-notification', 'ui-rangeSlider']);

/*app
		.config(function(socialProvider, $routeProvider) {
			socialProvider
					.setGoogleKey("373292484064-qta6ts2ii99p53tam1giil7f1d4mqngk.apps.googleusercontent.com");
			 socialProvider.setLinkedInKey("YOUR LINKEDIN CLIENT ID"); 
			socialProvider.setFbKey({
				appId : "654355474752575",
				apiVersion : "v2.8"
			});

			$routeProvider.when("/", {
				templateUrl : "home.html"
			}).when("/search/banquet/:state/:city", {
				templateUrl : "resources/views/search-results.tpl.html",
				controller : "SearchController"
			}).when("/userprofile", {
				templateUrl : "resources/views/user-profile.tpl.html",
				controller : "UserProfileFormController"
			}).when("/blue", {
				templateUrl : "blue.htm"
			}).otherwise("/");

		});*/