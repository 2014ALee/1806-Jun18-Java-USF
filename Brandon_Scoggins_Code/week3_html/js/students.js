let studentId = 1000;

function addStudent(){
    // Get the input fields' values
    let studentName = document.getElementById('name').value;    // JS
    let studentMajor = $('#major').val();       // JQuery

    // Can include some logic to check for input
    if(studentName == ""){
        return;
    }

    // create row for the sutrdents table
    let row = document.createElement('tr');
    let cell1 = document.createElement('td');
    let cell2 = document.createElement('td');
    let cell3 = document.createElement('td');

    // append the cells to the row
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);

    // append the row to the table
    document.getElementById('students').appendChild(row);

    // add our student info to new cells
    cell1.innerText = studentId++;
    cell2.innerText = studentName;
    cell3.innerText = studentMajor;
}

// add the event listener for the button to invoke addStudent()
document.getElementById('add').addEventListener('click', addStudent);