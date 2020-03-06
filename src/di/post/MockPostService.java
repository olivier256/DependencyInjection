package di.post;

public class MockPostService implements PostService {

	@Override
	public void doThat() {
		System.out.println("MockPostService does that");
	}

}
