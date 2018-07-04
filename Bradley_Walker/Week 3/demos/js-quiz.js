window.onload = function(){
    /*
    // Dynamically creating elements using javascript
    let quizDiv = document.createElement('div');
    let submitBtn = document.createElement('button');
    let resultDiv = document.createElement('div');
    
    // Dynamically creating elements using jQuery
    jQuery('body').prepend('<div id="quiz"></div>');
    // or
    $('body').append('<button id="submit">Submit</button>');
    $('body').append('<div id="results"></div>');
    */
    
    // build our quiz when the page loads
    buildQuiz();
    
    // Attach an event listener to an HTML element
    submitButton.addEventListener('click', showResults);
};

function buildQuiz(){
    // A place to store html output
    const output = [];
    
    /*
        Next we start building the HTML for each question
    */
    
    myQuestions.forEach((currentQuestion, questionNumber)=>{
        // Storing the list of answer choices
        const answers = [];
        
        // and for each available answer
        for(letter in currentQuestion.answers){
            // Dynamically add an HTML radio button
            answers.push(`
                <label>
                    <input type="radio" name="questions${questionNumber}" value="${letter}">
                    ${letter} : ${currentQuestion.answers[letter]}
                </label>
            `);
        }
        
        // Add the question and its answers to the output
        output.push(`
            <div class="question">${currentQuestion.question}</div>
            <div class="answers">${answers.join('')}</div>
        `);
    });
    
    // Combine our output list into one string and put it on the page
    quizContainer.innerHTML = output.join('');
}

// Encapsulates the logic of displaying the results of the quiz
function showResults(){
    // Gather answer cons=tainers
    // Equivalent to document.getElementsByClass
    const answerContainers = quizContainer.querySelectorAll('.answer');
    
    let numCorrect = 0;
    
    myQuestions.forEach((currentQuestion, questionNumber)=>{
        // Find the user's selected answer
        const answerContainer = answerContainers[questionNumber];
        const selector = 'input[name=question${questionNumber}]:checked';
        
        // guard and default
        const userAnswer = (answerContainer.querySelector(selector) || {}).value;
        
        // Determine if the user's answer is correct
        if(userAnswer === currentQuestion.correctAnswer){
            // increment the user's score
            numCorrect++;
            
            // Color the correct answers green
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
        question: 'What is the inherent boolean value of an empty object?',
        answers: {
            a: 'true',
            b: 'false',
            c: 'undefined'
        },
        correctAnswer: 'a'
    },
    {
        question: 'What is the inherent boolean value of an empty array?',
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
        question: 'NaN == NaN = ?',
        answers: {
            a: 'true',
            b: 'false',
            c: 'undefined'
        },
        correctAnswer: 'b'
    }
];
