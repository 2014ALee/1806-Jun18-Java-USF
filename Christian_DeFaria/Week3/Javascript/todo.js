window.onload = function() {
	submitButton.addEventListener('click', addToBuy);
	for(var i = 0; i < buyItems.length; i++) {
		buyItems[i].addEventListener('click', moveToPurchased);
	}
};

function addToBuy() {
	const item = inputBox.value;
	if(item != '') {
		buyList.innerHTML += "<li class=\"test\">" + item + "</li>";
		inputBox.value = '';
	}
}

function moveToPurchased() {
	purchasedList.innerHTML += "<li>"+this.innerHTML+"</li>";
	buyList.removeChild(this);
}

const inputBox = document.getElementById('newItem');
const buyList = document.getElementById('toBuy');
const submitButton = document.getElementById('add');
const purchasedList = document.getElementById('bought');
const buyItems = document.getElementsByClassName('test');
