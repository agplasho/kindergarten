package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.models.AgeGroup;
import kg.mega.kindergarten.models.Teacher;

public record GroupCreateDto(
     String name,
     AgeGroup ageGroup,
     double price,
    Teacher teacherId
    ){

}

