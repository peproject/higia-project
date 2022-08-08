package start.project.higia.security;

public interface IUserSecurity {

	String validatePasswordResetToken(String token);
	
}
