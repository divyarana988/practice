//Core type:-
//Number(int, float, double all same as in js)
//String
//Boolean
//Object(key-value)
//Array
//Tuple(do not exist in js but in ts yes)
//Enum(do not exist in js but in ts yes)
//Any most flexible but still must be avoided in use
function add2(n1, n2, showResult, phrase) {
    var sum = n1 + n2;
    if (showResult) {
        //cosnole.log(phrase + n1 + n2);
        console.log(phrase + sum);
    }
    else {
        return sum;
    }
}
var x = 5;
//const x = '5';
var y = 2.8;
var printResult = true;
var resultPhrase = 'Result is: ';
add2(x, y, printResult, resultPhrase);
//Object type
//{} symbol tells that it's an object
var person = {
    name: "John",
    age: 30
};
//const person: {
//    name : string; age: number;
//} = {
//    name: "John",
//    age: 30
//};
//above is one of the representation of typescript's object syntax
console.log(person);
//console.log(person.name);  --> this is not supported by typescript as in typescript we don't tell anything
//about the object
//Array type
var person2 = {
    name: "John",
    age: 30,
    hobbies: ['dance', 'reading']
};
var abc;
abc = ['Hi'];
//abc = "hi"; will give error
//abc = ['Hi', 3]; will give error. To avoid this, any[] in place of string[].
for (var _i = 0, _a = person2.hobbies; _i < _a.length; _i++) {
    var hobby = _a[_i];
    console.log(hobby.toUpperCase());
    //console.log(hobby.map());  //give error
}
//means we can access elements of array nd use them accordingly --> arrays are more flexible.
//Tuple type --> it's a fixed length array. It add more strictness.
var person3 = {
    name: "John",
    age: 30,
    hobbies: ['dance', 'reading'],
    role: [2, 'admin']
};
//person.role[1] = 10;  error
