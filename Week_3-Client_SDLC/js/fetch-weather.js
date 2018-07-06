let baseUrl = 'http://api.apixu.com/v1/current.json?key=4f9095e1ed93462689a193305182003&q=';

function searchWeather(){

    let input = document.getElementById('zipcode').value;
    if (input.length !== 5 | input<0) { 
         document.getElementById('alert').innerHTML = 'Invalid Zipcode <br>';
    } else {
        document.getElementById('alert').innerHTML = '';
        fetch(baseUrl+input)
            .then( function(response) {
                if(!response.ok){
                    document.getElementById('alert').innerHTML = 'Invalid Zipcode <br>';
                    throw Error('Invalid zip error');   // we can throw our own errors
                }
                return response.json();
            }).then( json => displayWeather(json)).catch( e => console.log(e));
    }
}

function displayWeather(weather){
    document.getElementById('location').innerHTML = `Weather for ${weather.location.name}`;
    document.getElementById('icon').setAttribute('src', `http://${weather.current.condition.icon}`);
    document.getElementById('icon').setAttribute('alt', weather.current.condition.text);
    document.getElementById('status').innerHTML = weather.current.condition.text;
    document.getElementById('temperature').innerHTML = `${weather.current.temp_f} F (feels like ${weather.current.feelslike_f})`;
}