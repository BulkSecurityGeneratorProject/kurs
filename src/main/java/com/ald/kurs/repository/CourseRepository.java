package com.ald.kurs.repository;

import com.ald.kurs.domain.Course;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Spring Data JPA repository for the Course entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    
    @Query("select distinct course from Course course left join fetch course.lessons")
    List<Course> findAllWithEagerRelationships();

    @Query("select course from Course course left join fetch course.lessons where course.id =:id")
    Course findOneWithEagerRelationships(@Param("id") Long id);
    
}
