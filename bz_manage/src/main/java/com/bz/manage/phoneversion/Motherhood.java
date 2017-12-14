package com.bz.manage.phoneversion;

import java.io.Serializable;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:孕产/用品/儿童玩具实体类
 * 创建时间:2017年10月13日下午5:19:10
 * 修改备注:
 */
public class Motherhood implements Serializable{

	//id 广告图名称 广告图链接 广告图位置  广告图片 
		private Integer id;
		private String name;
		private String url;
		private String place;
		private String picture;
		private Integer isDelete;
		public Motherhood() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Motherhood(Integer id, String name, String url, String place, String picture,
				Integer isDelete) {
			super();
			this.id = id;
			this.name = name;
			this.url = url;
			this.place = place;
			this.picture = picture;
			this.isDelete = isDelete;
		}
		@Override
		public String toString() {
			return "MotherhoodAndChildrensToys [id=" + id + ", name=" + name + ", url=" + url + ", place=" + place
					+ ", picture=" + picture + ", isDelete=" + isDelete + "]";
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getPlace() {
			return place;
		}
		public void setPlace(String place) {
			this.place = place;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		public Integer getIsDelete() {
			return isDelete;
		}
		public void setIsDelete(Integer isDelete) {
			this.isDelete = isDelete;
		}
		
}
