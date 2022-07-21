function verifyEula() {
	let checkbox = document.getElementById('eula').checked

	if(checkbox === true) {
		document.getElementById('btn-register').disabled = false;
	} else {
		document.getElementById('btn-register').disabled = true;
	}

}
