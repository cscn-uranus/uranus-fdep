package com.cscn.uranus.fdep.processor.entity;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Flowcontrolmsg implements Serializable {
  //region Custom Blocks
  //region Custom Field
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;

  @Lob() private String domText;

  @CreationTimestamp
  @Column(updatable = false)
  private Date creationTime;

  @UpdateTimestamp
  private Date updateTime;
  //endregion Custom Field

  //region Getters and Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDomText() {
    return domText;
  }

  public void setDomText(String domText) {
    this.domText = domText;
  }
  //endregion Getters and Setters
  //endregion Custom Blocks

  //region equals and hashCode
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Flowcontrolmsg)) {
      return false;
    }
    Flowcontrolmsg that = (Flowcontrolmsg) o;
    return Objects.equal(id, that.id) && Objects.equal(domText, that.domText);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, domText);
  }
  //endregion

  public Flowcontrolmsg() {}
}
