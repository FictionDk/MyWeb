package cn.fictio.myweb.domain;

import java.util.List;

//分页显示
public class CommentPage {
	//总评论数
	private int sumComments;
	//当前页
	private int currPage;
	//每页多少项
	private int currPageNum=3;
	//一共多少页
	private int allPageNum;
	//每页显示的comments
	private List<Comments> commentPageList;
	public CommentPage(){}
	/**
	 * @return the sumComments
	 */
	public int getSumComments() {
		return sumComments;
	}
	/**
	 * @param sumComments the sumComments to set
	 */
	public void setSumComments(int sumComments) {
		this.sumComments = sumComments;
		if(this.sumComments%currPageNum==0){
			this.allPageNum=this.sumComments/this.currPageNum;
		}else{
			this.allPageNum=(this.sumComments/this.currPageNum)+1;
		}	
	}
	/**
	 * @return the currPage
	 */
	public int getCurrPage() {
		return currPage;
	}
	/**
	 * @param currPage the currPage to set
	 */
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	/**
	 * @return the currPageNum
	 */
	public int getCurrPageNum() {
		return currPageNum;
	}
	/**
	 * @param currPageNum the currPageNum to set
	 */
	public void setCurrPageNum(int currPageNum) {
		this.currPageNum = currPageNum;
	}
	/**
	 * @return the allPageNum
	 */
	public int getAllPageNum() {
		return allPageNum;
	}
	/**
	 * @param allPageNum the allPageNum to set
	 */
	public void setAllPageNum(int allPageNum) {
		this.allPageNum = allPageNum;
	}
	/**
	 * @return the commentPageList
	 */
	public List<Comments> getCommentPageList() {
		return commentPageList;
	}
	/**
	 * @param commentPageList the commentPageList to set
	 */
	public void setCommentPageList(List<Comments> commentPageList) {
		this.commentPageList = commentPageList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CommentPage [sumComments=" + sumComments + ", currPage="
				+ currPage + ", currPageNum=" + currPageNum + ", allPageNum="
				+ allPageNum + ", commentPageList=" + commentPageList + "]";
	}

	
}
