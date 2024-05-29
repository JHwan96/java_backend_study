package com.example.simple_board.crud;

import com.example.simple_board.common.Api;
import com.example.simple_board.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * dto -> entity -> dto
 */
public abstract class CRUDAbstractService<DTO, ENTITY> implements CRUDInterface<DTO>{
    @Autowired(required = false)
    private Converter<DTO, ENTITY> converter;
    @Autowired(required = false)
    private JpaRepository<ENTITY, Long> jpaRepository;

    @Override
    public DTO create(DTO dto) {
        // dto -> entity
        ENTITY entity = converter.toEntity(dto);

        // entity -> save
        jpaRepository.save(entity);

        // save -> dto
        return converter.toDto(entity);
    }

    @Override
    public Optional<DTO> read(Long id) {
        Optional<ENTITY> optionalEntity = jpaRepository.findById(id);

        DTO dto = optionalEntity.map(x ->
            converter.toDto(x)
        ).orElseGet(null);

        return Optional.ofNullable(dto);
    }

    @Override
    public DTO update(DTO dto) {
        ENTITY entity = converter.toEntity(dto);
        jpaRepository.save(entity);
        return converter.toDto(entity);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Api<List<DTO>> list(Pageable pageable) {
        Page<ENTITY> page = jpaRepository.findAll(pageable);
        Pagination pagination = Pagination.builder()
                .page(page.getNumber())
                .size(page.getSize())
                .currentElement(page.getNumberOfElements())
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .build();

        List<DTO> dtoList =  page.stream()
                .map(x -> converter.toDto(x))
                .collect(Collectors.toList());

        return Api.<List<DTO>>builder()
                .body(dtoList)
                .pagination(pagination)
                .build();

    }
}
