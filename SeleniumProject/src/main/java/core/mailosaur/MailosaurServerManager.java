package core.mailosaur;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

import java.io.IOException;

public class MailosaurServerManager {

    public static final String SERVER_ID = "1jnplcil";
    private static final int POLLING_TIME_IN_MILLIS = 20000;

    private MailosaurServerManager() {

    }

    public static Message getEmailByRecipientName(String recipientName) throws IOException, MailosaurException {
        MailosaurClient mailosaurClient = new MailosaurConnectionManager().initializeConnectionToMailosaur();

        MessageSearchParams messageSearchParams = new MessageSearchParams().withServer(SERVER_ID).withTimeout(POLLING_TIME_IN_MILLIS);
        SearchCriteria searchCriteria = new SearchCriteria().withSentTo(recipientName);
        try {
            return mailosaurClient.messages().get(messageSearchParams, searchCriteria);
        } catch (MailosaurException e) {
            throw new MailosaurException(String.format("There are not any message with specified criteria! Recipient: %s, Timeout: %sms", recipientName, POLLING_TIME_IN_MILLIS), "NO_MESSAGE_FOUND");
        }
    }

    public static String generateEmailAddress() {
        MailosaurClient mailosaurClient = new MailosaurConnectionManager().initializeConnectionToMailosaur();
        return mailosaurClient.servers().generateEmailAddress(SERVER_ID);
    }
}
