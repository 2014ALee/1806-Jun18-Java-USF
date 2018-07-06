function dynamicFib(num) {
    let myArr = [0, 1];

    for(let i = 2; i <= num; i++) {
        myArr[i] = myArr[i-1] + myArr[i-2];
    }
    return myArr[num];
}

//Add event listener
document.getElementById('doFib').addEventListener('click', runFib);

function imperativeFib(num) {
    let a = 1;
    let b = 1;
    let c;

    for (let i = 0; i < num; i++) {
        c = a + b;
        a = b;
        b = c;
    }

    return b;
}

for recursiveFib(num) {
    if (num <= 1) {
        return num;
    } else {
        return (recursiveFib(num - 1) + recursiveFib(num - 2));
    }
}


function runFib() {
    let inputValue = document.getElementById('fib').value;
    let display = document.getElementById('fibDisplay');

    if (inputValue=='') {
        prompt('No input given');
    } else {
        display.innerText = recursiveFib(inputValue);
    }
}