package com.zr.bazar.Model;

public class ScreenItem{
  String title, des;
  int img;

  public ScreenItem(String title, String des, int img){
    this.title=title;
    this.des=des;
    this.img=img;
  }

  public String getTitle(){
    return title;
  }

  public void setTitle(String title){
    this.title=title;
  }

  public String getDes(){
    return des;
  }

  public void setDes(String des){
    this.des=des;
  }

  public int getImg(){
    return img;
  }

  public void setImg(int img){
    this.img=img;
  }
}
