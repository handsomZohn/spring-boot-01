console.log('for...of的循环');


const array01 = ['a','b','c']

console.log('for...of遍历数组01:')
for (const element of array01) {
    console.log(element)
}


console.log('for...of遍历数组02:')
let iterable = [10, 20, 30]
for (const number of iterable) {
    number += 1;
    console.log(number+1)
}
