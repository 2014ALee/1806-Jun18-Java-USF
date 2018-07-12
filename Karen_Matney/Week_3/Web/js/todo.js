const newItemContainer = document.getElementById('newItem');
const toBuyContainer = document.getElementById('toBuy');
const boughtContainer = document.getElementById('bought');
const addButton = document.getElementById('add');
const testContainer = document.querySelectorAll('.')

window.onload  = function () {
    addButton.addEventListener('click',addToBuy);

}

function addToBuy() {
    const itemValue = newItemContainer.value;
    console.log(itemValue);

    if(itemValue != '') {
        toBuyContainer.innerHTML += '<li class="test">' + itemValue + '</li>';
    }
}