//function type tells the type of parameter taken nd return type of function.
function add3(n1, n2) {
    return n1 + n2;
}
function print(num) {
    console.log('Result: ' + num);
}
function call(n1, n2, cb) {
    var res = n1 + n2;
    cb(res);
}
print(add3(5, 120));
var x;
x = add3;
// x = print will give error
console.log(x(1, 1));
call(1, 1, function (x) {
    console.log(x);
});
