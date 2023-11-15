package models.enums;

public enum SystemAlerts {
    DANGER_ALERT_EMAIL_USED("Error! There is already registered user with that email!"),
    SUCCESS_ALERT_REGISTRATION_TEXT("Success! Confirmation email has been sent. Check your spam folder as well just in case."),
    SUCCESS_ALERT_CONFIRMATION_EMAIL_ADDRESS_TEXT("Success! Your account has been activated! Now, you can sign in."),
    SUCCESS_ALERT_LOGIN_TEXT("Success! You have been signed in correctly."),
    DANGER_ALERT_INVALID_CREDENTIALS_TEXT("Error! Invalid credentials."),
    SUCCESS_ALERT_SIGN_OUT_TEXT("Success! You have been signed out correctly."),
    SUCCESS_ALERT_USER_REMOVED_TEXT("Success! User has been removed."),
    SUCCESS_ALERT_ADDED_CAR_BRAND_TEXT("Success! Car brand has been added."),
    SUCCESS_ALERT_UPDATED_CAR_BRAND_TEXT("Success! Car brand has been updated."),
    SUCCESS_ALERT_DELETED_CAR_BRAND_TEXT("Success! Car brand has been removed."),
    SUCCESS_ALERT_PASSWORD_CHANGED_TEXT("Success! Your password has been changed."),
    DANGER_ALERT_INCORRECT_CURRENT_PASSWORD_TEXT("Error! Incorrect current password!"),
    SUCCESS_ALERT_ADDED_CAR_MODEL_TEXT("Success! Car model has been added."),
    SUCCESS_ALERT_UPDATED_CAR_MODEL_TEXT("Success! Car model has been updated."),
    SUCCESS_ALERT_DELETED_CAR_MODEL_TEXT("Success! Car model has been removed."),
    SUCCESS_ALERT_PROMOTING_USER_TEXT("Success! User with email '%s' has been promoted to ADMIN role."),
    SUCCESS_ALERT_DEMOTING_USER_TEXT("Success! User with email '%s' has been demoted to USER role.");

    private final String alertText;

    SystemAlerts(String alertText) {
        this.alertText = alertText;
    }

    public String getAlertText() {
        return this.alertText;
    }
}
