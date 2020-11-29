package org.as.devtechsolution.user.vo;

import org.as.devtechsolution.user.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTemplateVO {

	private UserDto user;
	private Department department;
}