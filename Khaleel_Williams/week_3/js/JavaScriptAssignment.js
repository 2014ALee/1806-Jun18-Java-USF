/*
1.  Make each link direct the user to its respective 
    website (see id)
*/
function setHref(){
    document.getElementsByName('google')[0].href = 'https://www.google.com/';
    document.getElementsByName('twitter')[0].href = 'https://twitter.com/?lang=en';
    document.getElementsByName('slack')[0].href = 'https://slack.com/signin';
    document.getElementsByName('javadocs')[0].href = 'http://www.oracle.com/technetwork/java/javase/tech/index-jsp-135444.html'; 
}
//setHref();

/*
    2. Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
*/
function removePluto(){
    let list = document.getElementById('planet');
    list[3].setAttribute('disabled', 'disabled')
    //list.remove(3);
}
//removePluto();


/*
    3.  Define a function alienText() which shows the hidden element displaying an alien message.
        When any planet other than Earth is selected, execute this function.
*/


let L = document.getElementById('planet');
L.addEventListener('change', alienText)
function alienText(){
    //document.getElementsByTagName("P")[5].hidden = false;
    if (document.getElementById('planet').value == "Earth"){
        //console.log('earth');
         document.getElementsByTagName("P")[5].hidden = true;
     } else {
        //console.log('not earth');
         document.getElementsByTagName("P")[5].hidden = false;
    }
    
}



/*
    4.  When the submit button is pressed, get the values from all of the input into a new row in the table below.
        Make sure no input is empty, check that first and last name are at least two letters each. Validate for valid 
        phone number and email structure. This should continue to work for multiple entries and rows
*/


/*
    5.  Create a function openDetails() which opens the details element. Invoke this function when the details’ summary
        is moused over. The details should be hidden when the mouse is removed from the summary.
*/

let openDetail = document.getElementsByTagName('details')[0];

openDetail.addEventListener('mouseover', openDetails);
openDetail.addEventListener('mouseleave', closeDetails);

function openDetails(){
    openDetail.open = true;
    //console.log("I'm over");
}
function closeDetails(){
    openDetail.open = false;
}

/*
    6.  Create a function that concatenates the inner HTML of all of the span elements and
        prints the results to the console.
*/

function concatSpan(){
    let newSpan = document.getElementsByTagName('span');
    let newString = "";

    for (i = 0; i < newSpan.length; i++){
        newString = newString.concat(newSpan[i].innerHTML)
    }
    console.log(newString);
}
//concatSpan();

/*
    7.  Create a function that displays the current time on earth in the span with id “earth_time”. 
        Invoke this function when “Earth time” button is clicked.
*/

let earthButton = document.getElementById('earth_time_check')
earthButton.addEventListener('click', displayCurrentTime)

function displayCurrentTime(){

    document.getElementById('earth_time').innerHTML = Date();

}

/*
    8.  Create two other functions which calculates and displays the time passed on Mars and Alpha Centauri b 
        if the onset of January 1st, 1970 occured at the same time. Invoke the respective functions when their 
        time buttons are clicked. An orbital period for Mars is 687 Earth days. Using an external api to get the 
        orbital period for Alpha Centauri b. (try http://www.astropical.space/astrodb/apiref.php) Provide an 
        implementation for getting this value using both AJAX and the fetch API.
*/

/*
    9.  Three seconds after a user clicks on the “Intergalactic Directory” heading, the background color should change
        to a random color. Make sure this color is never black so we can still read our black text! (there are other dark 
        colors it could change to where we also couldn’t see the text but it’s enough to just accomodate for a black 
        background)
*/
let interGalactic = document.getElementsByTagName('h1')[0];
interGalactic.addEventListener('click', delay);

function delay(){
    setTimeout(changeBackground, 3000);
}

function changeBackground(){
    let rgb = "rgb(0,0,0)";
    rgb = rgb.replace('0', random());
    rgb = rgb.replace(',0,', ','+random()+',');
    rgb = rgb.replace('0)', random()+')');

    document.body.style.backgroundColor = rgb;
    //console.log();
}

function random(){
    return Math.floor((Math.random() * 200) + 40);
}


/*
    10. When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. Display
        the result in the element with id result.       
*/

let input1 = document.getElementById('n1')
let input2 = document.getElementById('n2')

input1.addEventListener('blur', doMath)
input2.addEventListener('blur', doMath)

function doMath(){
    let val1 = 0;
    let val2 = 0;

    val1 = input1.value;
    val2 = input2.value;
    if ((val1 != '') && (val2 != '')){
        if ((isNaN(val1) == false) && (isNaN(val2) == false)){

            let action = document.getElementById('operation').value;
            let returnVal = 0;
            switch(action){
                case 'Add':
                    returnVal = Number(val1) + Number(val2); 
                    break;
                case 'Subtract':
                    returnVal = val1 - val2;
                    break;
                case  'Divide':
                    returnVal = val1 / val2;
                    break;
                case 'Multiply':
                    returnVal = val1 * val2;
                    break;
                default:
                    console.log("something went horribly wrong");
            }

            document.getElementById('result').innerHTML = returnVal;
            //console.log(action)

        } else {
            //console.log("one or both input values are not numbers")
        }
    } else {
        //console.log("one of the input values are empty");
    }
}
/*
    11. Define function walkTheDom(node, func)
	    This function should traverse every node in the DOM. 
	    Use recursion. On each node, calle func(node).

*/

function walkTheDom(node, func){
    //let root = document.getElementsByTagName('html')
    let root = document.childNodes;
    let childOfRoot = root.childNodes;
    console.log("this is the :" + root.length);
    console.log(childOfRoot);
}

walkTheDom();