const capturing = true;
const bubbling = false;

//All bubbling
//Order of alerts =
//Inner, middle, outer
// document.getElementById('inner').addEventListener('click', function(e) {
//     alert('INNER');
//     console.log('e.target' + e.target);
//     console.log('e.currentTarget' + e.currentTarget);
//     console.log('e.eventPhase' + e.eventPhase);
// }, bubbling);


// document.getElementById('middle').addEventListener('click', function(e) {
//     alert('MIDDLE');
//     console.log('e.target' + e.target);
//     console.log('e.currentTarget' + e.currentTarget);
//     console.log('e.eventPhase' + e.eventPhase);
// }, bubbling);

// document.getElementById('outer').addEventListener('click', function(e) {
//     alert('OUTER');
//     console.log('e.target' + e.target);
//     console.log('e.currentTarget' + e.currentTarget);
//     console.log('e.eventPhase' + e.eventPhase);
// }, bubbling);

document.getElementById('inner').addEventListener('click', function(e) {
    alert('INNER');
    console.log('e.target' + e.target);
    console.log('e.currentTarget' + e.currentTarget);
    console.log('e.eventPhase' + e.eventPhase);
}, capturing);


document.getElementById('middle').addEventListener('click', function(e) {
    alert('MIDDLE');
    console.log('e.target' + e.target);
    console.log('e.currentTarget' + e.currentTarget);
    console.log('e.eventPhase' + e.eventPhase);
}, capturing);

document.getElementById('outer').addEventListener('click', function(e) {
    alert('OUTER');
    console.log('e.target' + e.target);
    console.log('e.currentTarget' + e.currentTarget);
    console.log('e.eventPhase' + e.eventPhase);
}, capturing);