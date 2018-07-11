function dynamicFib(num) {

        display.innerText = recursiveFib(inputValue);
    }
}



const capturing = true;
let counter = 0;


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