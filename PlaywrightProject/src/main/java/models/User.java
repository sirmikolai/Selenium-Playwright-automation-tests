package models;

import models.enums.UserGroup;

import static core.mailosaur.MailosaurServerManager.generateEmailAddress;
import static models.generators.PasswordGenerator.generatePassword;

public class User {

    private String email;
    private String password;
    private UserGroup userGroup;

    private User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.userGroup = UserGroup.USER;
    }

    public User(String email, String password, UserGroup userGroup) {
        this.email = email;
        this.password = password;
        this.userGroup = userGroup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public static final class UserBuilder {
        private String email;
        private String password;
        private UserGroup userGroup;

        public UserBuilder(UserGroup... userGroup) {
            if (userGroup[0] == UserGroup.ADMIN) {
                this.email = "lobinak823@snowlash.com";
                this.password = "test";
                this.userGroup = UserGroup.ADMIN;
            } else {
                this.email = "xilax42376@fectode.com";
                this.password = "test";
                this.userGroup = UserGroup.USER;
            }
        }

        public UserBuilder() {
            this.email = generateEmailAddress();
            this.password = generatePassword(10);
            this.userGroup = UserGroup.USER;
        }

        public UserBuilder withPassword(int length) {
            this.password = generatePassword(length);
            return this;
        }

        public UserBuilder withUserGroup(UserGroup userGroup) {
            this.userGroup = userGroup;
            return this;
        }

        public User build() {
            return new User(this.email, this.password, this.userGroup);
        }
    }
}
