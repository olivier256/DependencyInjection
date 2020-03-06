package di;

import di.post.PostService;
import di.post.PostServiceInjectable;
import di.user.UserService;
import di.user.UserServiceInjectable;

public class MaClasse implements UserServiceInjectable, PostServiceInjectable {

	private UserService userService;
	private PostService postService;

	@Override
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public void run() {
		userService.doThis();
		postService.doThat();
	}

}
