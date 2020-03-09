package di.user;

import di.DependencyInjector;
import di.Injectable;
import di.Injector;
import di.Service;

public class UserServiceInjector implements Injector {

	private final DependencyInjector dependencyInjector;

	public UserServiceInjector(final DependencyInjector dependencyInjector) {
		this.dependencyInjector = dependencyInjector;
	}

	@Override
	public void inject(final Service userService) {
		for (Injectable injectable : dependencyInjector.getInstancesByClass(UserServiceInjectable.class)) {
			if (injectable instanceof UserServiceInjectable) {
				((UserServiceInjectable) injectable).setUserService((UserService) userService);
			}
		}
	}

}
