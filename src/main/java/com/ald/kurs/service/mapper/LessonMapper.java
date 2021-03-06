package com.ald.kurs.service.mapper;

import com.ald.kurs.domain.*;
import com.ald.kurs.service.dto.LessonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Lesson and its DTO LessonDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface LessonMapper extends EntityMapper <LessonDTO, Lesson> {
    
    @Mapping(target = "resources", ignore = true)
    @Mapping(target = "courses", ignore = true)
    Lesson toEntity(LessonDTO lessonDTO); 
    default Lesson fromId(Long id) {
        if (id == null) {
            return null;
        }
        Lesson lesson = new Lesson();
        lesson.setId(id);
        return lesson;
    }
}
