function dynamicFib(num) {
    let myArr = [0,1];

    for(let i = 2; i <= num; i++) {
        myArr[i] = myArr[i -1] + myArr[i - 2];
    }

    return myArr[num];
}

function imperativeFib(num) {
    let a = 1;
    let b = 1;
    let c;
    for(let i = 0; i < num - 2; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return b;
}

function recursiveFib(num) {
    if (num <= 1) {
        return num;
    } else {
        return (recursiveFib(num-1) + recursiveFIb(num-2));
    }
}
// Add event listerner to our button
document.getElementById('doFib').addEventListener('click',runFib);

function runFib() {
    let inputValue = document.getElementById('fib').value;
    let display = document.getElementById('fibDisplay');

    if(input == '') {
        prompt('No input given, you troll...');
    } else {
        display.innerText = dynamicFib(inputValue);
    }
}