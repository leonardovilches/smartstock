package com.lv.smartstock.controllers.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StardardError implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long timeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
}
