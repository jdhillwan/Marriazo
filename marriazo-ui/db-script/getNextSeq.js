function getNextSeq(name) {
    if(!name)
        return 0;
    
    var seq = db.getCollection("_id_sequence").findAndModify(
          {
            query: { _id: name },
            update: { $inc: { seq: 1 } },
            new: true
          }
   );
          
   return seq;
} 
