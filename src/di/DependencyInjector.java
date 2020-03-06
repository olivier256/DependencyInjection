package di;

import java.util.ArrayList;
import java.util.List;

import di.post.MockPostService;
import di.post.PostService;
import di.user.MockUserService;
import di.user.UserService;

public class DependencyInjector {
	private List<Injector> injectors;

	private List<Object> registeredInstances;

	private UserService userService;

	private PostService postService;

	public DependencyInjector() {
		injectors = new ArrayList<>();
		registeredInstances = new ArrayList<>();
		userService = new MockUserService();
		postService = new MockPostService();
	}

	public void addInjector(Injector injector) {
		injectors.add(injector);
	}

	public void register(Object instance) {
		registeredInstances.add(instance);
	}

	public void inject() {
		for (Injector injector : injectors) {
			injector.inject();
		}
	}

	public List<Object> getRegisteredInstances() {
		return registeredInstances;
	}

	public UserService getUserService() {
		return userService;
	}

	public PostService getPostService() {
		return postService;
	}

}
