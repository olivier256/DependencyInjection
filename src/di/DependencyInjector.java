package di;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import di.post.MockPostService;
import di.post.PostService;
import di.post.PostServiceInjectable;
import di.user.MockUserService;
import di.user.UserService;
import di.user.UserServiceInjectable;

public class DependencyInjector {
	private List<Injector> injectors;

	private Map<Class<? extends Injectable>, List<? extends Injectable>> registeredInstancesByClass;

	private UserService userService;

	private PostService postService;

	public DependencyInjector() {
		injectors = new ArrayList<>();
		registeredInstancesByClass = new HashMap<>();
		userService = new MockUserService();
		postService = new MockPostService();
	}

	public void addInjector(Injector injector) {
		injectors.add(injector);
	}

	public void register(Object instance) {
		for (Class<?> _interface : instance.getClass().getInterfaces()) {
			if (_interface.equals(UserServiceInjectable.class)) {
				registerToUserServiceInjection(instance);
			}

			if (_interface.equals(PostServiceInjectable.class)) {
				registerToPostServiceInjection(instance);
			}
		}
	}

	private void registerToUserServiceInjection(Object instance) {
		Class<UserServiceInjectable> userServiceInjectableClass = UserServiceInjectable.class;
		List<UserServiceInjectable> list = (List<UserServiceInjectable>) registeredInstancesByClass
				.get(userServiceInjectableClass);
		if (list == null) {
			list = new ArrayList<>();
			registeredInstancesByClass.put(userServiceInjectableClass, list);
		}
		list.add((UserServiceInjectable) instance);
	}

	private void registerToPostServiceInjection(Object instance) {
		Class<PostServiceInjectable> postServiceInjectableClass = PostServiceInjectable.class;
		List<PostServiceInjectable> list = (List<PostServiceInjectable>) registeredInstancesByClass
				.get(postServiceInjectableClass);
		if (list == null) {
			list = new ArrayList<>();
			registeredInstancesByClass.put(postServiceInjectableClass, list);
		}
		list.add((PostServiceInjectable) instance);
	}

	public void inject() {
		for (Injector injector : injectors) {
			injector.inject();
		}
	}

	public List<? extends Injectable> getRegisteredInstancesByClass(Class<? extends Injectable> _class) {
		return registeredInstancesByClass.get(_class);
	}

	public UserService getUserService() {
		return userService;
	}

	public PostService getPostService() {
		return postService;
	}

}
