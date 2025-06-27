package kg.mega.kindergarten.mappers;

import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.ChildGroupHistory;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.dtos.ChildGroupHistoryCreateDto;
import kg.mega.kindergarten.models.dtos.ChildGroupHistoryDto;
import kg.mega.kindergarten.models.dtos.ChildGroupHistoryUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChildGroupHistoryMapper {


    ChildGroupHistoryMapper INSTANCE = Mappers.getMapper(ChildGroupHistoryMapper.class);


    @Mapping(source = "child", target = "child")
    @Mapping(source = "group", target = "group")
    @Mapping(target = "id", ignore = true)
    ChildGroupHistory childGroupHistoryCreateDtoToChildGroupHistory(ChildGroupHistoryCreateDto childGroupHistoryCreateDto, Child child, Group group);

    ChildGroupHistoryDto childGroupHistoryToChildGroupHistoryDto(ChildGroupHistory childGroupHistory);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "group", target = "group")
    @Mapping(source = "child", target = "child")
    ChildGroupHistory childGroupHistoryUpdateDtoToChildGroupHistory(ChildGroupHistoryUpdateDto childGroupHistoryUpdateDto, Child child, Group group);

    List<ChildGroupHistoryDto> childGroupHistoryToChildGroupHistoryDtoList(List<ChildGroupHistory> childGroupHistoryList);
}