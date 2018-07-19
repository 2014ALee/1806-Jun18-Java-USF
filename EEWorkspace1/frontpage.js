//TODO: Make the show/hide views

function loginButton(username, password){
    let un = document.getElementById('username').value;
    let pw = document.getElementById('password').value;
    let credentials = [un, pw];
    let json = JSON.stringify(credentials);
    if(un =='' || pw == ''){
        console.log('bad alert happens here');
        alert('Please enter both Username and Password!');
    }
    else{
        console.log('else called');
        let xhr = new XMLHttpRequest;
        xhr.onreadystatechange = function(){
            console.log('request sent');
            if(xhr.readyState == 4 && xhr.status == 200){
                let getUser = JSON.parse(xhr.responseText)
                if(getUser == null){
                    alert('Invalid Username or Password!')
                }
                else{
                    //make the call to change the view
                    console.log('valid user login');
                }
            }
            xhr.open('POST','login', true); //POST is the type of request, login is the servlet
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send(json);
        }
    }
};
document.getElementById('loginButton').addEventListener('click',loginButton);