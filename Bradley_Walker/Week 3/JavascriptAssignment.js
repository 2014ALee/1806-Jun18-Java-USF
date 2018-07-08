window.onload = function(){
    // Select the links by name and set their href attributes appropriately
    $('[name="google"]').attr('href', 'https://www.google.com');
    $('[name="twitter"]').attr('href', 'https://www.twitter.com');
    $('[name="slack"]').attr('href', 'https://www.slack.com');
    $('[name="javadocs"]').attr('href', 'https://docs.oracle.com/javase/8/docs/');
    
    // Remove the Pluto option
    $('#planet').children().remove(':contains("Pluto")');
    
    // Add the event listener to the select element
    $('#planet').change(function(){
        // If the selected element is not earth
        if($('#planet option:selected').text() != 'Earth'){
            alienText();
        }
    });
    
    // Add the event listener to the suubmit button
    $('#form-sub').click(formSubmitted);
    
    // Add the event handlers to the details element
    $('details').mouseover(openDetails);
    $('details').mouseout(closeDetails);
    
    // Call the function to output all of the span text
    writeSpan();
    
    // Add the event handler to the time display buttons
    $('#earth_time_check').click(earthButtonClicked);
    $('#mars_time_check').click(marsButtonClicked);
    $('#acb_time_check').click(acbButtonClickedAJAX);
    
    // Add the event handler to the Intergalactic Directory heading
    $('body').find('h1:contains("Intergalactic Directory")').click(headingClicked);
    
    // Add the event handlers to the calculator elements
    $('#operation').change(performCalculation);
    $('#n1').change(performCalculation);
    $('#n2').change(performCalculation);
    
    // Walk the DOM
    console.log('\n\nWalking the DOM');
    walkTheDom($('html'), (node) => {
        console.log(node);
    });
};

// Make the hidden element visible
function alienText(){
    $('body').find(':contains("Beep boop")').removeAttr('hidden');
}

function formSubmitted(){
    // Get the required input from the form
    let fn = $('#firstname').val();
    let ln = $('#lastname').val();
    let email = $('#email').val();
    let phone = $('#phone').val();
    let bday = $('#bday').val();
    let planet = $('#planet option:selected').text();
    let color = $('#color').val();
    // Get the checked radio button
    let gender = $('[name="gender"]:checked').val();
    // Get all of the checked activities
    let activities = $('.activity:checked');
    
    // If the input is valid
    if(fn.length > 2 && ln.length > 2 && isEmail(email) && isPhoneNumber(phone)
     && bday && planet && color && gender && activities.length > 0){
        // Create a new row
        let row = $('<tr scope="row"></tr>');
        row.append(`<td>${fn} ${ln}</td>`);
        row.append(`<td>${email}</td>`);
        row.append(`<td>${phone}</td>`);
        // Finagle the date into the correct format
        let birthday = new Date(bday);
        birthday.setDate(birthday.getDate() + 1);
        let options = {day: '2-digit', month: '2-digit', year: 'numeric'};
        row.append(`<td>${birthday.toLocaleDateString("en-US", options)}</td>`);
        row.append(`<td>${color}</td>`);
        let genderText = (gender == 'male') ? 'Male' : 'Female';
        row.append(`<td>${genderText}</td>`);
        
        // Loop through the selected activities and add them to the list
        let list = $('<ul></ul>');
        for(let i = 0; i < activities.length; i++){
            let value = $(activities[i]).val();
            let text;
            if(value == 'stamp')
                text = 'stamp collecting';
            else if(value == 'basket')
                text = 'underwater basket weaving';
            else
                text = value;
            
            list.append(`<li>${text}</li>`);
        }
        row.append(list);
        
        // Add the new entry to the table
        $('table').append(row);
    } else {
        console.log('Invalid input');
    }
}

function isEmail(email){
    let pattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return pattern.test(email);
}

function isPhoneNumber(phone){
    let pattern = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
    return pattern.test(phone);
}

function openDetails(){
    $('details').attr('open', '');
}

function closeDetails(){
    $('details').removeAttr('open');
}

function writeSpan(){
    let spans = $('span');
    let text = '';
    
    for(let i = 0; i < spans.length; i++){
        text += $(spans[i]).text();
    }
    
    console.log(text);
}

function earthButtonClicked(){
    let dt = new Date();
    $('#earth_time').text(`${dt.getHours()}:${dt.getMinutes()}:${dt.getSeconds()}`);
}

function marsButtonClicked(){
    let orbitalPeriod = 687;
    let minutes = 1000 * 60;
    let hours = minutes * 60;
    let days = hours * 24;
    let years = days * orbitalPeriod;
    let dt = new Date();
    let t = dt.getTime();
    let yearsPassed = Math.round((t/years) * 100) / 100;
    $('#mars_time').text(`It has been ${yearsPassed} Martian years since January 1, 1970.`);
}

function acbButtonClickedAJAX(){
    // Create XHR object
    let xhr = new XMLHttpRequest();
    
    // Define the callback function
    xhr.onreadystatechange = function(){
        /*
            States:
            0 - UNSENT
            1 - OPENED
            2 - HEADERS_RECIEVED
            3 - LOADING
            4 - DONE
        */
        
        /*
            HTTP status
            100 - Informational
            200 - Success
            300 - Redirects
            400 - Client-side error
            500 - Server-side error
        */
                
        if(xhr.readyState == 4 && xhr.status == 200){
            // Request is done and successful
            let results = JSON.parse(xhr.responseText);
            let planetInfo = results['exoplanets'][0];
            let orbitalPeriod = planetInfo['per'];
            let minutes = 1000 * 60;
            let hours = minutes * 60;
            let days = hours * 24;
            let years = days * orbitalPeriod;
            let dt = new Date();
            let t = dt.getTime();
            let yearsPassed = Math.round((t/years) * 100) / 100;
            $('#acb_time').text(`It has been ${yearsPassed} Alpha Centauri B b years since January 1, 1970.`);
        }
    };
    
    // Open the request
    xhr.open('GET', 'http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf%20Cen%20B%20b&format=json');
    
    // Send the request
    xhr.send();
}

function acbButtonClickedFetch(){
    let url = 'http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf%20Cen%20B%20b&format=json';
    fetch(url).then((response) => {
        response.json().then((results) => {
        let planetInfo = results['exoplanets'][0];
        let orbitalPeriod = planetInfo['per'];
        let minutes = 1000 * 60;
        let hours = minutes * 60;
        let days = hours * 24;
        let years = days * orbitalPeriod;
        let dt = new Date();
        let t = dt.getTime();
        let yearsPassed = Math.round((t/years) * 100) / 100;
        $('#acb_time').text(`It has been ${yearsPassed} Alpha Centauri B b years since January 1, 1970.`);
        });
    });
}

function headingClicked(){
    setTimeout(()=>{
        let color = getRandomColor();
        while(color == '#000000'){
            color = getRandomColor();
        }
        $('body').css('background-color', color);
    }, 3000);
}

// Source: https://stackoverflow.com/questions/1484506/random-color-generator
function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}


function performCalculation(){
    let num1 = parseFloat($('#n1').val());
    let num2 = parseFloat($('#n2').val());
    
    if(num1 && num2 && typeof num1 == 'number' && typeof num2 == 'number'){
        let operation = $('#operation option:selected').text();
        
        if(operation == 'Add')
            $('#result').text(num1 + num2);
        else if(operation == 'Subtract')
            $('#result').text(num1 - num2);
        else if(operation == 'Multiply')
            $('#result').text(num1 * num2);
        else if(operation == 'Divide')
            $('#result').text(num1 / num2);
    }
}


function walkTheDom(node, func){
    node = $(node);
    func(node);
    if(node.children.length == 0) return;
    else node.children().each((index, element) => {
        walkTheDom(element, func);
    });
}





