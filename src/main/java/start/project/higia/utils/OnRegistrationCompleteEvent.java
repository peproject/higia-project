package start.project.higia.utils;

import org.springframework.context.ApplicationEvent;

import start.project.higia.models.Doctor;
import java.util.Locale;
@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private final String appUrl;
    private final Locale locale;
    private final Doctor doctor;

    public OnRegistrationCompleteEvent(final Doctor doctor, final Locale locale, final String appUrl) {
        super(doctor);
        this.doctor = doctor;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public Doctor getUser() {
        return doctor;
    }
	
}
