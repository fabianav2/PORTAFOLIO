/**
 * Se implementará jquery con ajax
 */

 $(document).ready(function(){
	 $("#form-login").submit(function(event){
		 event.preventDefault();
		 authUser();		 
	 });
});



 function authUser(){
	let userName = $("#username").val();
	let passWord = $("#password").val();
	 
	$.ajax({
		type: "POST",
		dataType: "html",
		url: "./Ingreso",
		data: $.param({
			username: userName,
			password: passWord
		}),
		success: function(result){
			let parsedResult = JSON.parse(result);
			console.log(parsedResult)
			//* retornat false
			if(parsedResult!=false){
				let username=parsedResult['username']
				document.location.href = "inicio.jsp?username="+username;
			}
		}
	});
 }
