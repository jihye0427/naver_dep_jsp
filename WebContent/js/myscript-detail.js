/**
 * detail.jsp 스트립트 소스
 * 작성자 : 조재청
 * 작성일 : 2020.07.10
 */
var content;
var board_no;
var writer;
var sort="no";
///////////////////////////
$(function(){
	$("#edit").hide();
	getReply();
	/*추천등록*/
	//최근댓글순 정렬////////////////////////
	$("#btn-recent").click(function(){
		sort="no";
		getReply();
	});
	////////////////////////////////////
	//추천많은 댓글순 정렬/////////////////////
	$("#btn-recom").click(function(){
		sort="recommend";
		getReply();
	});
	////////////////////////////////////
	/*댓글등록*/
	$("#btn-reply").click(function(){
		content=$("#reply-in").val().trim();
		board_no=$("#board_no").val();
		writer=$("#log-id").val();
		if(content!=""){
			addReply();
		}else{
			alert("댓글이 내용이 없습니다.");
		}
	});
	///////////////////////
	/*댓글입력 클릭시 로그인 체크*/
	$("#reply-in").click(function(){
		var id=$("#log-id").val();
		if(id==""){
			var r=confirm("로그인이 필요합니다.로그인 페이지로 이동하시겠습니까?");
			if(r){
				/*로그인페이지이동*/
				location.href="loginPage.me";
			}
		}else{
			$("#reply-in").removeAttr("readonly");
			$("#btn-reply").show();
		}
	});
	///////////////////////////
	
	
	
});
//////////////////////////////

function getReply(){
	board_no=$("#board_no").val();
	
	$.ajax({
		url:"getReply.bo",
		type: "post",
		data:{
			"board_no" : board_no,
			"sort": sort},
		success:function(result){
			$("#out").html(result);
		}
	});
	
}
function addReply(){
	$.ajax({
		url:"addReply.bo",
		type: "post",
		data: {
			"content" : content,
			"board_no" : board_no,
			"writer" : writer },
		success: function(){
			getReply();//목록 불러오기
			$("#reply-in").val("");
			
		}
		
	});
}

function recom(no){
	$.ajax({
		url:"incRecommend.bo?no="+no,
		success:function(){
			//화면에서 댓글만 리로딩
			getReply();//목록 불러오기
		}
		
	});
}

function btn_edit_click(){
	$("#detail").hide();
	$("#btn").hide();
	$("#edit").show();
}