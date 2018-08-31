package com.king.gen.utils;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 类PageUtils的功能描述:
 * 分页工具类
 * @auther king
 * @date 2017-08-25 16:12:59
 */
public class PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	//总记录数
	private int totalCount;
	//每页记录数
	private int pageSize;
	//总页数
	private int totalPage;
	//当前页数
	private int currPage;
	//列表数据
	private List<?> list;
	
	/**
	 * 分页
	 * @param list        列表数据
	 * @param totalCount  总记录数
	 * @param pageSize    每页记录数
	 * @param currPage    当前页数
	 */
	public PageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
		this.list = list;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currPage = currPage;
		this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
	}
	
	public PageUtils() {
	this(null,0,10,1);
	}

	public PageUtils(Map<String, Object> params){
		this();
		this.handleCurrPageStr(params.get("page") == null ? "1" : params.get("page").toString());
		this.handlePageSizeStr(params.get("limit") == null ? "10" : params.get("limit").toString());
	}
	

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPage = (totalCount - 1)/pageSize + 1; 
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
	public int getOffset() {
		return (currPage-1)*pageSize;
	}
	
	public int getLimit() {
		return pageSize;
	}

	public void handlePageSizeStr(String pageSizeStr){

		if (org.apache.commons.lang3.StringUtils.isNotBlank(pageSizeStr)) {
			try {
				int pageSize = Integer.parseInt(pageSizeStr);
				this.setPageSize( pageSize > 1 ? pageSize : 10);
			} catch (NumberFormatException e) {
				//忽略此错误，使用默认值
				this.setPageSize(10);
			}
		}
	}

	public void handleCurrPageStr(String currPageStr){

		if (org.apache.commons.lang3.StringUtils.isNotBlank(currPageStr)) {
			try {
				int currPage = Integer.parseInt(currPageStr);
				this.setCurrPage(currPage > 1 ? currPage : 1);
			} catch (NumberFormatException e) {
				//忽略此错误，使用默认值
				this.setCurrPage(1);
			}
		}
	}


}
