function getLogin(username, password) {
	/* to fetch user by email or mobile phone */
	var returnObj = {};
	returnObj["RecordList"] = null;
	returnObj["message"] = null;

	if (username != null) {
		var users = db.getCollection('user');
		var results = users.find({
			$or : [ {
				"email" : username
			}, {
				"mobile" : username
			} ]
		}).toArray();
		if (results != null && results.length > 0) {
			returnObj["RecordList"] = results;
			returnObj["message"] = "Record Found";
		} else {
			returnObj["message"] = "No Record Found";
		}
	} else {
		returnObj["message"] = "username must not be blank";
	}
	return returnObj;
}