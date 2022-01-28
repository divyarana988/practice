// '|' represents union
// it is used when we expect multiple types
function sum(n1, //n1: comb
n2 //n2: comb
) {
    var res;
    if (typeof n1 === 'number' && typeof n2 === 'number') {
        res = n1 + n2;
    }
    else {
        res = n1.toString() + n2.toString();
    }
    return res;
}
var sum1 = sum(1, 2);
var sum2 = sum('h', 'i');
console.log(sum1);
console.log(sum2);
