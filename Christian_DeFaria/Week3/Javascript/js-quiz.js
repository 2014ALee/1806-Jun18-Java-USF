window.onload = function() {
	// let quizDiv = document.createElement('div');
	// let submitButton = document.createElement('button');
	// let resultsDiv = document.createElement('div');
	//
	// jQuery('body').prepend('<div id="quiz"></div>');
	// $('body').append('<button id="submit>Submit</button>"');
	// $('body').append('<div id="results></div>"')

	buildQuiz();

	submitButton.addEventListener('click', showResults);
};

function buildQuiz() {
	const output = [];

	myQuestions.forEach((currentQuestion, questionNumber)=>{
		const answers = [];

		for(letter in currentQuestion.answers) {
			answers.push(`
				<label>
					<input type="radio" name="question${questionNumber}" value="${letter}"/>
					${letter} : ${currentQuestion.answers[letter]}
				</label>
			`);
		}
		output.push(`
			<div class="question">${currentQuestion.question}</div>
			<div class="answers">${answers.join('')}</div>
		`);
	});
	quizContainer.innerHTML = output.join('');
}

function showResults() {
	const answerContainers = quizContainer.querySelectorAll('.answers');

	let numCorrect = 0;

	myQuestions.forEach((currentQuestion,questionNumber) => {
		const answerContainer = answerContainers[questionNumber];
		const selected = `input[name=question${questionNumber}]:checked`;

		const userAnswer = (answerContainer.querySelector(selected) || {}).value;

		if(userAnswer === currentQuestion.correctAnswer) {
			numCorrect++;

			answerContainers[questionNumber].style.color='lightgreen';
		} else {
			answerContainers[questionNumber].style.color='red';
		}
	});

	let userScore = (numCorrect/myQuestions.length);
	resultsContainer.innerHTML = `${numCorrect} out of ${myQuestions.length} (${userScore*100}%)`
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
			c:	21
		},
		correctAnswer: 'b'
	},
	{
		question: 'What is the inherit boolean value of an empty object?',
		answers: {
			a: 'true',
			b: 'false',
			c:	'undefined'
		},
		correctAnswer: 'a'
	},
	{
		question: 'What is the inherit boolean value of an empty array?',
		answers: {
			a: 'true',
			b: 'false',
			c:	'undefined'
		},
		correctAnswer: 'a'
	},
	{
		question: 'typeof(NaN)?',
		answers: {
			a: 'NaN',
			b: 'Number',
			c:	'undefined'
		},
		correctAnswer: 'b'
	},
	{
		question: 'NaN == NaN?',
		answers: {
			a: 'true',
			b: 'false',
			c:	'undefined'
		},
		correctAnswer: 'b'
	}
];
