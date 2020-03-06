package di.post;

import di.Injectable;

public interface PostServiceInjectable extends Injectable {

	void setPostService(PostService postService);

}
