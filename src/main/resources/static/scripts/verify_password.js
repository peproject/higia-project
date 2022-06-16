function verifyPassword() {
	let password = document.getElementById('password');
	let rePassword = document.getElementById('re-password');

	if(password.value !== rePassword.value) {
		rePassword.style.borderColor = 'tomato';
		document.getElementById('password-error').style.display = 'block';
	} else {
		document.getElementById('form-register').submit();
	}
}
