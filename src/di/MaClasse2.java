package di;

import di.post.PostService;
import di.post.PostServiceInjectable;

public class MaClasse2 implements PostServiceInjectable {

	private PostService postService;

	public void run() {
		postService.doThat();
	}

	@Override
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
}
