// '|' represents union
// it is used when we expect multiple types


type comb = number | string;  // this is type-aliasing

function Sum(
    n1: number | string, //n1: comb
    n2: number | string  //n2: comb
) {
    let res;
    if (typeof n1 === 'number' && typeof n2 === 'number') {
        res = n1 + n2;
    }else{
        res = n1.toString() + n2.toString();
    }
    
    return res;
}

const Sum1 = Sum(1, 2);
const Sum2 = Sum('h', 'i');

console.log(Sum1);
console.log(Sum2);

