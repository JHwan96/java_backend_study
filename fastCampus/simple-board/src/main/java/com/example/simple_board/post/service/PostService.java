package com.example.simple_board.post.service;

import com.example.simple_board.board.db.BoardEntity;
import com.example.simple_board.board.db.BoardRepository;
import com.example.simple_board.common.Api;
import com.example.simple_board.common.Pagination;
import com.example.simple_board.post.db.PostEntity;
import com.example.simple_board.post.db.PostRepository;
import com.example.simple_board.post.model.PostRequest;
import com.example.simple_board.post.model.PostViewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostEntity create(PostRequest postRequest) {
        BoardEntity boardEntity = boardRepository.findById(postRequest.getBoardId()).get();

        PostEntity entity = PostEntity.builder()
                .board(boardEntity)
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

                    return x;
                }).orElseThrow(
                        () -> new RuntimeException("해당 게시글이 존재하지 않습니다.")
                );
    }

    public Api<List<PostEntity>> findAll(Pageable pageable) {
        Page<PostEntity> list = postRepository.findAll(pageable);
        Pagination pagination = Pagination.builder()
                .page(list.getNumber())
                .size(list.getSize())
                .currentElement(list.getNumberOfElements())
                .totalPage(list.getTotalPages())
                .totalElements(list.getTotalElements())
                .build();
        ;
        return Api.<List<PostEntity>>builder()
                .body(list.toList())
                .pagination(pagination)
                .build();
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
