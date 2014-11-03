package com.hx.dmcp.store.springmongodb.common;

import java.util.List;

/**
 * @author krisjin
 * @date 2014-11-3
 */
public class Pagination<T> {

	/**
	 *每一页的记录数, 默认为15
	 */
	private int pageSize = 15;
	/**
	 * 当前页码
	 */
	private int currentPageNo;

	/**
	 * 上一页
	 */
	private int upPage;

	/**
	 * 下一页
	 */
	private int nextPage;
	/**
	 * 一共有多少条数据
	 */
	private long totalCount;

	/**
	 * 一共有多少页
	 */
	private int totalPage;
	/**
	 * 数据集合
	 */
	private List<T> dataSet;

	/**
	 * 分页的url
	 */
	private String pageUrl;

	/**
	 * 获取第一条记录位置
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (this.getCurrentPageNo() - 1) * this.getPageSize();
	}

	/**
	 * 获取最后记录位置
	 * 
	 * @return
	 */
	public int getLastResult() {
		return this.getCurrentPageNo() * this.getPageSize();
	}

	/**
	 * 计算一共多少页
	 */
	public void setTotalPage() {
		this.totalPage = (int) ((this.totalCount % this.pageSize > 0) ? (this.totalCount / this.pageSize + 1) : this.totalCount
				/ this.pageSize);
	}

	/**
	 * 设置 上一页
	 */
	public void setUpPage() {
		this.upPage = (this.currentPageNo > 1) ? this.currentPageNo - 1 : this.currentPageNo;
	}

	/**
	 * 设置下一页
	 */
	public void setNextPage() {
		this.nextPage = (this.currentPageNo == this.totalPage) ? this.currentPageNo : this.currentPageNo + 1;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getUpPage() {
		return upPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	

	public List<T> getDataSet() {
		return dataSet;
	}

	public void setDataSet(List<T> dataSet) {
		this.dataSet = dataSet;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public Pagination(int currentPageNo, int pageSize, long totalCount) {
		this.setCurrentPageNo(currentPageNo);
		this.setPageSize(pageSize);
		this.setTotalCount(totalCount);
		this.init();
	}

	/**
	 * 初始化计算分页
	 */
	private void init() {
		this.setTotalPage();// 设置一共页数
		this.setUpPage();// 设置上一页
		this.setNextPage();// 设置下一页
	}
}
