package core.mailosaur;

import com.mailosaur.MailosaurClient;

public class MailosaurConnectionManager {

    MailosaurClient initializeConnectionToMailosaur() {
        String mailosaurApiKey = "rboVdaP79SE9UhMm90RlHhGUTkjHbGlG";
        return new MailosaurClient(mailosaurApiKey);
    }

}
