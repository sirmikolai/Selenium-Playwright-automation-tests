package core.mailosaur;

import com.mailosaur.models.Message;

public class MailosaurMessageManager {

    private MailosaurMessageManager () {

    }

    public static String getLinkFromMessage(Message message) {
        return message.html().links().get(0).href();
    }

}
