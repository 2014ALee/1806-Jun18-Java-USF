const capturing = true;
const bubbling = false;

// ALL BUBLING
// Order of alerts = 
document.getElementById('inner').addEventListener('click', function(e){
    alert('INNER');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    csonole.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);

document.getElementById('middle').addEventListener('click', function(e){
    alert('MIDDLE');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    csonole.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);

document.getElementById('outer').addEventListener('click', function(e){
    alert('OUTER');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    csonole.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);