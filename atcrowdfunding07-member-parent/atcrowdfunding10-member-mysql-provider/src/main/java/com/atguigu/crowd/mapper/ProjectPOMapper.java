package com.atguigu.crowd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.atguigu.crowd.entity.po.ProjectPO;
import com.atguigu.crowd.entity.po.ProjectPOExample;

public interface ProjectPOMapper {
    int countByExample(ProjectPOExample example);

    int deleteByExample(ProjectPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPO record);

    int insertSelective(ProjectPO record);

    List<ProjectPO> selectByExample(ProjectPOExample example);

    ProjectPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByExample(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByPrimaryKeySelective(ProjectPO record);

    int updateByPrimaryKey(ProjectPO record);
    
    void insertTypeRelationship(
			@Param("typeIdList") List<Integer> typeIdList, 
			@Param("projectId") Integer projectId);

	void insertTagRelationship(
			@Param("tagIdList") List<Integer> tagIdList, 
			@Param("projectId") Integer projectId);
}