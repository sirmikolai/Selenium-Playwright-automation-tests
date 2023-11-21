package core.mailosaur;

import com.mailosaur.MailosaurClient;

class MailosaurConnectionManager {

    MailosaurClient initializeConnectionToMailosaur() {
        String mailosaurApiKey = "bR0zeFCgUeNv32eGQYgjM3hJdhekJ5Ud";
        return new MailosaurClient(mailosaurApiKey);
    }

}
