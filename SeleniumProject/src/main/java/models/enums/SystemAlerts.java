package models.enums;

public enum SystemAlerts {
    DANGER_ALERT_EMAIL_USED("There is already registered user with that email!"),
    SUCCESS_ALERT_REGISTRATION_TEXT("Confirmation email has been sent. Check your spam folder as well just in case."),
    SUCCESS_ALERT_CONFIRMATION_EMAIL_ADDRESS_TEXT("Your account has been activated! Now, you can sign in."),
    SUCCESS_ALERT_LOGIN_TEXT("You have been signed in correctly."),
    DANGER_ALERT_INVALID_CREDENTIALS_TEXT("Invalid credentials."),
    SUCCESS_ALERT_SIGN_OUT_TEXT("You have been signed out correctly."),
    SUCCESS_ALERT_USER_REMOVED_TEXT("User has been removed."),
    SUCCESS_ALERT_ADDED_CAR_BRAND_TEXT("Car brand has been added."),
    SUCCESS_ALERT_UPDATED_CAR_BRAND_TEXT("Car brand has been updated."),
    SUCCESS_ALERT_DELETED_CAR_BRAND_TEXT("Car brand has been removed."),
    SUCCESS_ALERT_PASSWORD_CHANGED_TEXT("Your password has been changed."),
    DANGER_ALERT_INCORRECT_CURRENT_PASSWORD_TEXT("Incorrect current password!"),
    SUCCESS_ALERT_ADDED_CAR_MODEL_TEXT("Car model has been added."),
    SUCCESS_ALERT_UPDATED_CAR_MODEL_TEXT("Car model has been updated."),
    SUCCESS_ALERT_DELETED_CAR_MODEL_TEXT("Car model has been removed."),
    SUCCESS_ALERT_PROMOTING_USER_TEXT("User with email \'%s\' has been promoted to ADMIN role."),
    SUCCESS_ALERT_DEMOTING_USER_TEXT("User with email \'%s\' has been demoted to USER role.");

    private final String alertText;

    SystemAlerts(String alertText) {
        this.alertText = alertText;
    }

    public String getAlertText() {
        return this.alertText;
    }
}
