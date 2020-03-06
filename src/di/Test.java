package di;

public class Test {

	public void test() {
		MaClasse maClasse = new MaClasse();
		MaClasse2 maClasse2 = new MaClasse2();
		DependencyInjector dependencyInjector = new DependencyInjector();
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
