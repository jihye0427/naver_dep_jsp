/*visual 이미지 슬라이드 처리*/

/*1. 이미지 세팅*/
$(function(){
	/* 브라우저가 처음 로딩시 화면사이즈를 ul사이즈로 적용 */
	$("#visual #area ul").css("width", $(document).width()+"px");
	
	/* 브라우저 사이즈가 바뀌면 다시 사이즈 세팅 */
	$(window).resize(function(){
		$("#visual #area ul").css("width", $(document).width()+"px");
	});
	
	//start();
	//$(selector).hover(inFunction,outFunction)
	$("#visual").hover(function(){
		/*마우스가 올라가면 setInterval stop*/
		clearInterval(myVar);
	},function(){
		/*마우스가 빠져나가면 setInterval 시작*/
		start();
	})
});


/*설정한 time마다 계속 함수 실행*/
var time=5000;
var myVar;
function start(){
	myVar=setInterval(function(){ 
		rightMove(); 
	}, time);
}


function rightMove(){
	var win_width=$(document).width();
	
	var first=$("#visual #area ul:first-child");
	var last=$("#visual #area ul:last-child");
	/*이미지 왼쪽으로 이동*/
	//$(selector).animate({params},speed,callback);
	$("#visual #area").animate({"left": -win_width}, 1000 ,function(){
		//첫번째있는 ul태그를 제일 뒤로 이동
		$(first).insertAfter(last);
		$("#visual #area").css("left",0);	
	});
	
}

function leftMove(){
	var first=$("#visual #area ul:first-child");
	var last=$("#visual #area ul:last-child");
	var win_width=$(document).width();
	//왼쪽에 이미지가 없으니깐 먼저 마지막 이미지를 앞으로 이동시킵니다.
	$(last).insertBefore(first);
	$("#visual #area").css("left",-win_width);
	
	/*이미지 오른쪽 이동*/
	//$(selector).animate({params},speed,callback);
	$("#visual #area").animate({"left": 0}, 1000 );
	
}

/*윈도우 최소화시에 슬라이드 스톱*/
/*
$(window).blur(function(){
	clearInterval(myVar);
});
//*/
//*
window.addEventListener("blur", function(){
	clearInterval(myVar);
});
//*/

/*
window.addEventListener("focus", function(){
	start();
});
//*/

