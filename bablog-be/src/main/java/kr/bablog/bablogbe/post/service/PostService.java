package kr.bablog.bablogbe.post.service;

import kr.bablog.bablogbe.post.domain.Post;
import kr.bablog.bablogbe.post.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> getPostList(int offset, int limit) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.asc("title"));

        Pageable pageable = PageRequest.of(offset/limit, limit, Sort.by(sorts));
        return this.postRepository.findAll(pageable);

    }

    public Post getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.get();
    }

}
