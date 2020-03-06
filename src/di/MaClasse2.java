package di;

import di.post.PostService;
import di.post.PostServiceInjectable;

public class MaClasse2 implements PostServiceInjectable {

	private PostService postService;

	@Override
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public void run() {
		System.out.print("MaClasse2 demande à afficher son postService: ");
		postService.doThat();
	}

}
