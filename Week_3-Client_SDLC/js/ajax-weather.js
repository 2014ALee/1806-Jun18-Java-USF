function searchWeather() {
    let input = document.getElementById('zipcode').value;
    document.getElementById('alert').innerText = '';
    sendAjaxRequest(baseUrl + input, displayWeather);
}
let xhr = new XMLHttpRequest();
function sendAjaxRequest(url, funct) {
    

    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            funct(xhr);
        }
    }

    xhr.open('GET', url, true);
    xhr.send();
}
function displayWeather() {
    let weather = JSON.parse(xhr.response);
    console.log(weather);
    document.getElementById('location').innerText = 'Weather for ' + weather.location.name;
    document.getElementById('icon').setAttribute('src', `http://${weather.current.condtion.icon}`);
    document.getElementById('status').innerText = weather.current.condtion.text;
    document.getElementById('temperature').innerText = `${weather.current.temp_f} F (feels like ${weather.current.feelslike_f})`;
}

document.getElementById('submit').addEventListener('click', searchWeather);

const baseUrl = 'http://api.apixu.com/v1/current.json?key=4f9095e1ed93462689a193305182003&q=';