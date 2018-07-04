// Perform some tasks when the page loads

window.onload = function() {

/*

    //Dynamically create HTML element (ES6)

    let quizDiv = document.createElement('div');

    let submitBtn = document.createElement('button');

    let resultsDiv = document.createElement('div');

    // Dynamically create HTML elements using jQuery

    jQuery('body').prepend('<div id="quiz"></div>');

    $('body').append('<button id="submit">Submit</button>');

    $('body').append('<div id="results"></div>');

*/

    // Build our quiz when the page loads

    buildQuiz();

    // The ES6 way of attaching events to an HTML element

    submitButton.addEventListener('click', showResults);

}

function buildQuiz() {

    // A place to store HTML output

    const output = [];

    /*

        Next we can start building the HTML for each question. We'll need

        to loop through each question.

    */

    myQuestions.forEach((currentQuestion, questionNumber) => {

        //storing the list of answer choices

        const answers = [];

        // and for each available answer

        for(letter in currentQuestion.answers) {

            // dynamically add an HTML radio button

            answers.push(`

            <label>

                <input type="radio" name="question${questionNumber}" value="${letter}">

                ${letter} : ${currentQuestion.answers[letter]}

            </label>

            `);

        }

        // add this question and its answers to the output

        output.push(`

        <div class="question">${currentQuestion.question}</div>

        <div class="answer">${answers.join('')}</div>

        `);

    });

    // combine our output list into one string of HTML and put it on the page

    quizContainer.innerHTML = output.join('');

    

}

// Encapsulates the logic of displaying the results of the quiz

function showResults() {

    // gather answer containers from the quiz

    const answerContainers = quizContainer.querySelectorAll('.answer');

    let numCorrect = 0;

    //for each question...

    myQuestions.forEach((currentQuestion, questionNumber) => {

        // find the selected answer

        const answerContainer = answerContainers[questionNumber];

        const selector = `input[name=question${questionNumber}]:checked`;

        // notes on guard and default operator here

        const userAnswer = (answerContainer.querySelector(selector) || {}).value;

        // determine if the user's answer is correct

        if (userAnswer === currentQuestion.correctAnswer) {

            //increment the user's score

            numCorrect++;

            // color the correct answers green

            answerContainers[questionNumber].style.color = 'lightgreen';

        } else {

            // color the incorrect answers red

            answerContainers[questionNumber].style.color = 'red';

        }

    });

    let userScore = (numCorrect / myQuestions.length);

    resultsContainer.innerHTML = `${numCorrect} out of ${myQuestions.length} (${userScore})`;

}

// Convenient references for our HTML elements

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

        question: 'What is the inherit boolean value of an empty object?',

        answers: {

            a: 'true',

            b: 'false',

            c: 'undefined'

        },

        correctAnswer: 'a'

    },

    {

        question: 'What is the inherit boolean value of an empty array',

        answers: {

            a: 'true',

            b: 'false',

            c: 'undefined'

        },

        correctAnswer: 'a'

    },

    {

        question: 'typeOf(NaN) = ?',

        answers: {

            a: 'NaN',

            b: 'number',

            c: 'undefined'

        },

        correctAnswer: 'b'

    },

    {

        question: 'NaN == NaN',

        answers: {

            a: 'true',

            b: 'false',

            c: 'undefined'

        },

        correctAnswer: 'b'

    }

]
