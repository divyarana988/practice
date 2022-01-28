
//unknown is restrictive

let a1: unknown;
let b1: string;

a1 = 5;
a1 = 'hi';

if (typeof a1 === 'string') {
    b1 = a1;
}

//b1 = a1; this will give error as type of a & b are different.


//never type

function gen1(message: string, code: number) {
    throw {message: message, errorCode: code}
}

gen1('an error occured', 500);