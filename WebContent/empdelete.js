function deletee(obj) {
	// alert(obj.id)
	var id = obj.id;
	$.ajax({
		type : 'GET',
		// dataType: 'json',
		data : {
			ide : id
		},
		contentType : 'application/json',
		url : 'DeleteEmployee',
		success : function(result) {
			alert(result);
			$("tr").remove("#" + id);
			document.getElementById(id).style.display = 'none';
			console.log(result);
		},
		error : function(data, status, er) {
			alert('error occurred');
			console.log(data);
			console.log("Status: " + status + " er:" + er);
		}
	});
}

function deleteecomp(obj) {	
	var id = obj.id;
	$.ajax({
		type : 'GET',
		// dataType: 'json',
		data : {
			cid : id
		},
		contentType : 'application/json',
		url : 'DeleteCompany',
		success : function(result) {
			alert(result);
			$("tr").remove("#" + id);
			document.getElementById(id).style.display = 'none';
			console.log(result);
		},
		error : function(data, status, er) {
			alert('error occurred');
			console.log(data);
			console.log("Status: " + status + " er:" + er);
		}
	});
}

function createemp() {
	window.location = "CreateEmployee.jsp"
}

function createcompany() {
	window.location = "CreateCompany.jsp"
}

function editable(id) {	
	
		var ciddata;
		var cnamedata;
		var caddata;
		var contnodata;		
		var ctypeata;
		var cname = document.getElementById("cname" + id);		
		var cadd = document.getElementById("cadd" + id);
		var contno = document.getElementById("contno" + id);
		var type = document.getElementById("type" + id);
	if (document.getElementById("edit" + id).innerHTML != "Save") {
		document.getElementById("edit" + id).innerHTML = "Save";

		cadd.contentEditable = "true";
		cname.contentEditable = "true";
		contno.contentEditable = "true";
		type.contentEditable = "true";		
		ciddata=id;
		cnamedata=cname.innerHTML;		
		caddata=cadd.innerHTML;
		contnodata=contno.innerHTML;		
		ctypeata=type.innerHTML;	
		
	}else{
		var cname = document.getElementById("cname" + id);		
		var cadd = document.getElementById("cadd" + id);
		var contno = document.getElementById("contno" + id);
		var type = document.getElementById("type" + id);
		ciddata=id;
		
		cnamedata=cname.innerHTML;		
		caddata=cadd.innerHTML;
		contnodata=contno.innerHTML;		
		ctypeata=type.innerHTML;
		cadd.contentEditable = "false";
		cname.contentEditable = "false";
		contno.contentEditable = "false";
		type.contentEditable = "false";	
				
		document.getElementById("edit" + id).innerHTML = "Edit";		
		$.ajax({
			type : 'GET',
			data : {
				cid : ciddata, cname : cnamedata , caddress : caddata , cnumber : contnodata , ctype:ctypeata
			},
			contentType : 'application/json',
			url : 'CompanyUpdateData',
			success : function(result) {
				alert("Record Updated");
				console.log(result);
			},
			error : function(data, status, er) {
				alert('error occurred');
				console.log(data);
				console.log("Status: " + status + " er:" + er);
			}
		});
	}
}
	
	function editableemp(id) {
		var eno;
		var efname;
		var elname;
		var eage;		
		var email;
		var eaddr;
		var ebdate;
		var esal;
		var egender;		
		var emob;
		var ehdate;		
		var ecname;
		eno = document.getElementById("eno" + id);			 	
		efname=document.getElementById("efname" + id);			
		elname=document.getElementById("elname" + id);
		eage=document.getElementById("eage" + id);		
		email=document.getElementById("email" + id);
		eaddr=document.getElementById("eaddr" + id);
		ebdate=document.getElementById("ebdate" + id);
		esal=document.getElementById("esal" + id);
		egender=document.getElementById("egender" + id);		
		emob=document.getElementById("emob" + id);
		ehdate=document.getElementById("ehdate" + id);		
		ecname=document.getElementById("ecname" + id);
					
		if (document.getElementById("edit" + id).innerHTML != "Save") {
			document.getElementById("edit" + id).innerHTML = "Save"
			
			
			eno.contentEditable = "true";			 	
			efname.contentEditable = "true";			
			elname.contentEditable = "true";
			eage.contentEditable = "true";		
			email.contentEditable = "true";
			eaddr.contentEditable = "true";
			ebdate.contentEditable = "true";
			esal.contentEditable = "true";
			egender.contentEditable = "true";		
			emob.contentEditable = "true";
			ehdate.contentEditable = "true";		
			ecname.contentEditable = "true";	
			
			enodata=eno.innerHTML;		
			efnamedata=efname.innerHTML;
			elnamedata=elname.innerHTML;
			eagedata=eage.innerHTML;		
			emaildata=email.innerHTML;
			eaddrdata=eaddr.innerHTML;
			ebdatedata=ebdate.innerHTML;		
			esaldata=esal.innerHTML;
			egenderdata=egender.innerHTML;
			emobdata=emob.innerHTML;		
			ehdatedata=ehdate.innerHTML;
			ecnamedata=ecname.innerHTML;	
				
		}else{
			
			
			enodata=eno.innerHTML;		
			efnamedata=efname.innerHTML;
			elnamedata=elname.innerHTML;
			eagedata=eage.innerHTML;		
			emaildata=email.innerHTML;
			eaddrdata=eaddr.innerHTML;			
			ebdatedata=ebdate.innerHTML;			
			esaldata=esal.innerHTML;
			egenderdata=egender.innerHTML;
			emobdata=emob.innerHTML;		
			ehdatedata=ehdate.innerHTML;
			ecnamedata=ecname.innerHTML;	
			eno.contentEditable = "false";			 	
			efname.contentEditable = "false";			
			elname.contentEditable = "false";
			eage.contentEditable = "false";		
			email.contentEditable = "false";
			eaddr.contentEditable = "false";
			ebdate.contentEditable = "false";
			esal.contentEditable = "false";
			egender.contentEditable = "false";		
			emob.contentEditable = "false";
			ehdate.contentEditable = "false";		
			ecname.contentEditable = "false";
			
			document.getElementById("edit" + id).innerHTML= "Edit";
			$.ajax({
				type : 'GET',
				data : {		
					Empno:enodata,Fname:efnamedata,Lname:elnamedata,Age:eagedata,Mail:emaildata,Address:eaddrdata,dob:ebdatedata,Salary:esaldata,gender:egenderdata,Mobile:emobdata,Hiredate:ehdatedata,cname:ecnamedata
				},
				contentType : 'application/json',
				url : 'UpdateEmployee',
				success : function(result) {
					alert("Record Updated");
					console.log(result);
				},
				error : function(data, status, er) {
					alert('error occurred');
					console.log(data);
					console.log("Status: " + status + " er:" + er);
				}
			});
		}
	
	}
