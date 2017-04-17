var app = angular.module('MarriazoApp', [ 'ui.bootstrap', 'socialLogin' ]);

app.config(function(socialProvider) {
	socialProvider.setGoogleKey("373292484064-qta6ts2ii99p53tam1giil7f1d4mqngk.apps.googleusercontent.com");
	/*socialProvider.setLinkedInKey("YOUR LINKEDIN CLIENT ID");*/
	socialProvider.setFbKey({
		appId : "654355474752575",
		apiVersion : "v2.8"
	});
});