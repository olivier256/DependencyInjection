package di.user;

public class MockUserService implements UserService {

	@Override
	public void doThis() {
		System.out.println("MockUserService does this (@" + Integer.toHexString(hashCode()) + ")");
	}

}
