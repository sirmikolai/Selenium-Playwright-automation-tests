package core.mailosaur;

import com.mailosaur.MailosaurClient;

public class MailosaurConnectionManager {

    MailosaurClient initializeConnectionToMailosaur() {
        String mailosaurApiKey = "rgXlCSkgmCpviBd1UmgGreplZkFdeB3V";
        return new MailosaurClient(mailosaurApiKey);
    }

}
