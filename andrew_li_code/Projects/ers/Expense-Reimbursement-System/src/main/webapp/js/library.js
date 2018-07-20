window['setClickListener'] = function(elementId, currentClickFunction) {
	let currentElement = $('#' + elementId);
	if (currentElement.css('background-color') == undefined) {
		setTimeout((function(currentElementId, currentClickFunctionCopy) {
			return function() { 
				window['setClickListener'](currentElementId,
						currentClickFunctionCopy);
			};
		} (elementId, currentClickFunction)), 1500);
	}
	else {
		if (currentElement.prop('tagName').toLowerCase() == 'button') {
			$((function(currentElementTemp, currentClickFunctionTemp) {
				return function() {
					currentElementTemp.click(currentClickFunctionTemp); 
				};
			}) (currentElement, currentClickFunction));
		}
		else {
			currentElement.click(currentClickFunction);
		}
	}
};