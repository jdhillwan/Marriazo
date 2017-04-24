angular.module('MarriazoApp').controller(
		'SubscribeFormController',
		[ '$rootScope', '$scope', '$http', '$location',
				function(rootScope, scope, $http, location) {

					scope.initializeAsset = function() {
						scope.cityList = {
							"Punjab" : [ "Mohali", "Chandigarh", "Panchkula" ],
							"Haryana" : [ "Gurgaon", "Rohtak" ],
							"Goa" : [ "Goa" ]
						}
						scope.stateList = Object.keys(scope.cityList);
					}

					scope.search = function(city, state) {
						location.path('search/banquet/' + state + '/' + city);
					}

					scope.initializeAsset();

				} ]);