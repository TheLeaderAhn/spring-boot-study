package io.ahnjy.guestbook.service;

import io.ahnjy.guestbook.dto.GuestbookDTO;
import io.ahnjy.guestbook.dto.PageRequestDTO;
import io.ahnjy.guestbook.dto.PageResultDTO;
import io.ahnjy.guestbook.entity.Guestbook;
import io.ahnjy.guestbook.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * description    :
 * packageName    : io.ahnjy.guestbook.service
 * fileName       : GuestbookServiceImpl
 * author         : ahnjy
 * date           : 2022/10/01
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/01        ahnjy       최초 생성
 */
@Service
@Log4j2
@RequiredArgsConstructor  // 의존성 자동주입
public class GuestbookServiceImpl implements GuestbookService {

    private  final GuestbookRepository repository;

    @Override
    public Long register(GuestbookDTO dto) {

        log.info("DTO ::::::::::::::::");
        log.info(dto);

        Guestbook entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);


        return entity.getGno();
    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPagealbe(Sort.by("gno").descending());

        Page<Guestbook> result = repository.findAll(pageable);

        Function<Guestbook, GuestbookDTO> fn  = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result,fn);
    }




}
