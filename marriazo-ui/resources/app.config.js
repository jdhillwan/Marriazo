app
        .config(function(socialProvider, $routeProvider) {
          socialProvider
                  .setGoogleKey("373292484064-qta6ts2ii99p53tam1giil7f1d4mqngk.apps.googleusercontent.com");
          socialProvider.setLinkedInKey("YOUR LINKEDIN CLIENT ID");
          socialProvider.setFbKey({
            appId: "654355474752575",
            apiVersion: "v2.8"
          });

          $routeProvider
                  .when("/", {
                    templateUrl: "home.html"
                  })
                  .when("/search/banquet/:state/:city", {
                    templateUrl: "resources/views/search-results.tpl.html",
                    controller: "SearchController",
                    resolve: {
                      lazyTestCtrl: [
                          '$ocLazyLoad',
                          function($ocLazyLoad) {
                            return $ocLazyLoad
                                    .load(['resources/controllers/search.ctrl.js']);
                          }]
                    }
                  })
                  .when("/userprofile", {
                    templateUrl: "resources/views/user-profile.tpl.html",
                    controller: "UserProfileFormController",
                    resolve: {
                      lazyTestCtrl: [
                          '$ocLazyLoad',
                          function($ocLazyLoad) {
                            return $ocLazyLoad
                                    .load(['resources/controllers/userProfileForm.ctrl.js']);
                          }]
                    }
                  })
                  .when("/blue", {
                    templateUrl: "blue.htm"
                  })
                  .when("/weddingVenue", {
                    templateUrl: "resources/views/wedding-venue.tpl.html",
                    controller: "WeddingVenueController",
                    resolve: {
                      lazyTestCtrl: [
                          '$ocLazyLoad',
                          function($ocLazyLoad) {
                            return $ocLazyLoad
                                    .load(['resources/controllers/weddingVenue.ctrl.js']);
                          }]
                    }
                  })
                  .when("/flowerDecoration", {
                    templateUrl: "resources/views/flower-decoration.tpl.html",
                    controller: "FlowerDecorationController",
                    resolve: {
                      lazyTestCtrl: [
                          '$ocLazyLoad',
                          function($ocLazyLoad) {
                            return $ocLazyLoad
                                    .load(['resources/controllers/flowerDecoration.ctrl.js']);
                          }]
                    }
                  })
                  .when("/cardInvitation", {
                    templateUrl: "resources/views/card-invitation.tpl.html",
                    controller: "CardInvitationController",
                    resolve: {
                      lazyTestCtrl: [
                          '$ocLazyLoad',
                          function($ocLazyLoad) {
                            return $ocLazyLoad
                                    .load(['resources/controllers/cardInvitation.ctrl.js']);
                          }]
                    }
                  })
                  .when("/catering", {
                    templateUrl: "resources/views/catering.tpl.html",
                    controller: "CateringController",
                    resolve: {
                      lazyTestCtrl: [
                          '$ocLazyLoad',
                          function($ocLazyLoad) {
                            return $ocLazyLoad
                                    .load(['resources/controllers/catering.ctrl.js']);
                          }]
                    }
                  })
                  .when("/photographer",{
                            templateUrl: "resources/views/photographer.tpl.html",
                            controller: "PhotoGrapherController",
                            resolve: {
                              lazyTestCtrl: [
                                  '$ocLazyLoad',
                                  function($ocLazyLoad) {
                                    return $ocLazyLoad
                                            .load(['resources/controllers/photoGrapher.ctrl.js']);
                                  }]
                            }
                      })
                  .when("/birthdayParty",{
                            templateUrl: "resources/views/birthday-party.tpl.html",
                            controller: "BirthdayPartyController",
                            resolve: {
                              lazyTestCtrl: [
                                  '$ocLazyLoad',
                                  function($ocLazyLoad) {
                                    return $ocLazyLoad
                                            .load(['resources/controllers/birthdayParty.ctrl.js']);
                                  }]
                            }
                      })
                  .when("/weddingAnniversary",{
                            templateUrl: "resources/views/wedding-anniversary.tpl.html",
                            controller: "WeddingAnniversaryController",
                            resolve: {
                              lazyTestCtrl: [
                                  '$ocLazyLoad',
                                  function($ocLazyLoad) {
                                    return $ocLazyLoad
                                            .load(['resources/controllers/weddingAnniversary.ctrl.js']);
                                  }]
                            }
                      })
                  .when("/kitty",{
                            templateUrl: "resources/views/kitty.tpl.html",
                            controller: "KittyController",
                            resolve: {
                              lazyTestCtrl: [
                                  '$ocLazyLoad',
                                  function($ocLazyLoad) {
                                    return $ocLazyLoad
                                            .load(['resources/controllers/kitty.ctrl.js']);
                                  }]
                            }
                      })
                  .when("/getTogether",{
                            templateUrl: "resources/views/getTogether.tpl.html",
                            controller: "GetTogetherController",
                            resolve: {
                              lazyTestCtrl: [
                                  '$ocLazyLoad',
                                  function($ocLazyLoad) {
                                    return $ocLazyLoad
                                            .load(['resources/controllers/getTogether.ctrl.js']);
                                  }]
                            }
                      })
                  .when("/other",{
                            templateUrl: "resources/views/other.tpl.html",
                            controller: "OtherController",
                            resolve: {
                              lazyTestCtrl: [
                                  '$ocLazyLoad',
                                  function($ocLazyLoad) {
                                    return $ocLazyLoad
                                            .load(['resources/controllers/other.ctrl.js']);
                                  }]
                            }
                      })
                  .otherwise("/");

        });