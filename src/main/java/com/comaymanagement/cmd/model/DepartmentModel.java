package com.comaymanagement.cmd.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class DepartmentModel {
	private Integer id;
	private String code;
	private String name;
	private Integer fatherDepartmentId;
	private Integer headPosition;
	private String description;
	private Integer level;
	private List<PositionModel> positions;
	private List<EmployeeModel> employees;
	private PositionModel position;
	private List<DepartmentHasDeviceModel> devices;
	
}
