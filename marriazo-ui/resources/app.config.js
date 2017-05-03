app
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
			}).when("/weddingVenue", {
				templateUrl : "resources/views/wedding-venue.tpl.html",
				controller : "WeddingVenueController"
			}).when("/flowerDecoration", {
				templateUrl : "resources/views/flower-decoration.tpl.html",
				controller : "FlowerDecorationController"
			}).when("/cardInvitation", {
				templateUrl : "resources/views/card-invitation.tpl.html",
				controller : "CardInvitationController"
			}).when("/catering", {
				templateUrl : "resources/views/catering.tpl.html",
				controller : "CateringController"
			}).when("/photographer", {
				templateUrl : "resources/views/photographer.tpl.html",
				controller : "PhotoGrapherController"
			})

			.otherwise("/");

		});