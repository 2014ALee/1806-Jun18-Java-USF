// 1) Make each link direct the user to its respective website (see id)
function addLinks() {
	const googleLink = document.getElementsByName('google');
	googleLink[0].href = 'https://www.google.com';
	googleLink[0].innerText = 'Google';
	const twitterLink = document.getElementsByName('twitter');
	twitterLink[0].href = 'https://www.twitter.com';
	twitterLink[0].innerText = 'Twitter';
	const slackLink = document.getElementsByName('slack');
	slackLink[0].href = 'https://www.slack.com';
	slackLink[0].innerText = 'Slack';
	const javadocsLink = document.getElementsByName('javadocs');
	javadocsLink[0].href = 'http://www.oracle.com/technetwork/java/javase/tech/index-jsp-135444.html';
	javadocsLink[0].innerText = 'JavaDocs';
}

addLinks();

// 2) Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
function disablePluto() {
	const planetSelect = document.getElementById('planet');
	let planets = planetSelect.childNodes;
	planets.forEach(function(e) {
		// console.log(e.innerText);
		if(e.innerText == 'Pluto') {
			console.log('Found Pluto');
			e.setAttribute('disabled', true);
		}
	});
}

disablePluto();

// 3)Define a function alienText() which shows the hidden element displaying
// an alien message. When any planet other than Earth is selected, execute this function.

function alienText() {
	if(document.getElementById('planet').innerText != 'Earth') {
		const alien = document.getElementsByClassName('container')[0].getElementsByTagName('p');
		for(let i = 0; i < alien.length; i++) {
			if(alien[i].innerText == 'Beep boop') {
				alien[i].removeAttribute('hidden');
				console.log(alien[i].innerText);
			}
		}
	}
}

document.getElementById('planet').addEventListener('blur', alienText);

// 4)When the submit button is pressed, get the values from all of the input
// into a new row in the table below.  Make sure no input is empty, check that
// first and last name are at least two letters each. Validate for valid phone
// number and email structure. This should continue to work for multiple entries and rows.
function insertRow() {
		const form = document.getElementsByClassName('form-group')[0];
		const table = document.getElementsByClassName('table')[0];
		let userInput = form.childNodes;
		let newRow = '<tr scope="row">';
		let list = false;
		userInput.forEach(function(e) {
			if(e.value != undefined) {
				if(e.id=='lastname' || e.id == 'planet') {

				} else if(e.name == 'gender') {
					if(e.checked == true) {
						newRow+='<td>' + e.value + '</td>';
					}
				} else if (e.id == 'bday') {
					newRow+='<td>';
					let bday = new Date(e.value);
					if(bday.getMonth() < 9) {
						newRow += '0' + (bday.getMonth()+1) + '/';
					} else {
						newRow += bday.getFullMonth() + '/';
					}
					if(bday.getDate() < 10) {
						newRow += '0' + bday.getDate() + '/';
					} else {
						newRow += bday.getDate() + '/';
					}
					newRow+=bday.getFullYear()+'</td>';
				} else if(e.id == 'color') {
					let i = newRow.length -1;
					let angleCount = 0;
					for(; i>=0; i--) {
						if(newRow[i] == '<') {
							angleCount++;
						}
						if(angleCount == 2) {
							break;
						}
					}
					newRow=newRow.substring(0,i) + '<td>' + e.value.toUpperCase() + '</td>' + newRow.substr(i);
				} else if(e.type == 'checkbox') {
					if(list == false) {
						newRow += '<td><ul>';
						list = true;
					}
					if(e.checked == true) {
						newRow += '<li>' + e.value + '</li>';
					}
					if(e.value == 'basket') {
						newRow += '</ul></td>';
					}
				}
				else {
					newRow+='<td>' + e.value + '</td>';
				}
				// console.log(e.value);
			}
		});
		newRow+='</tr>'
		table.innerHTML+=newRow;
}

document.getElementById('form-sub').addEventListener('click', insertRow);

// 5)Create a function openDetails() which opens the details element. Invoke
// this function when the details’ summary is moused over. The details should
// be hidden when the mouse is removed from the summary.
let detailsCount = 0;
function openDetails() {
	const details =  document.getElementsByTagName('details')[0];
	if(detailsCount%2==0) {
		details.setAttribute('open', '');
	} else {
		details.removeAttribute('open');
	}
	detailsCount++;
}

document.getElementsByTagName('summary')[0].addEventListener('mouseover', openDetails);
document.getElementsByTagName('summary')[0].addEventListener('mouseleave', openDetails);

// 6)Create a function that concatenates the inner HTML of all of the span
// elements and prints the results to the console.

function concatSpan() {
	const spans = document.getElementsByTagName('span');
	let text = '';
	for(let i = 0; i<spans.length; i++) {
		text += spans[i].innerHTML + '\n';
	}
	console.log(text);
}

concatSpan();

// 7)Create a function that displays the current time on earth in the span with
// id “earth_time”. Invoke this function when “Earth time” button is clicked.

function earthTime() {
	let earth_time = document.getElementById('earth_time');
	const time = new Date();
	if(time.getHours() < 10) {
		earth_time.innerText = '0' + time.getHours() + ':';
	} else {
		earth_time.innerText = time.getHours() + ':';
	}
	if(time.getMinutes() < 10) {
		earth_time.innerText += '0' + time.getMinutes() + ':'
	} else {
		earth_time.innerText += time.getMinutes() + ':';
	} if(time.getSeconds()<10) {
		earth_time.innerText += '0' + time.getSeconds();
	} else {
		earth_time.innerText += time.getSeconds();
	}
}

document.getElementById('earth_time_check').addEventListener('click', earthTime);

// 8)Create two other functions which calculates and displays the time passed
// on Mars and Alpha Centauri b if the onset of January 1st, 1970 occured at
// the same time. Invoke the respective functions when their time buttons are
// clicked. An orbital period for Mars is 687 Earth days. Using an external api
// to get the orbital period for Alpha Centauri b.
// (try http://www.astropical.space/astrodb/apiref.php) Provide an
// implementation for getting this value using both AJAX and the fetch API.

//not done
function marsTime() {
	let mars_time = document.getElementById('mars_time');
	const time = new Date();
	let mHour = (time.getTime()/(1000*60*60*687*(time.getFullYear()-1970)));
	let mMin = (time.getTime()/(1000*60*24*687*(time.getFullYear()-1970)));
	console.log(Math.floor(mHour));
	console.log(Math.floor(mMin));
	if(mHour < 10) {
		mars_time.innerText = '0' + Math.floor(mHour) + ':';
	} else {
		mars_time.innerText = Math.floor(mHour) + ':';
	}
	if(mMin < 10) {
		mars_time.innerText += '0' +  Math.floor(mMin);
	} else {
		mars_time.innerText +=  Math.floor(mMin);
	}
}

function alphaTime() {
	let acb_time = document.getElementById('acb_time');
	const time = new Date();
	if(time.getHours() < 10) {
		acb_time.innerText = '0' + time.getHours() + ':';
	} else {
		acb_time.innerText = time.getHours() + ':';
	}
	if(time.getMinutes() < 10) {
		acb_time.innerText += '0' + time.getMinutes() + ':'
	} else {
		acb_time.innerText += time.getMinutes() + ':';
	} if(time.getSeconds()<10) {
		acb_time.innerText += '0' + time.getSeconds();
	} else {
		acb_time.innerText += time.getSeconds();
	}
}

document.getElementById('mars_time_check').addEventListener('click', marsTime);
document.getElementById('acb_time_check').addEventListener('click', alphaTime);



// 9)Three seconds after a user clicks on the “Intergalactic Directory” heading,
// the background color should change to a random color. Make sure this color is
// never black so we can still read our black text! (there are other dark colors
// it could change to where we also couldn’t see the text but it’s enough to just
// accomodate for a black background)

//random color code from Anatoliy @https://stackoverflow.com/questions/1484506/random-color-generator
function updateBG() {
	setTimeout(function() {
		let color = '#';
		let letters = '0123456789ABCDEF';
		for (var i = 0; i < 6; i++) {
			color += letters[Math.floor(Math.random() * 16)];
		}
		if(color == '#000000') {
			color = '#FFFFFF';
		}
		document.body.style.backgroundColor = color;
	}, 3000);
}

document.getElementsByTagName('h1')[0].addEventListener('click', updateBG);

// 10)When inputs with id n1 and n2 have valid numerical input, perform the
// operation specified in the select. Display the result in the element with id result.

function calc() {
	const n1 = document.getElementById('n1');
	const n2 = document.getElementById('n2');
	const op = document.getElementById('operation');
	let result = document.getElementById('result');

	let num1 = Number(n1.value);
	let num2 = Number(n2.value);
	if(num1 != NaN && num2 != NaN) {
		if(op.value == 'Add') {
			result.innerText=(num1+num2);
		} else if(op.value == 'Subtract') {
			result.innerText=(num1-num2);
		} else if(op.value == 'Divide') {
			result.innerText=(num1/num2);
		} else if(op.value == 'Multiply') {
			result.innerText=(num1*num2);
		}
	}
}

document.getElementById('n1').addEventListener('blur', calc);
document.getElementById('n2').addEventListener('blur', calc);
document.getElementById('operation').addEventListener('blur', calc);

// 11)Define function walkTheDom(node, func)
//     This function should traverse every node in the DOM.
//     Use recursion. On each node, calle func(node).

function walkTheDom(node, func) {
	// console.log(node.tagName);
	node.childNodes.forEach(func);
}

function func(node) {
	// console.log(node.tagName);
	node.childNodes.forEach(func);
}

walkTheDom(document, func);
