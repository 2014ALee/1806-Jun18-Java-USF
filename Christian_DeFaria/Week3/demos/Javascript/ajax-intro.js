/*

*/

window.onload = function() {
	idField.addEventListener('blur', fieldsValid);
	selectField.addEventListener('blur', fieldsValid);
	submitBtn.addEventListener('click', getInfo);

	submitBtn.setAttribute('disabled', true);

	alertMessage.style.display = 'none';
}

function fieldsValid() {
	let id = idField.value;
	let category = selectField.value;

	if(id === '' || category === '') {
		submitBtn.setAttribute('disabled', true);
		alertMessage.style.display = 'block';
	} else {
		alertMessage.style.display = 'none';
		submitBtn.removeAttribute('disabled');
	}
}

/*

*/
function fetchInfo() {
	console.log('in fetchInfo');
	let id = idField.value;
	let category = selectField.value;

	createResultsContainer(category);

	/*

	*/
	fetch(`https://swapi.co/api/${category}/${id}/`).then((resp)=>{
		if(category == 'people') {
			resp.json().then((jedi)=>{
				processPeopleFetch(jedi);
			}).catch(
				$('name').html('Invalid character id')
			)
		}
	});
}

function getInfo() {
	console.log('in getInfo');

	let id = idField.value;
	let category = selectField.value;

	/*

	*/
	createResultsContainer(category);

	/*

	*/
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		/*

		*/
		console.log(xhr.readyState);

		if(xhr.readyState == 4 && xhr.status == 200) {
			if(category == 'people') {
				processPeopleRespone(xhr);
			} else if(category == 'planets') {
				processPlanetRespone(xhr);
			} else if(category == 'starships') {
				processStarshipResponse(xhr);
			}
		}
	}

	xhr.open('GET', `http://swapi.co/api/${category}/${id}/`, true);

	xhr.send();
}

function processPeopleRespone(xhr) {
	let jedi = JSON.parse(xhr.responseText);
	console.log(jedi);

	$('#name').html(`<b>${jedi.name}</b>`);
	$('#height').html(`<b>Height: ${jedi.height}</b>`);
	$('#mass').html(`<b>Mass (kg): ${jedi.mass}</b>`);
	$('#hairColor').html(`<b>Hair Color: ${jedi.hair_color}</b>`);
	$('#eyeColor').html(`<b>Eye Color: ${jedi.eye_color}</b>`);
	$('#birthYear').html(`<b>Birth Year: ${jedi.birth_year}</b>`);
	$('#gender').html(`<b>Gender: ${jedi.gender}</b>`);
}

function processPlanetRespone(xhr) {
	let planet = JSON.parse(xhr.responseText);
	console.log(planet);
}

function processStarshipResponse(xhr) {
	let starship = JSON.parse(xhr.responseText);
	console.log(starship);
}

function processPeopleFetch(jedi) {
	console.log(jedi);

	$('#name').html(`<b>${jedi.name}</b>`);
	$('#height').html(`<b>Height: ${jedi.height}</b>`);
	$('#mass').html(`<b>Mass (kg): ${jedi.mass}</b>`);
	$('#hairColor').html(`<b>Hair Color: ${jedi.hair_color}</b>`);
	$('#eyeColor').html(`<b>Eye Color: ${jedi.eye_color}</b>`);
	$('#birthYear').html(`<b>Birth Year: ${jedi.birth_year}</b>`);
	$('#gender').html(`<b>Gender: ${jedi.gender}</b>`);
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
const submitBtn = document.getElementById('submitButton');
const resultsContainer = document.getElementById('resultsContainer');
const alertMessage = document.getElementById('alertMessage');
