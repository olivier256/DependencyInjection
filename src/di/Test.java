package di;

import di.post.MockPostService;
import di.post.PostServiceInjectable;
import di.post.PostServiceInjector;
import di.user.MockUserService;
import di.user.UserServiceInjectable;
import di.user.UserServiceInjector;

public class Test {

	public void test() {
		MaClasse maClasse = new MaClasse();
		MaClasse2 maClasse2 = new MaClasse2();
		DependencyInjector dependencyInjector = new DependencyInjector();

		// Annotation @Service
		dependencyInjector.addInjector(new UserServiceInjector(dependencyInjector), UserServiceInjectable.class);
		dependencyInjector.addInjector(new PostServiceInjector(dependencyInjector), PostServiceInjectable.class);

		// Annotation @Autowired
		dependencyInjector.register(maClasse);
		dependencyInjector.register(maClasse2);

		// Instanciation
		dependencyInjector.addRuntimeInstance(UserServiceInjectable.class, new MockUserService());
		dependencyInjector.addRuntimeInstance(PostServiceInjectable.class, new MockPostService());

		// Injection
		dependencyInjector.inject();

		maClasse.run();
		maClasse2.run();
	}

	public static void main(final String[] args) {
		new Test().test();
	}

}
