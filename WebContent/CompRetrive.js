$(document).ready(function(){
	$("#comp").on('click', function () {
	//alert("workingCOMP");	
    $.ajax({	        	
    	  type : 'GET',
    	  //dataType: 'json',	              
          contentType: 'application/json',	              
          url: 'CompanyRetrive',	              
 	      success: function(result){
 	    	 //alert(result[0].EmpNo); 
 	    	 var dat="<table border=1 id=customers>"
 	    	 dat=dat+"<tr><th>Company Id</th><th>Company Name</th><th>Address</th><th>Number</th><th>Type</th></tr>"
 	    	 //console.log=result.Employee[0];    	 	    	 
 	    	$.each(result, function(index) { 	    		
 	    		console.log(result[index].EmpNo); 	    		
 	    		dat=dat+"<tr><td>"+result[index].Company_id+"</td>";
 	    		console.log(result[index].Company_Name);
 	    		dat=dat+"<td>"+result[index].Company_Name+"</td>";
 	    		console.log(result[index].Company_Address);
 	    		dat=dat+"<td>"+result[index].Company_Address+"</td>";
 	    		console.log(result[index].Company_Contact_No);
 	    		dat=dat+"<td>"+result[index].Company_Contact_No+"</td>";
 	    		console.log(result[index].Type); 	    		
 	    		dat=dat+"<td>"+result[index].Type+"</td>";
 	    		dat=dat+"<td><button id="+result[index].Company_id+" onclick=\"deletee(this)\">Delete</button></td>"
 	    		dat=dat+"</tr>"	    		
 	      });
 	    	dat=dat+"</table>"
 	    	document.getElementById("span").innerHTML=dat;
 	      },
		error:function(data,status,er) {
			alert('error occurred');
			console.log(data);
			console.log("Status: "+status+" er:"+er);
		  }
	});
});
	
	
});