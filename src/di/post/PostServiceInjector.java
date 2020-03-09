package di.post;

import di.DependencyInjector;
import di.Injectable;
import di.Injector;
import di.Service;

public class PostServiceInjector implements Injector {

	private DependencyInjector dependencyInjector;

	public PostServiceInjector(final DependencyInjector dependencyInjector) {
		this.dependencyInjector = dependencyInjector;
	}

	@Override
	public void inject(final Service postService) {
		for (Injectable injectable : dependencyInjector.getInstancesByClass(PostServiceInjectable.class)) {
			if (injectable instanceof PostServiceInjectable) {
				((PostServiceInjectable) injectable).setPostService((PostService) postService);
			}
		}
	}

}
