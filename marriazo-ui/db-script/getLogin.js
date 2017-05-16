function getLogin(username, password) {
	/* to fetch user by email or mobile phone */
	var returnObj = {};

	if (username != null) {
		var results = db.getCollection('user').find({
			$or : [ {
				"email" : username
			}, {
				"mobile" : username
			} ]
		}).toArray();
		if (results != null && results.length > 0) {
			user = results[0];
			if(user.password == password){
				returnObj["recordList"] = results;
				returnObj["message"] = "Record Found";
			}else{
				returnObj["message"] = "Entered Password is not Correct";
			}
		} else {
			returnObj["message"] = "User Not Registered";
		}
	} else {
		returnObj["message"] = "username must not be blank";
	}
	return returnObj;
}