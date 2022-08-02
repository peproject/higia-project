package start.project.higia.security;

public interface ISecurityService {

	String validatePasswordResetToken(String token);
	
}
