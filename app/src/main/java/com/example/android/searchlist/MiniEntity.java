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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    MiniEntity that = (MiniEntity) o;

    if (!id.equals(that.id)) {
      return false;
    }
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    return result;
  }
}