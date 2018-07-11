function searchWeather() {
    let input = document.getElementById('zipcode').value;
    document.getElementById('alert').innerText = '';
    sendAjaxRequest(baseUrl + input, displayWeather);
}


    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            funct(xhr);
        }
    }

    xhr.open('GET', url, true);
    xhr.send();
}

    document.getElementById('temperature').innerText = `${weather.current.temp_f} F (feels like ${weather.current.feelslike_f})`;
}

document.getElementById('submit').addEventListener('click', searchWeather);

const baseUrl = 'http://api.apixu.com/v1/current.json?key=4f9095e1ed93462689a193305182003&q=';