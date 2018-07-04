window.onload = function(){

    
    addItemButton.addEventListener('click', addItemToToDOList);
}

const userInput = document.getElementById('newItem');
const addItemButton = document.getElementById('add');
const toBuyContainer = document.getElementById('toBuy');

function addItemToToDOList() {

    
  //  toBuyContainer.appendChild(document.createElement('li').innerHTML = userInput.value);

    toBuyContainer.appendChild(<li class="test">${userInput.value}</li>);
}