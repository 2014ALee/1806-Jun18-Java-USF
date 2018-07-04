    window.onload = function() {
    	addButton.addEventListener('click', function1);
    }
const addButton = document.getElementById('add');
  function function1() {
	  var ul = document.getElementById('toBuy');
	  var li = document.createElement('li');
	  li.appendChild(document.createTextNode(document.getElementById('newItem').value));
	  li.setAttribute('id', 'toBuyItem' + document.getElementById('toBuy').getElementsByTagName('li').length); // added line
	  ul.appendChild(li);
	}
let parent = document.getElementById('toBuy');
parent.addEventListener('click', function (event) {
	let target = event.target;
	let purchased = document.getElementById('bought');
	bought.appendChild(target);
	console.log(target);
}, false);