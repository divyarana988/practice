
//function type tells the type of parameter taken nd return type of function.


function Add3(n1: number, n2: number) {
    return n1 + n2;
}

function print(num: number): void {
    console.log('Result: ' + num);
}

function Call(n1: number, n2: number, cb: (num: number) => void) {
    const res = n1 + n2;
    cb(res);
}

print(Add3(5, 120));

let y1: (a: number, b: number) => number;

y1 = Add3;
// y1 = print will give error

console.log(y1(1, 1));


Call(1, 1, (x) => {
    console.log(x);
})