//unknown is restrictive
var a;
var b;
a = 5;
a = 'hi';
if (typeof a === 'string') {
    b = a;
}
//b = a; this will give error as type of a & b are different.
//never type
function gen(message, code) {
    throw { message: message, errorCode: code };
}
gen('an error occured', 500);
