window.onload = function(){
    loadLogIn();
}

function loadLogIn(){
	console.log("Logging in");

	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			
		//	$('#view').html(xhr.responseText);
			document.getElementById("view").innerHTML= xhr.responseText;
			
			
			console.log(document.getElementById("view"));
		}
	}
	
	
	
	xhr.open('GET', 'Login.view', true);
	xhr.send();
}

	//let xhr = new XMLHttpRequest();
	
	
	//let xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function()
	//xhr.open('POST', 'login', true);
//	xhr.setRequestHeader('Content-type', 'application/json');
	//xhr.send(json);
	

	
	