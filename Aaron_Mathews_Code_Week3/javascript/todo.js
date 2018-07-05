window.onload = function () {

    itemsContainer.addEventListener('click', purchase);
}
/*
    Add an event listener onto the Add Item button that will take the user input
    and add it to the To Buy list (only if there is some value in the input field).
*/
$('#add').on('click', function() {
    let text = $('#newItem').val();
    if (text != '') {
        let temp = document.createElement('li');
        temp.innerHTML = text;
        $('#toBuy').append(temp);
        $('#newItem').val('');
    }
});


// Any item in the To Buy list that is clicked will be moved to the Purchased list
$('#toBuy').on('click', 'li', function() {
    $('#bought').append(this);
});

// Any item in the Bought list that is clicked will be moved to the To Buy list
$('#bought').on('click', 'li', function() {
    $('#toBuy').append(this);
});


let something = document.getElementById('toBuy');
something.addEventListener('click', function(e) {
    let target = e.target;
    console.log(target);
});

const addButton = document.getElementById('add');
const buyList = document.getElementById('toBuy');
const purchasedList = document.getElementById('bought');