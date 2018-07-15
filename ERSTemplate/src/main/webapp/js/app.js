window.onload = function(){
    loadLogIn();

}

function loadLogIn(){
	console.log("Logging in");
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			
			$('#view').html(xhr.responseText);
			//document.getElementById("view").innerHTML= xhr.responseText;
			
		}
	}
	
	xhr.open('GET', 'Login.view', true);
	xhr.send();
}

function submitLoginInfo(){
	
	getLogInInfo();		
}


function getLogInInfo(){
	console.log("got here!!!!asda");
	
let xhr = new XMLHttpRequest();
	
//after these two statements we have an array of the results
let submittedFields = document.getElementsByClassName("form-group")[0];
let values = submittedFields.getElementsByTagName("input");

let userName = values[0].value;
let password = values[1].value;
console.log(password);

let toSend = [userName, password];
let json = JSON.stringify(toSend);

xhr.onreadystatechange = function() {
	if(xhr.readyState == 4 && xhr.status == 200) {
		let user = JSON.parse(xhr.responseText);
		
		if(user == null) {
			$('#login-message').html('Invalid credentials!');
			alert('Login unsuccesful!');
		} else {
			alert('Login successful!');
			loadHome();
			console.log(`User id: ${user.id} login successful!`)
		}
	}
}


xhr.open('POST', 'LoginServlet', true);
xhr.setRequestHeader('Content-type', 'application/json');
xhr.send(json);
}

	//let xhr = new XMLHttpRequest();
	
	
	//let xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function()
	//xhr.open('POST', 'login', true);
//	xhr.setRequestHeader('Content-type', 'application/json');
	//xhr.send(json);
	

	
	