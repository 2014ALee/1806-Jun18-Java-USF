/*
 *	1. Making links direct to their respectvive sites
 */
(function() {
	let links = document.getElementsByTagName('a');
	for (let i = 0; i < links.length; i++) {
		let link = 'https://www.' + links[i].getAttribute('name') + '.com';
		links[i].setAttribute('href', link);
		links[i].innerHTML = links[i].getAttribute('name');
	}
} ());

/*
 *	2. Disabling the pluto option.
 */
(function() {
	let select = document.getElementById('planet');
	let options = document.getElementsByTagName('option');
	for (let i = 0; i < options.length; i++) {
		let optionValue = options[i].innerText;
		optionValue = optionValue.trim();
		optionValue = optionValue.toLowerCase();
		if (optionValue == 'pluto') {
			if (options[i].hasAttribute('disabled')) {
				options[i].setAttribute('disabled', true);
			}
			else {
				let disabledAttr = document.createAttribute('disabled');
				disabledAttr.value='true';
				options[i].setAttributeNode(disabledAttr);
			}
		}
	}
} ());

/*
 *	3. Defining the function alienText()
 */
(function() {
	let select = document.getElementById('planet');
	let selectValue = select.value;
	selectValue = selectValue.trim();
	selectValue = selectValue.toLowerCase();
	if (selectValue != 'earth') {
		let paragraphs = document.getElementsByTagName('p');
		for (let i = 0; i < paragraphs.length; i++) {
			if (paragraphs[i].hasAttribute('hidden')) {
				paragraphs[i].removeAttribute('hidden');
			}
		}
	}
	window['alienText'] = function() {
		let select = document.getElementById('planet');
		let selectedValue = select.value;
		selectValue = selectedValue.trim();
		selectValue = selectedValue.toLowerCase();
		if (selectedValue != 'earth') {
			let paragraphs = document.getElementsByTagName('p');
			for (let i = 0; i < paragraphs.length; i++) {
				if (paragraphs[i].hasAttribute('hidden')) {
					paragraphs[i].removeAttribute('hidden');			
				}
			}
		}
	};
	select.addEventListener('change', window['alienText']);
} ());



/*
 *	4. Defining the function alienText()
 */

(function () {
	window['submitinfo'] = function() {
		let validEmail = function(inputEmail) {
			let regexExp = '[A-Za-z][A-Za-z0-9]*'
				+ '([\\.\\-_.][A-Za-z.][A-Za-z0-9]*)*'
				+ '[@.][A-Za-z.][A-Za-z0-9]*'
				+ '([\\.\\-_.][A-Za-z.][A-Za-z0-9]*)*'
				+ '[\\..][A-Za-z.][A-Za-z0-9]*';
			let matches = inputEmail.match(regexExp);
			return matches != null && matches.length > 0;
		};
		let validPhoneNumber = function(phoneNumber) {
			let regexExp = '[0-9][0-9][0-9][0-9]'
					+ '[0-9][0-9][0-9][0-9][0-9]'
					+ '[0-9]+';
			let matches = phoneNumber.match(regexExp);
			return matches != null && matches.length > 0;
		};
		let validName = function(inputName) {
			let regexExp = '[A-Za-z][A-Za-z]+';
			let matches = inputName.match(regexExp);
			return matches != null && matches.length > 0;
		}

		let genderChosen = function() {
			let genders = document.getElementsByName('gender');
			for (let i = 0; i < genders.length; i++) {
				if (genders[i].checked) {
					console.log(genders[i].value);
					return true;
				}
			}
			return false;
		};

		let activityChosen = function() {
			let activities = document.getElementsByClassName('activity');
			for (let i = 0; i < activities.length; i++) {
				if (activities[i].checked) {
					console.log(activities[i].value);
					return true;
				}
			}
			return false;
		};
		if (!validName(document.getElementById('firstname').value)
				|| !validName(document.getElementById('lastname').value)) {
			alert('Invalid field, first name and last name must have '
					+ 'at least two letters each!');
			return;
		} else if (!validEmail(document.getElementById('email').value)) {
			alert('Invalid field, email is invalid!!');
			return;
		}
		if (!validPhoneNumber(document.getElementById('phone').value)) {
			alert('Invalid Phone number!!!');
			return;
		}
		else if (document.getElementById('bday').value.trim().length <= 0) {
			alert('Must have a valid birthday!');
			return;
		}
		else if (document.getElementById('color').value.trim().length <= 0) {
			alert('Must have a valid favorite color!!');
			return;
		}
		else if (!genderChosen) {
			alert('Select a gender!');
			return;
		}
		else if (!activityChosen) {
			alert('Select an Activity!!');
			return;
		}
		let appendRow = function() {
			let nextRow = document.createElement('tr');
			let scopeRow = document.createAttribute('row');
			scopeRow.value = 'row';
			nextRow.setAttributeNode(scopeRow);
			for (let i = 0; i < 7; i++) {
				let nextTD = document.createElement('td');
				nextRow.appendChild(nextTD);
			}
			return nextRow;
		};
		let buildRow = function(row) {
			dataFields = row.getElementsByTagName('td');
			dataFields[0].innerText = document.getElementById('firstname').value + ' '
				+ document.getElementById('lastname').value;
			dataFields[1].innerText = document.getElementById('email').value;
			dataFields[2].innerText = document.getElementById('phone').value;
			dataFields[3].innerText = document.getElementById('bday').value;
			dataFields[4].innerText = document.getElementById('color').value;
			dataFields[5].innerText = (function() {
				let gender = '';
				let genders = document.getElementsByName('gender');
				for (let i = 0; i < genders.length; i++) {
					if (genders[i].checked) {
						gender = genders[i].value;
					}
				}
				gender = gender.substring(0, 1).toUpperCase() + gender.substring(1,
					gender.length);
				return gender;
			} ());
			dataFields[6].innerHTML = (function() {
				let enjoyedActivities = '<ul>';
				let listActivities = document.getElementsByClassName('activity');
				for (let i = 0; i < listActivities.length; i++) {
					let act = listActivities[i];
					if (act.value == 'hiking' && act.checked) {
						enjoyedActivities += '<li>hiking</li>';
					}
					if (act.value == 'stamp' && act.checked) {
						enjoyedActivities += '<li>stamp collecting </li>';
					}
					if (act.value == 'birding' && act.checked) {
						enjoyedActivities += '<li>birding</li>';
					}
					if (act.value == 'basket' && act.checked) {
						enjoyedActivities += '<li>underwater basket weaving</li>';
					}
				}
				enjoyedActivities += '</ul>';
				return enjoyedActivities;
			} ());
			return buildRow;
		};
		let toAppend = appendRow();
		buildRow(toAppend);
		let dataFound = toAppend.getElementsByTagName('td');
		if (dataFound[5].innerText.trim().length < 1) {
			alert('No gender selected!!');
			return;
		} 
		if (dataFound[6].getElementsByTagName('li').length < 1) {
			alert('No activity selected!');
			return;
		}
		document.getElementsByTagName('tbody')[0].appendChild(toAppend);
	}
	document.getElementById('form-sub').addEventListener('click', window['submitinfo']);
} ());

/*
 * 5. Creating a function openDetails() which opens the details element
 */
(function () {
	window['openDetails'] = function() {
		let openAttr = document.createAttribute('open');
		openAttr.value='true';
		this.parentNode.setAttributeNode(openAttr);
	};
	window['closeDetails'] = function() {
		if (this.parentNode.hasAttribute('open')) {
			this.parentNode.removeAttribute('open');
		}
	};
	let summaries = document.getElementsByTagName('summary');
	for (let i = 0; i < summaries.length; i++) {
		summaries[i].addEventListener('mouseover', window['openDetails']);
		summaries[i].addEventListener('mouseout', window['closeDetails']);
	}
} ());

/*
 * 6. innerHTML of all span elements
 */
(function () {
	let spans = document.getElementsByTagName('span');
	let spanstring = '';
	for (let i = 0; i < spans.length; i++) {
		spanstring += spans[i].innerHTML;
	}
	console.log(spanstring);
} ());

/*
 * 7. Earth Time
 */
(function () {
	window['earthTime'] = function() {
		let months = ['January', 'February', 'March', 'April',
			'May', 'June', 'July', 'August','September', 'October',
			'November', 'December'];
		let displayedDate = '';
		let current = new Date();
		displayedDate += months[current.getMonth()] + ' ';
		displayedDate += current.getDay() + 1 + ', ';
		displayedDate += current.getFullYear() + ' ';
		let hour = current.getHours();
		let amOrPM = 'AM';
		if (hour > 12) {
			amOrPM = 'PM';
		}
		if (hour > 13) {
			hour %= 12;
		} else if (hour == 0) {
			hour = 12;
		}
		displayedDate += hour + ':' + current.getMinutes() + ':';
		displayedDate += current.getSeconds() + ' ' + amOrPM;
		document.getElementById('earth_time').innerText = displayedDate;
	};
	document.getElementById('earth_time_check').addEventListener('click',
		window['earthTime']);
} ());


/*
 * 8. Time passed on Mars.
 */
(function () {
	document.getElementById('mars_time_check').addEventListener('click', function() {
		let timePassed = new Date();
		timePassed /= 86400000.0;
		timePassed /= 687;
		document.getElementById('mars_time').innerText = 'Number of orbits '
				+ 'since 1970: ' + timePassed;
	});
	document.getElementById('acb_time_check').addEventListener('click', function() {
		let url = 'http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf%20Cen%20B%20b&format=json';
		let xhr = new XMLHttpRequest() || new ActiveXObject('Microsoft.HTTPRequest');
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				let period = parseFloat(JSON.parse(xhr.response)['exoplanets'][0]['per']);
				let timePassed = new Date();
				timePassed /= 86400000.0;
				timePassed /= period;
				document.getElementById('acb_time').innerText = 'Number of orbits '
					+ 'since 1970: ' + timePassed;
			}
		};
		xhr.open('GET', url, true);
		xhr.send();
	});
	document.getElementById('acb_time_check').addEventListener('mousedown', function() {
		let promiseObj = fetch('http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf%20Cen%20B%20b&format=json');
		promiseObj.then(function(response) {
			if (!response.ok) {
				throw Error('Did not get a proper response!!');
			}
			return response.json();
		}).then(function(response) {
			let period = parseFloat(response['exoplanets'][0]['per']);
			let timePassed = new Date();
			timePassed /= 86400000.0;
			timePassed /= period;
			document.getElementById('acb_time').innerText = 'Number of orbits '
					+ 'since 1970: ' + timePassed;
		}).catch(function(errorVal) {
			alert('Got the following error: ' + errorVal);
		});
	});
} ());


/*
 * 9. Intergalactic Directory	.
 */
(function () {
	let ourButton = (function() {
		let headings = document.getElementsByTagName('h1');
		for (let i = 0; i < headings.length; i++) {
			headingText = headings[i].innerText.toLowerCase();
			if (headingText.indexOf('intergalactic') >= 0
					&& headingText.indexOf('directory') >= 0) {
				return headings[i];
			}
		}
		return headings[0];
	} ());
	ourButton.addEventListener('click', function() {
		setTimeout(function() {
			let colour = '#';
			colour += (64 + parseInt(Math.random()
				* 128)).toString(16);
			colour += (64 + parseInt(Math.random()
				* 128)).toString(16);
			colour += (64 + parseInt(Math.random()
				* 128)).toString(16);
			document.body.style.backgroundColor = colour;
		}, 3000);
	})
} ());


/*
 * 10. Equations	.
 */
(function () {
	window['numberChange'] = function() {
		let n1 = document.getElementById('n1').value;
		let n2 = document.getElementById('n2').value;
		if (n1 != parseFloat(n1)) {
			return;
		}
		if (n2 != parseFloat(n2)) {
			return;
		}
		n1 = parseFloat(n1);
		n2 = parseFloat(n2);
		let op = document.getElementById('operation').value;
		op = op.trim();
		op = op.toLowerCase();
		switch (op) {
			case 'add':
			document.getElementById('result').innerHTML = n1 + n2;
			break;
			case 'subtract':
			document.getElementById('result').innerHTML = n1 - n2;
			break;
			case 'multiply':
			document.getElementById('result').innerHTML = n1 * n2;
			break;
			case 'divide':
			document.getElementById('result').innerHTML = n1 / n2;
			break;
		}
	};
	document.getElementById('n1').addEventListener('change', window['numberChange']);
	document.getElementById('n2').addEventListener('change', window['numberChange']);
	document.getElementById('operation').addEventListener('change',
		window['numberChange']);
} ());


/*
 * DOM WALKER	.
 */
(function () {
	let bodyVar = document.body;
	window['domWalker'] = function(element, spaces) {
		let str = '';
		for (let i = 0; i < spaces; i++) {
			str += '\t';
		}
		console.log(str + element.nodeName);
		let childNodes = element.childNodes;
		spaces++;
		for (let i = 0; i < childNodes.length; i++) {
			window['domWalker'](childNodes[i], spaces);
		}
	}
	let mainElement = document.getElementsByTagName('HTML');
	if (mainElement.length > 0) {
		mainElement = mainElement[0];
	} else {
		mainElement = document.getElementsByTagName('html')[0];
	}
	window['domWalker'](mainElement, 0);
} ());


