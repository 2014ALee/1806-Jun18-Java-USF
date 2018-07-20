window['setRequestButton'] = function() {
	window['setClickListener']('submit-reimbursement', function() {
				let toSend = [];
				let amount = $('#submit-reimbursement-amount').val();
				let reimbursementType = $('#reimbursement-type').val();
				let rdscrp = $('#submit-reimbursement-username');
				let reimbursementDescription = (rdscrp.html() > rdscrp.val()) ? rdscrp.html() : rdscrp.val();
				if (reimbursementDescription.length == 0) {
					alert('Description cannot be empty!');
					return;
				}
				if ($('#submit-reimbursement-amount')[0].validationMessage.length > 2) {
					alert($('#submit-reimbursement-amount')[0].validationMessage);
					return;
				}
				$('#submit-reimbursement-amount').val('');
				$('#reimbursement-type').val('');
				rdscrp.val('');
				rdscrp.html('');
				toSend[0] = amount;
				toSend[1] = reimbursementType;
				toSend[2] = reimbursementDescription;
				let json = JSON.stringify(toSend);
				let xhr = new XMLHttpRequest();

				xhr.onreadystatechange = function() {
					if(xhr.readyState == 4 && xhr.status == 200) {
						let errorIndex = xhr.responseText.indexOf('error:');
						if (errorIndex >= 0 && errorIndex < 7) {
							$('#submit-reimbursement-message').html(xhr.responseText.substring(errorIndex + 6));
						}
						else {
							window['loadPage']('finish-submit-request.view');
						}
					}
				}
				
				xhr.open('POST', '/Expense-Reimbursement-System/submitrequest', true);
				xhr.setRequestHeader('Content-type', 'application/json');
				xhr.send(json);
		});
}