package di.user;

import di.DependencyInjector;
import di.Injector;

public class UserServiceInjector implements Injector {

	private DependencyInjector dependencyInjector;

	public UserServiceInjector(DependencyInjector dependencyInjector) {
		this.dependencyInjector = dependencyInjector;
	}

	@Override
	public void inject() {
		for (Object instance : dependencyInjector.getRegisteredInstancesByClass(UserServiceInjectable.class)) {
			if (instance instanceof UserServiceInjectable) {
				((UserServiceInjectable) instance).setUserService(dependencyInjector.getUserService());
			}
		}
	}

}
