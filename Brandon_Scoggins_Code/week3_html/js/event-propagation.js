const capturing = true;
const bubbling =  false;
/*
// All bubbling
// Order of alerts = INNER -> MIDDLE -> OUTER
document.getElementById('inner').addEventListener('click', function(e) {
    alert('INNER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);

document.getElementById('middle').addEventListener('click', function(e) {
    alert('MIDDLE!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);

document.getElementById('outer').addEventListener('click', function(e) {
    alert('OUTER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);
*/
/*
// All Capturing
// Order of alerts = Outer -> MIDDLE -> Inner
document.getElementById('inner').addEventListener('click', function(e) {
    alert('INNER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, capturing);

document.getElementById('middle').addEventListener('click', function(e) {
    alert('MIDDLE!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, capturing);

document.getElementById('outer').addEventListener('click', function(e) {
    alert('OUTER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, capturing);
*/
/*
// Inner = bubbling, outer and middle = capturing
// Order of alerts = OUTER -> MIDDLE -> INNER
document.getElementById('inner').addEventListener('click', function(e) {
    alert('INNER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);

document.getElementById('middle').addEventListener('click', function(e) {
    alert('MIDDLE!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, capturing);

document.getElementById('outer').addEventListener('click', function(e) {
    alert('OUTER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, capturing);
*/
/*
// Inner and middle = bubbling, outer = capturing
// Order of alerts = OUTER -> INNER -> MIDDLE
document.getElementById('inner').addEventListener('click', function(e) {
    alert('INNER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);

document.getElementById('middle').addEventListener('click', function(e) {
    alert('MIDDLE!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);

document.getElementById('outer').addEventListener('click', function(e) {
    alert('OUTER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, capturing);
*/
/*
// Inner and outer = bubbling, middle = capturing
// Order of alerts = 
document.getElementById('inner').addEventListener('click', function(e) {
    alert('INNER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);

document.getElementById('middle').addEventListener('click', function(e) {
    alert('MIDDLE!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, capturing);

document.getElementById('outer').addEventListener('click', function(e) {
    alert('OUTER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);
*/
/*
// Middle and outer = bubbling, inner = capturing
// Order of alerts = 
document.getElementById('inner').addEventListener('click', function(e) {
    alert('INNER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, capturing);

document.getElementById('middle').addEventListener('click', function(e) {
    alert('MIDDLE!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);

document.getElementById('outer').addEventListener('click', function(e) {
    alert('OUTER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
}, bubbling);
*/

// No bubbling or capturing
// Order of alerts = 
document.getElementById('inner').addEventListener('click', function(e) {
    alert('INNER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
},);

document.getElementById('middle').addEventListener('click', function(e) {
    alert('MIDDLE!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
},);

document.getElementById('outer').addEventListener('click', function(e) {
    alert('OUTER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: ' + e.eventPhase);
},);
