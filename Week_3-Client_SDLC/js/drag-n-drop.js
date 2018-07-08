function dynamicFib(num) {
    let myArr = [0,1];

    for(let i=2; i <= num; i++){
        myArr[i] = myArr[i-1] + myArr[i - 2];
    }
    return myArr[num];
}

//event listen
document.getElementById('doFib').addEventListener('click', runFib);

function runFib(){
    let inputValue = document.getElementById('fib').value;
    let display = document.getElementById('fibDisplay');

    if (inputValue == ''){
        prompt('No input given, you troll...');
    }else{
        display.innerText = dynamicFib(inputValue);
        display.innerText = recursiveFib(inputValue);
    }
}

function recursiveFib(num) {
    if(num <= 1)
        return num;
    return (recursiveFib(num - 1) + recursiveFib(num-2));
}


const capturing = true;
let counter = 0;

function click(e) {
    console.log(e.currentTarget + '' + counter++);
    e.stopPropagation();
}

function allowDrag(e){
    console.log('Dragging over element: ' + e.target.id);
    e.preventDefault();
}

function drag(e) {
    e.stopPropagation();
    console.log('Starting to drag element: ' + e.target.id);
    e.dataTransfer.setData('text', e.target.id);
}
function drop(e) {
    e.preventDefault();
    let data = e.dataTransfer.getData('text');
    e.target.insertBefore(document.getElementById(data), e.target.firstChild);
}

document.getElementById('outer').addEventListener('click', click, capturing);
document.getElementById('outer').addEventListener('dragstart', drag, capturing);
document.getElementById('outer').addEventListener('dragover', allowDrag, capturing);
document.getElementById('outer').addEventListener('drop', drop, capturing);

document.getElementById('middle').addEventListener('click', click, capturing);
document.getElementById('middle').addEventListener('dragstart', drag, capturing);
document.getElementById('middle').addEventListener('dragover', allowDrag, capturing);
document.getElementById('middle').addEventListener('drop', drop, capturing);

document.getElementById('inner').addEventListener('click', click, capturing);
document.getElementById('inner').addEventListener('dragstart', drag, capturing);
document.getElementById('inner').addEventListener('dragover', allowDrag, capturing);
document.getElementById('inner').addEventListener('drop', drop, capturing);