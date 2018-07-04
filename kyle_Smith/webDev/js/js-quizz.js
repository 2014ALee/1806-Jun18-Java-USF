window.onload = function() {

	// let quizDiv = document.createElement('div');
	// let submitBtn = document.createElement('button');
	// let resultsDiv = document.createElement('div');

	// jQuery('body').prepend('<div id="quiz"></div>');
	// $('body').append('<button id="submit">Submit</button>');
	// $('body').append('<div id="results"></div>');

	buildQuiz();

	submitButton.addEventListener('click', showResults);
}


function buildQuiz() {

	const output = [];

	myQuestions.forEach((currentQuestion, questionNumber) => {
		const answers =[];

		for(letter in currentQuestion.answers) {

			answers.push(`
				<label for=""><input type="radio" name="question${questionNumber}" value="${letter}" />
					${letter} : ${currentQuestion.answers[letter]}
				</label>
				`);
		}

		output.push(`
			<div class="question">${currentQuestion.question}</div>
			<div class="answer">${answers.join('')}</div>
			`);
	});

	quizContainer.innerHTML = output.join('');
}

function showResults() {

	const answerContainers = quizContainer.querySelectorAll('.answer');

	let numCorrect = 0;
	
	myQuestions.forEach((currentQuestion, questionNumber) =>  {

		const answerContainer = answerContainers[questionNumber];
		const selector = `input[name=question${questionNumber}]:checked`;

		const userAnswer = (answerContainer.querySelector(selector) || {}).value;

		if(userAnswer === currentQuestion.correctAnswer) {
			numCorrect++;

			answerContainers[questionNumber].style.color = 'lightgreen';
		} else {
			answerContainers[questionNumber].style.color = 'red';
		}
	});

	let userScore = (numCorrect / myQuestions.length);
	resultsContainer.innerHTML = `${numCorrect} out of ${myQuestions.length} (${userScore})`;
}


const quizContainer = document.getElementById('quiz');
const submitButton = document.getElementById('submit');
const resultsContainer = document.getElementById('results');
const myQuestions = [

	{
		question: '7 + 7 + "7" = ?',
		answers: {
			a: '"777"',
			b: '"147"',
			c: 21
		},
		correctAnswer: 'b'
	},
	{
		question: '2 + 7 + "7" = ?',
		answers: {
			a: '"777"',
			b: '"147"',
			c: 21
		},
		correctAnswer: 'b'
	}
]
