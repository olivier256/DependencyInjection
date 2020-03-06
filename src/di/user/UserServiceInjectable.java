package di.user;

import di.Injectable;

public interface UserServiceInjectable extends Injectable {

	void setUserService(UserService userService);

}
