var mongoose = require('mongoose');
// Setup schema
var contactSchema = mongoose.Schema({
    
     name: {
        type: String,
        required: true
    },
    email: {
        type: String,
        required: true
    },
    completeName: String,
    password: String,
    school: Number,
    gender: String,
    bio: String,
    pWhat: Number,
    pWhere: Number,
    time: Number,
    create_date: {
        type: Date,
        default: Date.now
    }
});
// Export Contact mode
var Contact = module.exports = mongoose.model('contact', contactSchema);
module.exports.get = function (callback, limit) {
    Contact.find(callback).limit(limit);
}