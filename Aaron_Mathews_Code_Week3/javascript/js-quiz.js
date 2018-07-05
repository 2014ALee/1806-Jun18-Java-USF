// Perform some tasks when the page loads
window.onload = function () {
    //Dynamically create HTML element (ES6)
    /*let quizDiv = document.createElement('div');
    let submitBtn = document.createElement('button');
    let resultDiv = document.createElement('div');*/

    //Dynamically create HTML elements using jquery
    /*jQuery('body').prepend('<div id="quiz"></div>');
    $('body').append('<button id="submit">Submit</button>');
    $('body').append('<div id="results"></div>');*/

    //Build our quiz when the page loads

    buildQuiz();

    //Add event listener (ES6)
    submitButton.addEventListener('click', showResults);

}

function buildQuiz() {
    //A place to store HTML output
    const output = [];
    /*
        Next we can start building the HTML for each question
        Will need to loop
    */
    myQuestions.forEach((currentQuestion, questionNumber) => {
        //Storing list of possible answers in array
        const answers = [];

        for(letter in currentQuestion.answers) {
            //Add html radio button
            answers.push(`
            <label>
                <input type="radio" name="question${questionNumber}" value="${letter}">
                ${letter} : ${currentQuestion.answers[letter]}
            </label>
            `)
        }

        //add this question and its answers to output array
        output.push(`
        <div class="question">${currentQuestion.question}</div>
        <div class="answer">${answers.join('')}</div>
        `);
    });

    quizContainer.innerHTML = output.join('');

}

//Encapsulate logic for displaying the results
function showResults() {

    //gather answer containers from the quiz
    //Grabs all answers and puts this in array
    const answerContainers = quizContainer.querySelectorAll('.answer');

    let numCorrect = 0;

    myQuestions.forEach((currentQuestion, questionNumber) => {
        //find user selected answer
        const answerContainer = answerContainers[questionNumber];
        const selector = `input[name=question${questionNumber}]:checked`;
        //What if an answer is left blank
        //On guard and default
        const userAnswer = (answerContainer.querySelector(selector) || {}).value;

        if (userAnswer === currentQuestion.correctAnswer) {
            //increment user score
            numCorrect++;

            //Change color of question
            answerContainers[questionNumber].style.color = 'lightgreen';
        } else {
            answerContainers[questionNumber].style.color = 'red';
        }
    });

    let userScore = (numCorrect)/myQuestions.length;
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
            b:'"147"',
            c: 21
        },
        correctAnswer: 'a'
    },
    {
        question: 'What is the inherit boolean value of an empty object?',
        answers: {
            a: 'true',
            b:'false',
            c: 'undefined'
        },
        correctAnswer: 'a'
    },
    {
        question: 'What is the inherit boolean value of an empty array?',
        answers: {
            a: 'true',
            b:'false',
            c: 'undefined'
        },
        correctAnswer: 'a'
    }
]