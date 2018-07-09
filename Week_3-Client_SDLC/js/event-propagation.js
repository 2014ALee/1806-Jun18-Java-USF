const capturing = true;
const bubbling = false;

// ALL BUBBLING
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

// ALL CAPTURING
// Order of alerts = OUTER -> MIDDLE -> INNER
// document.getElementById('inner').addEventListener('click', function(e) {
//     alert('INNER!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, capturing);

// document.getElementById('middle').addEventListener('click', function(e) {
//     alert('MIDDLE!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, capturing);

// document.getElementById('outer').addEventListener('click', function(e) {
//     alert('OUTER!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, capturing);

// INNER = bubbling, MIDDLE & OUTER = capturing
// Order of alerts = OUTER -> MIDDLE -> INNER
// document.getElementById('inner').addEventListener('click', function(e) {
//     alert('INNER!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, bubbling);

// document.getElementById('middle').addEventListener('click', function(e) {
//     alert('MIDDLE!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, capturing);

// document.getElementById('outer').addEventListener('click', function(e) {
//     alert('OUTER!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, capturing);

// INNER & MIDDLE = bubbling, OUTER = capturing
// Order of alerts = OUTER -> INNER -> MIDDLE
// document.getElementById('inner').addEventListener('click', function(e) {
//     alert('INNER!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, bubbling);

// document.getElementById('middle').addEventListener('click', function(e) {
//     alert('MIDDLE!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, bubbling);

// document.getElementById('outer').addEventListener('click', function(e) {
//     alert('OUTER!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, capturing);

// INNER & OUTER = bubbling, MIDDLE = capturing
// Order of alerts = MIDDLE -> INNER -> OUTER
// document.getElementById('inner').addEventListener('click', function(e) {
//     alert('INNER!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, bubbling);

// document.getElementById('middle').addEventListener('click', function(e) {
//     alert('MIDDLE!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, capturing);

// document.getElementById('outer').addEventListener('click', function(e) {
//     alert('OUTER!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, bubbling);

// MIDDLE & OUTER = bubbling, INNER = capturing
// Order of alerts = INNER -> MIDDLE -> OUTER
// document.getElementById('inner').addEventListener('click', function(e) {
//     alert('INNER!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, capturing);

// document.getElementById('middle').addEventListener('click', function(e) {
//     alert('MIDDLE!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, bubbling);

// document.getElementById('outer').addEventListener('click', function(e) {
//     alert('OUTER!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// }, bubbling);

// No bubbling or capturing specified
// Order of alerts = INNER -> MIDDLE -> OUTER
// document.getElementById('inner').addEventListener('click', function(e) {
//     alert('INNER!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// });

// document.getElementById('middle').addEventListener('click', function(e) {
//     alert('MIDDLE!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// });

// document.getElementById('outer').addEventListener('click', function(e) {
//     alert('OUTER!');
//     console.log('e.target: ' + e.target);
//     console.log('e.currentTarget: ' + e.currentTarget);
//     console.log('e.eventPhase: ' + e.eventPhase);
// });