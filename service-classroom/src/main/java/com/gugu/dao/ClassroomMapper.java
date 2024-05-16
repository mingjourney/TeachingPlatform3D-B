package com.gugu.dao;

import com.gugu.dto.ClassroomDTO;
import com.gugu.entity.Classroom;
import com.gugu.entity.CourseHistory;
import org.apache.ibatis.annotations.Mapper;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gugu
 * @create 2023-04-24 11:07
 * @purpose
 */
@Mapper
public interface ClassroomMapper {

    int classroomTotal();
    ArrayList<Classroom> getClassroomList(Integer offset, Integer pageSize);
    Classroom getClassroomDetailById(Integer id);

    int addClassroom(ClassroomDTO classroom);

    List<CourseHistory> getUserCourseHistory(Integer id);
}
