package mrigor87.votingsystem.web;

import mrigor87.votingsystem.matcher.ModelMatcher;
import mrigor87.votingsystem.model.Role;
import mrigor87.votingsystem.model.User;

/**
 * Created by Igor on 18.08.2016.
 */
public class UserTestData {
/*    INSERT INTO users (name, email, password)
    VALUES ('User', 'user@yandex.ru', 'password');

    INSERT INTO users (name, email, password)
    VALUES ('Admin', 'admin@gmail.com', 'admin');

    INSERT INTO user_roles (role, user_id) VALUES
    ('ROLE_USER',  100009),
            ('ROLE_ADMIN', 100010);
}*/
public static final ModelMatcher<User, String> MATCHER = new ModelMatcher<>(User::toString);

    public static final User USER=new User(100009,"User", "user@yandex.ru", "password", Role.ROLE_USER);
    public static final User ADMIN=new User(100010,"Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN);
    public static User getUpdated() {
        return new User(USER.getId(),  "update USER", "user@yandex.ru", "password", Role.ROLE_USER);
    }

}
