//Core type:-
//Number(int, float, double all same as in js)
//String
//Boolean
//Object(key-value)
//Array
//Tuple(do not exist in js but in ts yes)
//Enum(do not exist in js but in ts yes)
//Any most flexible but still must be avoided in use

function Add12(n1: number, n2: number, showResult: boolean, phrase: string) {

    const sum = n1 + n2;

    if (showResult) {
        //cosnole.log(phrase + n1 + n2);
        console.log(phrase + sum);
    } else {
        return sum;
    }
    
}

const p = 5;
//const p = '5';

const q = 2.8;
const printResult2 = true;
const resultPhrase2 = 'Result is: ';

Add12(p, q, printResult2, resultPhrase2);



//Object type

//{} symbol tells that it's an object
const Person: {} = {
    name: "John",
    age: 30
};

//const Person: {
//    name : string; age: number;
//} = {
//    name: "John",
//    age: 30
//};
//above is one of the representation of typescript's object syntax


console.log(Person);
//console.log(Person.name);  --> this is not supported by typescript as in typescript we don't tell anything
//about the object


//Array type


const Person2 = {
    name: "John",
    age: 30,
    hobbies: ['dance', 'reading']
};

let abc2: string[];
abc2 = ['Hi'];
//abc2 = "hi"; will give error

//abc2 = ['Hi', 3]; will give error. To avoid this, any[] in place of string[].

for (const hobby of Person2.hobbies) {
    console.log(hobby.toUpperCase());
    //console.log(hobby.map());  //give error
}
//means we can access elements of array nd use them accordingly --> arrays are more flexible.


//Tuple type --> it's a fixed length array. It add more strictness.

const Person3: {
    name: string;
    age: number;
    hobbies: string[];
    role:[number, string]
} = {
    name: "John",
    age: 30,
    hobbies: ['dance', 'reading'],
    role: [2, 'admin']
};

//Person3.role[1] = 10;  error