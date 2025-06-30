package kg.mega.kindergarten.services.impl;

import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.mappers.ChildGroupHistoryMapper;
import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.ChildGroupHistory;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.dtos.ChildGroupHistoryCreateDto;
import kg.mega.kindergarten.models.dtos.ChildGroupHistoryDto;
import kg.mega.kindergarten.models.dtos.ChildGroupHistoryUpdateDto;
import kg.mega.kindergarten.repositories.ChildGroupHistoryRepo;
import kg.mega.kindergarten.services.ChildGroupHistoryService;
import kg.mega.kindergarten.services.ChildService;
import kg.mega.kindergarten.services.GroupService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ChildGroupHistoryServiceImpl implements ChildGroupHistoryService {


    private final ChildGroupHistoryRepo childGroupHistoryRepo;
    private final ChildService childService;
    private final GroupService groupService;

    public ChildGroupHistoryServiceImpl(ChildGroupHistoryRepo childGroupHistoryRepo, ChildService childService, GroupService groupService) {
        this.childGroupHistoryRepo = childGroupHistoryRepo;
        this.childService = childService;
        this.groupService = groupService;
    }

    @Override
    public ChildGroupHistoryDto create(ChildGroupHistoryCreateDto childGroupHistoryCreateDto) {
        Child child = childService.findById (childGroupHistoryCreateDto.child());
        Group group = groupService.findById (childGroupHistoryCreateDto.group());
        ChildGroupHistory childGroupHistory = ChildGroupHistoryMapper.INSTANCE.childGroupHistoryCreateDtoToChildGroupHistory(childGroupHistoryCreateDto,child,group);
        childGroupHistory = childGroupHistoryRepo.save(childGroupHistory);
        return ChildGroupHistoryMapper.INSTANCE.childGroupHistoryToChildGroupHistoryDto(childGroupHistory);
    }

    @Override
    public ChildGroupHistoryDto update(Long id, ChildGroupHistoryUpdateDto updatedDto) {
        Child child = childService.findById (updatedDto.child());
        Group group = groupService.findById (updatedDto.group());
        ChildGroupHistory childGroupHistory = childGroupHistoryRepo.findById(id).orElse(null);
        childGroupHistory = ChildGroupHistoryMapper.INSTANCE.childGroupHistoryUpdateDtoToChildGroupHistory(updatedDto, child,group);
        childGroupHistory = childGroupHistoryRepo.save(childGroupHistory);
        return ChildGroupHistoryMapper.INSTANCE.childGroupHistoryToChildGroupHistoryDto(childGroupHistory);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        childGroupHistoryRepo.deleteById (id);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<ChildGroupHistoryDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of (page, size);
        List<ChildGroupHistory> childGroupHistories = childGroupHistoryRepo.findAll(pageable).stream().toList();
        return ChildGroupHistoryMapper.INSTANCE.childGroupHistoryToChildGroupHistoryDtoList(childGroupHistories) ;
    }

    @Override
    public ChildGroupHistoryDto findById(Long id) {
        ChildGroupHistory childGroupHistory = childGroupHistoryRepo.findById(id).orElseThrow(() -> new RuntimeException("История не найдена"));
        return ChildGroupHistoryMapper.INSTANCE.childGroupHistoryToChildGroupHistoryDto(childGroupHistory);
    }
}
