package com.example.android.searchlist;

public class MiniEntity {

  private final Integer id;
  private final String name;

  public MiniEntity(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer id() {
    return id;
  }

  public String name() {
    return name;
  }

  public static MiniEntity create(Integer id, String name) {
    return new MiniEntity(id, name);
  }


}