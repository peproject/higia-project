function verifyInput() {
	let name = document.getElementById('name');

	name.addEventListener('invalid', () => {
		name.style.borderColor = '#ff6347';
		name.style.color = '#ff6347';
		name.classList.add('hg-error');
	});

	let crm = document.getElementById('crm');

	crm.addEventListener('invalid', () => {
		crm.style.borderColor = '#ff6347';
		crm.style.color = '#ff6347';
		crm.classList.add('hg-error');
	});

	let email = document.getElementById('email');

	email.addEventListener('invalid', () => {
		email.style.borderColor = '#ff6347';
		email.style.color = '#ff6347';
		email .classList.add('hg-error');
	});

	let password = document.getElementById('password');

	password.addEventListener('invalid', () => {
		password.style.borderColor = '#ff6347';
		password.style.color = '#ff6347';
		password .classList.add('hg-error');
	});

	let rePassword = document.getElementById('re-password');

	rePassword.addEventListener('invalid', () => {
		rePassword.style.borderColor = '#ff6347';
		rePassword.style.color = '#ff6347';
		rePassword .classList.add('hg-error');
	});
}
