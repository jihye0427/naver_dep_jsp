package vo;

public class PageInfo {

	private int pageNo;
	private int pageTotal;
	private int pageEnd;
	private int pageStart;
	
	public int getPageNo() {
		return pageNo;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public int getPageStart() {
		return pageStart;
	}
	public PageInfo(int pageNo, int rowTotal, int limit) {
		//한페이지에 보열줄 페이지번호 최대개수
		int pageBlock=3;
		this.pageNo=pageNo;
		
		//총페이지수 계산
		pageTotal=rowTotal/limit;
		if(rowTotal%limit > 0) {
			pageTotal++;
		}
		
		//페이지번호를 이용해서 페이지블럭번호계산
		int blockNo=pageNo/pageBlock;
		if(pageNo%pageBlock > 0) {//1,2==0 -->1, 3==1
			blockNo++;
		}
		
		//블럭번호를 이용해서 표현한 페이지 시작 끝 번호 계산
		pageEnd=blockNo*pageBlock;
		pageStart=pageEnd-pageBlock+1;
		//마지막페이지 pageEnd체크
		if(pageEnd > pageTotal) {
			pageEnd=pageTotal;
		}
		
		
	}
	
	

}
