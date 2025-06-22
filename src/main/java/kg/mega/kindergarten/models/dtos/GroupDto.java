package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.models.AgeGroup;
import kg.mega.kindergarten.models.Teacher;

public record GroupDto (
     Long id,
     Teacher teacher,
     String name,
     AgeGroup ageGroup
)
    {

}
