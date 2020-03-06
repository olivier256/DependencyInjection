package di;

import di.post.PostServiceInjector;
import di.user.UserServiceInjector;

public class Test {

	public void test() {
		MaClasse maClasse = new MaClasse();
		MaClasse2 maClasse2 = new MaClasse2();
		DependencyInjector dependencyInjector = new DependencyInjector();
		dependencyInjector.addInjector(new UserServiceInjector(dependencyInjector));
		dependencyInjector.addInjector(new PostServiceInjector(dependencyInjector));
		dependencyInjector.register(maClasse);
		dependencyInjector.register(maClasse2);
		dependencyInjector.inject();
		maClasse.run();
		maClasse2.run();
	}

	public static void main(String[] args) {
		new Test().test();
	}

}
