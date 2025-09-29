package builders;

import dto.PostDto;
import models.Post;

public class PostBuilder {
    public static Post construirPost(PostDto dto) {
        return new Post(dto.getId(), dto.getUserId(), dto.getTitle(), dto.getBody());
    }
}
