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

/*
// Any item in the To Buy list that is clicked will be moved to the Purchased list
$('#toBuy').on('click', 'li', function() {
    $('#bought').append(this);
});
*/

// Any item in the Bought list that is clicked will be moved to the To Buy list
$('#bought').on('click', 'li', function() {
    $('#toBuy').append(this);
});


let toBuy = document.getElementById('toBuy');
toBuy.addEventListener('click', function(e) {
    let target = e.target;
    let bought = document.getElementById('bought');
    bought.appendChild(target);
});
