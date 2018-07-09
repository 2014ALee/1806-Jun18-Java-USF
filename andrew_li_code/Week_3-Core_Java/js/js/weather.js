const baseURL = 'https://api.apixu.com/v1/current.json?key=6fba29ac4d2d44dd8c4204117180507&q=';

function searchWeather() {
	let input = document.getElementById('zipcode').value;
	document.getElementById('alert').innerText = '';
	sendAjaxRequest(baseURL + input, displayWeather);
}

function sendAjaxRequest(url, funct) {
	let xhr = new XMLHttpRequest() || new ActiveXObject('Microsoft.HTTPRequest');

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			funct(xhr);
		}
	};

	xhr.open('GET', url, true);
	xhr.send();
}

function displayWeather(xhr) {
	let weather = JSON.parse(xhr.response);
	console.log(weather);
	document.getElementById('location').innerText = 'Weather for ' + weather.location.name;
	document.getElementById('icon').setAttribute('src', `http://${weather.current.condition.icon}`);
	document.getElementById('icon').setAttribute('alt', weather.current.condition.text);
	document.getElementById('status').innerText = weather.current.condition.text;
	document.getElementById('temperature').innerText = `${weather.current.temp_f} F (feels like ${weather.current.feelslike_f})`;
}
document.getElementById('submit').addEventListener('click', searchWeather);