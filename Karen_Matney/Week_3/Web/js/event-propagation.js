const capturing = true;
const bubbling = false;

// ALL BUBBLING
// Order of alerts
document.getElementById('inner').addEventListener('click',function(e) {
    alert('INNER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: '+ e.eventPhase);
}, bubbling);

document.getElementById('middle').addEventListener('click',function(e) {
    alert('MIDDLE!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: '+ e.eventPhase);
}, bubbling);

document.getElementById('outer').addEventListener('click',function(e) {
    alert('OUTER!');
    console.log('e.target: ' + e.target);
    console.log('e.currentTarget: ' + e.currentTarget);
    console.log('e.eventPhase: '+ e.eventPhase);
}, bubbling);

// Give up, just get notes from github