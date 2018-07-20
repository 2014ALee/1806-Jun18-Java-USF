window['getOldRequests'] = function() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let errorIndex = xhr.responseText.indexOf('error:');
			if (errorIndex >= 0 && errorIndex < 7) {
				alert(xhr.responseText.substring(errorIndex + 6));
				return;
			}
			try {
				window['requestsList'] = JSON.parse(xhr.responseText);
			} catch (e) {}
			for (let i = 0; i < window['requestsList'].length; i++) {
				window['requestsList'][i] = JSON.parse(window['requestsList'][i]);
				window['requestsList'][i]['author'] = JSON.parse(window['requestsList'][i]['author']);
			}
			if (window['requestsList'].length == 0) {
            	alert('No tickets associated with this account.')
            	return;
            }
            let tbody = $('#resultlist').find('tbody')[0];
            let tRows = $(tbody).find('tr');
            let stop = window['requestsList'].length < 10 ? window['requestsList'].length : 10;
            for (let i = 0; i < stop; i++) {
            	let currentReq = window['requestsList'][i];
            	let tRowH = $(tRows[i]).find('th')[0];
            	$(tRowH).text(currentReq['reimbursementid']);
            	let tCols = $(tRows[i]).find('td');
            	$(tCols[0]).text(currentReq['amount']);
            	$(tCols[1]).text(currentReq['rtype']);
            	$(tCols[2]).text(currentReq['author']['username']);
            	$(tCols[3]).text(currentReq['author']['firstname']);
            	$(tCols[4]).text(currentReq['author']['lastname']);
            	$(tCols[5]).text(currentReq['status']);
            	$(tCols[6]).text(currentReq['submitted']);
            	$(tRows[i]).show();
            }
            $('#resultlist').show();
            $('#view').hide();
		}
	}
	xhr.open('GET', '/Expense-Reimbursement-System/personaltickets', true);
	xhr.send();
};
