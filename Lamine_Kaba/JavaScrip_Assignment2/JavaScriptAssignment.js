/*
    Make each link direct the user to its respective website
*/
// Link google to google site
var google = document.getElementsByName('google');
google[0].innerHTML = 'Google';
google[0].href = 'http://www.google.com/';

// Link twitter to twitter site
var twitter = document.getElementsByName('twitter');
twitter[0].innerHTML = 'Twitter';
twitter[0].href = 'http://www.twitter.com/';

// Lind slack to slack site
var slack = document.getElementsByName('slack');
slack[0].innerHTML = 'Slack';
slack[0].href = 'http://www.slack.com/';

//Link javaDocs to javaDocs site
var javadocs = document.getElementsByName('javadocs');
javadocs[0].innerHTML = 'JavaDocs';
javadocs[0].href = 'http://www.javadocs.com/';

/*
    Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
*/

function hiddenMessage(message){
    var hisMessage = message.target.value;
    var display = document.getElementsByTagName('p');
    console.log(hisMessage);
    if(message.target.value = 'Earth'){
        display.hidden = false;
    }else{
        display.hidden = true;
    }   
}
document.getElementById('planet').addEventListener('change', hiddenMessage);

/*
 	Create a function openDetails() which opens the details element. Invoke this function when the detailsÕ summary is moused over. The details should be hidden when the mouse is removed from the summary.

 */


detailsText = document.getElementsByTagName('details');

function openDetails() {
    detailsText[0].open = true;
}
function closeDetails() {
    detailsText[0].open = false;
}
detailsText[0].addEventListener('mouseover', openDetails);
detailsText[0].addEventListener('mouseover', closeDetails);


