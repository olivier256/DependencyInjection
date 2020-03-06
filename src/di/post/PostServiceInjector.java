package di.post;

import di.DependencyInjector;
import di.Injector;

public class PostServiceInjector implements Injector {

	private DependencyInjector dependencyInjector;

	public PostServiceInjector(DependencyInjector dependencyInjector) {
		this.dependencyInjector = dependencyInjector;
	}

	@Override
	public void inject() {
		for (Object instance : dependencyInjector.getRegisteredInstancesByClass(PostServiceInjectable.class)) {
			((PostServiceInjectable) instance).setPostService(dependencyInjector.getPostService());
		}
	}

}
