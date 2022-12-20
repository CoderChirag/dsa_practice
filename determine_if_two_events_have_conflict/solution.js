/**
 * @param {string[]} event1
 * @param {string[]} event2
 * @return {boolean}
 */
var haveConflict = function(event1, event2) {
    let t1 = parseFloat(event1[0].split(':').join('.'));
    let t2 = parseFloat(event1[1].split(':').join('.'));
    let t3 = parseFloat(event2[0].split(':').join('.'));
    let t4 = parseFloat(event2[1].split(':').join('.'));
    
    return t2 >= t3 && t1 <= t4 ? true : false;
};