window.onload = function(){
    addBtn.addEventListener('click', addItemToList);
}

function addItemToList(){
    if(inputText.value){
        //buyList.innerHTML = buyList.innerHTML + '<li>new thing</li>';
        buyList.innerHTML = `
            ${buyList.innerHTML}
            <li id="${inputText.value}">${inputText.value}</li>
        `;
        document.getElementById(inputText.value).addEventListener('click', purchase)
    }
}

function purchase(e) {
    let elem = e.target || e.srcElement;
    let val = elem
    console.log(e.target || e.srcElement);
    purchasedList.innerHTML = `
       ${purchasedList.innerHTML}
       <li>${elem.innerHTML}</li>
    `;
}

const inputText = document.getElementById('newItem');
const addBtn = document.getElementById('add');
const buyList = document.getElementById('toBuy');
const purchasedList = document.getElementById('bought');
