package com.broccoli.dto;


import java.util.List;

import com.broccoli.model.Role;

import lombok.Data;

@Data
public class UserResponseDTO {

  private Integer id;
  private String username;
  private String email;
  private List<Role> roles;

}