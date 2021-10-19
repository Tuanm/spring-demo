package model;

import java.time.LocalDate;

public class User {
    public String username;
    public String password;
    public String name;
    public String email;
    public LocalDate birthday;

    public User(Holder userHolder) {
        this.username = userHolder.username;
        this.password = userHolder.password;
        this.name = userHolder.name;
        this.email = userHolder.email;
        this.birthday = userHolder.birthday;
    }

    public static Holder prepare() {
        return new Holder();
    }

    public static class Holder {
        String username;
        String password;
        String name;
        String email;
        LocalDate birthday;

        private Holder() {}

        public Holder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Holder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Holder withName(String name) {
            this.name = name;
            return this;
        }

        public Holder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Holder withBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public Holder withBirthday(int year, int month, int dayOfMonth) {
            this.birthday = LocalDate.of(year, month, dayOfMonth);
            return this;
        }

        public User register() {
            return new User(this);
        }
    }
}
