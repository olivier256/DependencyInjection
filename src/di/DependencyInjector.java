package di;

import java.util.ArrayList;
import java.util.List;

import di.post.MockPostService;
import di.post.PostService;
import di.post.PostServiceInjectable;
import di.user.MockUserService;
import di.user.UserService;
import di.user.UserServiceInjectable;

public class DependencyInjector {
	private List<Object> registeredInstances;
	private UserService userService;
	private PostService postService;

	public DependencyInjector() {
		registeredInstances = new ArrayList<>();
		userService = new MockUserService();
		postService = new MockPostService();
	}

	public void register(Object instance) {
		registeredInstances.add(instance);
	}

	public void inject() {
		injectUserService();
		injectPostService();
	}

	public void injectUserService() {
		for (Object instance : registeredInstances) {
			if (instance instanceof UserServiceInjectable) {
				((UserServiceInjectable) instance).setUserService(userService);
			}
		}
	}

	public void injectPostService() {
		for (Object instance : registeredInstances) {
			if (instance instanceof PostServiceInjectable) {
				((PostServiceInjectable) instance).setPostService(postService);
			}
		}
	}

}
