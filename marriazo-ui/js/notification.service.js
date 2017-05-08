angular.module('MarriazoApp').factory('NotificationService', [ 'toastr','Notification', function(toastr, Notification) {
	var successConfig = {
		fadeIn : 300,
		fadeOut : 3000,
		timeOut : 3000
	};
	var infoConfig = {
		fadeIn : 300,
		fadeOut : 1000,
		timeOut : 1000
	};
	var errorConfig = {
		allowHtml : true,
		closeButton : true,
		timeOut : 5000,
		extendedTimeOut : 0,
		closeHtml : '<span class="fa fa-remove"></span>'
	};
	var warningConfig = {}
	var stickyInfoConfig = {
		closeButton : true,
		timeOut : 0,
		extendedTimeOut : 0,
		closeHtml : '<span class="fa fa-remove"></span>'
	};

	return {
		success : success,
		info : info,
		error : error,
		warning : warning,
		stickyInfo : stickyInfo,
		clear : clear,
		uiSuccess:uiSuccess,
		uiInfo : uiInfo,
		uiError : uiError
	};
	
	function uiSuccess(title,text){
		Notification.success({message : text, title : title, delay: 5000});
	}
	
	function uiInfo(title,text){
		Notification.primary({message : text, title : title, delay: 5000});
	}
	
	function uiError(title,text){
		Notification.error({message : text, title : title, delay: 5000});
	}

	function success(title, text) {
		toastr.success(text, title, successConfig);
	}

	function info(title, text) {
		toastr.info(text, title, infoConfig);
	}

	function error(title, text) {
		toastr.error(text, title, errorConfig);
	}

	function warning(title, text) {
		toastr.warning(text, title, warningConfig);
	}

	function stickyInfo(title, text) {
		toastr.info(text, title, stickyInfoConfig);
	}

	function clear(title, text) {
		toastr.clear();
	}

} ]);
