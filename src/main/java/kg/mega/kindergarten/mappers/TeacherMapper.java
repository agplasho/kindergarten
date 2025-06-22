package kg.mega.kindergarten.mappers;

import kg.mega.kindergarten.models.Teacher;
import kg.mega.kindergarten.models.dtos.TeacherCreateDto;
import kg.mega.kindergarten.models.dtos.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher teacherCreateDtoToTeacher(TeacherCreateDto teacherCreateDto);


    TeacherDto teacherToTeacherDto(Teacher teacher);

    Teacher teacherDtoToTeacher(TeacherDto teacherDto);


}
