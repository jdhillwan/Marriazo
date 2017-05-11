function getFilteredVenues(params) {
	var retVal = [];
	params = JSON.parse(params);
	var pagesize = 25;
	var sortKey = "name";
	
	function isAvailable(venueId, date_range) {
		var available = true;
		var date_from = date_range.date_from;
		var date_to = date_range.date_to;
		var bookings = db.getCollection("bookings").find({"venueId" : venueId, "bookedTo" : {$gte : date_range.date_from}}).toArray();
		if(bookings.length>0){
			bookings.forEach(function(booking) {
				if((date_to > booking.bookedFrom && date_to <= booking.bookedTo) || (date_from >= booking.bookedFrom && date_from < booking.bookedTo) || (date_from < booking.bookedFrom && date_to > booking.bookedFrom)){
					available = false;
				}
			});
		}
		
		return available;
	}
	
	if(params.pageSize){
		pagesize = params.pageSize;
	}
	if(params.sortKey){
		sortKey = params.sortKey;
	}
	var query = { "$and" : []};
	if(params.state){
		query.$and.push({"state" : params.state});
	}
	if(params.city){
		query.$and.push({"city" : params.city});
	}
	if(params.price_range){
		query.$and.push({"price" : {"$gte" : params.price_range.min}});
		query.$and.push({"price" : {"$lte" : params.price_range.max}});
	}
	
	var venues = db.getCollection("venue").find(query).limit(pagesize).sort({sortKey : 1}).toArray();
	
	if(params.date_range){
		venues.forEach(function(venue) {
			if(isAvailable(venue._id, params.date_range)){
				retVal.push(venue);
			}
		});
	}else{
		retVal = venues;
	}
	
	return retVal;
}