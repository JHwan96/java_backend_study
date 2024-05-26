package com.example.simple_board.post.service;

import com.example.simple_board.post.db.PostEntity;
import com.example.simple_board.post.db.PostRepository;
import com.example.simple_board.post.model.PostRequest;
import com.example.simple_board.post.model.PostViewRequest;
import com.example.simple_board.reply.db.ReplyEntity;
import com.example.simple_board.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ReplyService replyService;

    public PostEntity create(PostRequest postRequest) {
        PostEntity entity = PostEntity.builder()
                .boardId(1L)
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .status("REGISTERED")
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .postedAt(LocalDateTime.now())
                .build();
        return postRepository.save(entity);
    }

    public PostEntity view(PostViewRequest postViewRequest) {

        Optional<PostEntity> findPost = postRepository.findByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(), "REGISTERED");
        return findPost
                .map(x -> {
                    if (!x.getPassword().equals(postViewRequest.getPassword())) {
                        String format = "패스워드가 맞지 않습니다. %s vs %s";
                        throw new RuntimeException(String.format(format, x.getPassword(), postViewRequest.getPassword()));
                    }
                    List<ReplyEntity> replyList = replyService.findAllByPostId(x.getId());
                    x.setReplyList(replyList);

                    return x;
                }).orElseThrow(
                        () -> new RuntimeException("해당 게시글이 존재하지 않습니다.")
                );
    }

    public List<PostEntity> all() {
        return postRepository.findAll();
    }

    public void delete(PostViewRequest postViewRequest){
        postRepository.findById(postViewRequest.getPostId())
                .map(x -> {
                    if (!x.getPassword().equals(postViewRequest.getPassword())){
                        String format = "패스워드가 맞지 않습니다. %s vs %s";
                        throw new RuntimeException(String.format(format, x.getPassword(), postViewRequest.getPassword()));
                    }
                    x.setStatus("UNREGISTERED");
                    postRepository.save(x);
                    return x;
                }).orElseThrow(
                        () -> new RuntimeException("해당 게시글이 존재하지 않습니다.")
                );
    }
}
