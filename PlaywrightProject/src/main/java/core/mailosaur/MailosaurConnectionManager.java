package core.mailosaur;

import com.mailosaur.MailosaurClient;

class MailosaurConnectionManager {

    MailosaurClient initializeConnectionToMailosaur() {
        String mailosaurApiKey = "QrAsWzkoP77e7ELiYFsRIVCx8MTvYTWA";
        return new MailosaurClient(mailosaurApiKey);
    }

}
