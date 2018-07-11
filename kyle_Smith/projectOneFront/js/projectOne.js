    // Get the modal
    const createForm = document.getElementById('createForm');
    
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == createForm) {
            createForm.style.display = "none";
        }
    }
document.getElementById('createBtn').addEventListener('click', () => document.getElementById('createForm').style.display='block');
document.getElementById('closeMe').addEventListener('click', () =>document.getElementById('createForm').style.display='none');