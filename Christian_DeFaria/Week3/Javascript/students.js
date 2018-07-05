let studentId = 1000;

function addStudent() {
	//Get the input fields
	let studentName = document.getElementById('name').value;
	let studentMajor = $('#major').val();

	//
	let row = document.createElement('tr');
	let cell1 = document.createElement('td');
	let cell2 = document.createElement('td');
	let cell3 = document.createElement('td');

	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);

	document.getElementById('students').appendChild(row);

	cell1.innerText = studentId++;
	cell2.innerText = studentName;
	cell3.innerText = studentMajor;
}

document.getElementById('add').addEventListener('click', addStudent);
