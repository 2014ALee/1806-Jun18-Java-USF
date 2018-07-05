window.onload = function() {


    
    const submitButton = document.getElementById('Submit');
    submitButton.addEventListener('click', buildQuiz);
};

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
    const quizContainer = document.getElementById('quiz');
    quizContainer.innerHTML = output.join('');
    
}

// Convenient references for our HTML elements;
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