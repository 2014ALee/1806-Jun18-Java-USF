/*
    AJAX
        Asynchronous JavaScript and XML
            AJAX is not a programming language. AJX is a technique for
            accessing web servers from a web pae using JavaScript.
*/

window.onload = function() {
    // Add event listeners onto various page elements
    idField.addEventListener('blur',fieldsValid);
    selectField.addEventListener('blur',fieldsValid);
    submitBtn.addEventListener('click',getInfo);

    // Disable the submit button
    submitBtn.setAttribute('disabled',true);

    // Hide teh already message
    alertMessage.style.display = 'none';
}

function fieldsValid() {
    let id = idField.value;
    let category = selectField.value;

    if(id == '' || category == '') {
        alertMessage.style.display = 'block';
        submitBtn.setAttribute('disabled',true);
    } else {
        alertMessage.style.display = 'none';
        submitBtn.removeAttribute('disabled');
    }
}

function getInfo () {
    console.log('in getInfo');

    // Gett he value of the input field
    let id = idField.value;

    // get the value of the select field
    let category = selectField.value;

    /*
        Determine what is being searched for (people, planets, starships) and create
        the appropriate HTML resultsContainer.
    */

    createResultsContainer(categeory);
    /*
        Making asynchronous calls to an external web server using AJAX
            1) Create a XHR(XMLHttpRequest) object
            2) Define the XHR callback function (which will handle teh response when received)
            3) Open the XHR request by defining the HTTP method and the target server url
            4) Send the XHR request
    */
   // Step 1
   let xhr = new XMLHttpRequest();

   // Step 2
   xhr.onreadystatechange = function() {
       /*
        The XMLHttpRequest.readyState property returns the sate an XHR client
        is in. An XHR client exists in one of the following states:

            0 - UNSENT (the XHR object exists, but.open() has not called)
            1 - OPENED (.open() has been called)
            2 - HEADERS_RECIEVED (.send() has been called, and the response headers and status..)
            3 - LOADING (downloading the response body; .responseText holds partial ..)
            4 - DONE (the operation is complete)
       */

       console.log(xhr.readyState);

       if(xhr.readyState == 4 && xhr.status == 200) {
           if(category == 'people') {
               processPeopleResponse(xhr);
           } else if (category == 'planets') {
               processPlanetResponse(xhr);
           } else if (category == 'starship') {
               processStarshipResponse(xhr);
           }
       }
   }

   // Step 3
   xhr.open('GET',`http://swapi.co/api/${category}/${id}/`,true);

   // Step 4
   xhr.send();
}

function processPeopleResponse(xhr) {
    let jedi = JSON.parse(xhr.responseText);
    console.log(jedi);
}

function processPlanetResponse(xhr) {
    let planet = JSON.parse(xhr.responseText);
    console.log(planet);
}

function processStarshipResponse(xhr) {
    let startship = JSON.parse(xhr.responseText);
    console.log(starship);
}

function createResultsContainer(category) {
    console.log('in createResultContainer');
    while (resultsContainer.firstChild) {
        resultsContainer.removeChild(resultsContainer.firstChild);
    }

    if (category == 'people') {
        let nameContainer = document.createElement('h3');
        let heightContainer = document.createElement('h5');
        let massContainer = document.createElement('h5');
        let hairColorContainer = document.createElement('h5');
        let eyeColorContainer = document.createElement('h5');
        let birthYearContainer = document.createElement('h5');
        let genderContainer = document.createElement('h5');

        nameContainer.setAttribute('id', 'name');
        heightContainer.setAttribute('id', 'height');
        massContainer.setAttribute('id', 'mass');
        hairColorContainer.setAttribute('id', 'hairColor');
        eyeColorContainer.setAttribute('id', 'eyeColor');
        birthYearContainer.setAttribute('id', 'birthYear');
        genderContainer.setAttribute('id', 'gender');
        
        resultsContainer.appendChild(nameContainer);
        resultsContainer.appendChild(heightContainer);
        resultsContainer.appendChild(massContainer);
        resultsContainer.appendChild(hairColorContainer);
        resultsContainer.appendChild(eyeColorContainer);
        resultsContainer.appendChild(birthYearContainer);
        resultsContainer.appendChild(genderContainer);

    } else if (category == 'planets') {
        let nameContainer = document.createElement('h3');
        let rotationalPeriodContainer = document.createElement('h5');
        let orbitalPeriod = document.createElement('h5');
        let diameterContainer = document.createElement('h5');
        let climateContainer = document.createElement('h5');
        let terrainContainer = document.createElement('h5');
        let populationContainer = document.createElement('h5');
        
        nameContainer.setAttribute('id', 'name');
        rotationalPeriodContainer.setAttribute('id', 'rotationalPeriod');
        orbitalPeriod.setAttribute('id', 'orbitalPeriod');
        diameterContainer.setAttribute('id', 'diameter');
        climateContainer.setAttribute('id', 'climate');
        terrainContainer.setAttribute('id', 'terrain');
        populationContainer.setAttribute('id', 'population');
        
        resultsContainer.appendChild(nameContainer);
        resultsContainer.appendChild(rotationalPeriodContainer);
        resultsContainer.appendChild(orbitalPeriod);
        resultsContainer.appendChild(diameterContainer);
        resultsContainer.appendChild(climateContainer);
        resultsContainer.appendChild(terrainContainer);
        resultsContainer.appendChild(populationContainer);
        
    } else if (category == 'starships') {
        let nameContainer = document.createElement('h3');
        let modelContainer = document.createElement('h5');
        let manufacturerContainer = document.createElement('h5');
        let crewSizeContainer = document.createElement('h5');
        let passengerCapacityContainer = document.createElement('h5');
        let starshipClassContainer = document.createElement('h5');
        let hyperdriverRatingContainer = document.createElement('h5');
        
        nameContainer.setAttribute('id', 'name');
        modelContainer.setAttribute('id', 'model');
        manufacturerContainer.setAttribute('id', 'manufacturer');
        crewSizeContainer.setAttribute('id', 'crewSize');
        passengerCapacityContainer.setAttribute('id', 'passengerCapacity');
        starshipClassContainer.setAttribute('id', 'starshipClass');
        hyperdriverRatingContainer.setAttribute('id', 'hyperdriveRating');
        
        resultsContainer.appendChild(nameContainer);
        resultsContainer.appendChild(modelContainer);
        resultsContainer.appendChild(manufacturerContainer);
        resultsContainer.appendChild(crewSizeContainer);
        resultsContainer.appendChild(passengerCapacityContainer);
        resultsContainer.appendChild(starshipClassContainer);
        resultsContainer.appendChild(hyperdriverRatingContainer);
        
    }
}

const swForm = document.getElementById('sw-form');
const idField = document.getElementById('id');
const selectField = document.getElementById('category');
const submitBtn = document.getElementById('submitBtn');
const resultsContainer = document.getElementById('resultsContainer');
const alertMessage = document.getElementById('alertMessage');