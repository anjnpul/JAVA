<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>ANJAN</title>
<link rel="icon" type="image/png" href="css/energy.png">
<!-- Bootstrap -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Optional Bootstrap Theme -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/blitzer/jquery-ui.css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        
<style>
* {
  box-sizing: border-box;
}

#myInput {
  background-image: url('css/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

#jqGrid {
  border-collapse: collapse;
  border: 1px solid #ddd;
  font-size: 12px;
}

#jqGrid th, #myTable td {
  text-align: left;
  padding: 12px;
}

#jqGrid tr {
  border-bottom: 1px solid #ddd;
}

#jqGrid tr.header, #jqGrid tr:hover {
  background-color: #f1f1f1;
}
</style>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="About.jsp">About</a></li>
                    <li><a href="Contact.jsp">Contact Us</a></li>
                </ul>
                <ul class="nav navbar-nav btn pull-right">
                    <%
					if (session != null) {
						if (session.getAttribute("user") != null) {
						String name = (String) session.getAttribute("user");
						out.print("<li><form action='Login' method='post'><input type='submit' value='Logout' name='logout'></form></li>");
						} else {
						response.sendRedirect("login.html");
						}
					}
					%>
                </ul>
            </div>
        </div>
    </div>
    <br>
    <br>
<hr/>
	<div class="container">
		
		<div class="row">
			<div class="col-sm-3">
				<div class="panel panel-primary" id="menu">
					<div class="panel-body">
						<table class="table table-bordered table-hover">
							<tr>
								<td><input type="button" class="btn btn-primary"
									id="lblPMT" value="PAYMENTS" /></td>
							</tr>
							<tr>
								<td><input type="button" class="btn btn-primary"
									id="lblPMT1" value="PAYMENTS" /></td>
							</tr>
							<tr>
								<td><input type="button" class="btn btn-primary"
									id="lblPMT2" value="PAYMENTS" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="panel panel-danger ab" id="ADD_PMT" hidden>
					<div class="panel-heading">PAYMENT ENTRY</div>
					<div class="panel-body">
						<table class="table table-bordered table-hover">
							<tr>
								<td>REF. NO:</td>
								<td><input type="text" class="form-control" name="REF"
									id="REF" /></td>
								<td>DATE:</td>
								<td><input type="text" class="form-control" name="DATE"
									id="DATE" /></td>
							</tr>
							<tr>
								<td>PROJECT:</td>
								<td><input type="text" name="PROJ" id="PROJ"
									class="form-control" /></td>
								<td><input type="hidden" id="ACT" name="ACT" /></td>
							</tr>
							<tr>
								<td>ACCOUNT:</td>
								<td><input type="text" class="form-control" name="ACC"
									id="ACC" /></td>
								<td>ACCOUNT TYPE:</td>
								<td><input type="text" class="form-control" name="ACCTP"
									id="ACCTP" /></td>
							</tr>
							<tr>
								<td>PAID TO / FOR:</td>
								<td><input type="text" class="form-control" name="PARTY"
									id="PARTY" /></td>
								<td>PAYMENT TYPE:</td>
								<td><input type="text" class="form-control" name="PARTYTP"
									id="PARTYTP" /></td>
							</tr>
							<tr>
								<td>AMOUNT:</td>
								<td><input type="number" step="any" class="form-control"
									name="AMT" id="AMT" /></td>
								<td>REMARKS:</td>
								<td><input type="text" class="form-control" name="REM"
									id="REM" /></td>
							</tr>
							<tr>
								<td colspan="4"><input type="button"
									class="btn btn-success" id="btnPMT" name="add" value="Save" />&nbsp;
									&nbsp;<input type="button" class="btn btn-success" id="btnCAN"
									value="Cancel" /></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="panel panel-success ab" id="EDT_PMT" hidden>
					<div class="panel-heading">ADJUSTMENTS</div>
					<div class="panel-body">
						<table class="table table-bordered table-hover">
							<tr>
								<td>REF. NO:</td>
								<td><input type="text" class="form-control" id="txtREF1" /></td>
								<td>DATE:</td>
								<td><input type="date" class="form-control" id="txtDT1" /></td>
							</tr>
							<tr>
								<td>PROJECT NAME:</td>
								<td colspan="3"><input type="text" class="form-control"
									id="txtPROJ1" /></td>
							</tr>
							<tr>
								<td>ACCOUNT:</td>
								<td><input type="text" class="form-control" id="txtACC1" /></td>
								<td>ACCOUNT TYPE:</td>
								<td><input type="text" class="form-control" id="txtACCTP1" /></td>
							</tr>
							<tr>
								<td>PAID TO / FOR:</td>
								<td><input type="text" class="form-control" id="txtPARTY1" /></td>
								<td>PAYMENT TYPE:</td>
								<td><input type="text" class="form-control" id="txtPTYPE1" /></td>
							</tr>
							<tr>
								<td>AMOUNT:</td>
								<td><input type="number" step="any" class="form-control"
									id="txtAMT1" /></td>
								<td>REMARKS:</td>
								<td><input type="text" class="form-control" id="txtREM1" /></td>
							</tr>
							<tr>
								<td colspan="4"><input type="button"
									class="btn btn-success" id="btnPMT1" value="Save" /><input
									type="button" class="btn btn-success" id="btnCAN1"
									value="Cancel" /></td>
							</tr>
						</table>
					</div>

				</div>
				<div class="panel panel-warning ab" id="DAY-REP" hidden>
					<div class="panel-heading">DAILY REPORT</div>
					<div class="panel-body">
					<form action="">
  						<input type="radio" name="SEAR" value="PROJECT"> PROJECT
  						<input type="radio" name="SEAR" value="PAIDTO"> PAID TO
					</form>
					<input type="text" id="myInput" onkeyup="searchjqgrid()" placeholder="Search for names..">
						<table id="jqGrid" class="table table-bordered table-hover" width="50%">
							<thead>
								<tr>
									<th>ID</th>
									<th>PROJECT</th>
									<th>REF: NO.</th>
									<th>DATE</th>
									<th>ACCOUNT</th>
									<th>PAID TO / FOR</th>
									<th>AMOUNT</th>
									<th>REMARKS</th>
									<th style="display:none;">ACCTP</th>
									<th style="display:none;">PARTYTP</th>
									<th>ACTION</th>
								</tr>
							</thead>
						</table>
						<div id="jqGridPager"></div>
					</div>
				</div>
			</div>
		</div>
		<div id="edt-dlg" title="EDIT ENTRY" hidden>
			<table class="table table-bordered table-hover">
				<tr>
					<td>REF. NO:</td>
					<td><input type="text" class="form-control" name="REF"
						id="REF1" /></td>
					<td>DATE:</td>
					<td><input type="text" class="form-control" name="DATE"
						id="DATE1" /></td>
				</tr>
				<tr>
					<td>PROJECT:</td>
					<td><input type="text" name="PROJ" id="PROJ1"
						class="form-control" /></td>
					<td><input type="hidden" id="ACT1" name="ACT" /><input
						type="hidden" id="ID1" name="ID1" /></td>
				</tr>
				<tr>
					<td>ACCOUNT:</td>
					<td><input type="text" class="form-control" name="ACC"
						id="ACC1" /></td>
					<td>ACCOUNT TYPE:</td>
					<td><input type="text" class="form-control" name="ACCTP"
						id="ACCTP1" /></td>
				</tr>
				<tr>
					<td>PAID TO / FOR:</td>
					<td><input type="text" class="form-control" name="PARTY"
						id="PARTY1" /></td>
					<td>PAYMENT TYPE:</td>
					<td><input type="text" class="form-control" name="PARTYTP"
						id="PARTYTP1" /></td>
				</tr>
				<tr>
					<td>AMOUNT:</td>
					<td><input type="number" step="any" class="form-control"
						name="AMT" id="AMT1" /></td>
					<td>REMARKS:</td>
					<td><input type="text" class="form-control" name="REM"
						id="REM1" /></td>
				</tr>
				<tr>
					<td colspan="4"><input type="button" class="btn btn-success"
						id="btnEDT" value="Save" /></td>
				</tr>
			</table>
		</div>

		<div id="del-dlg" title="DELETE ENTRY" hidden>
			<table class="table table-bordered table-hover">
				<tr>
					<td>REF. NO:</td>
					<td><input type="text" class="form-control" name="REF"
						id="REF2" /></td>
					<td>DATE:</td>
					<td><input type="text" class="form-control" name="DATE"
						id="DATE2" /></td>
				</tr>
				<tr>
					<td>PROJECT:</td>
					<td><input type="text" name="PROJ" id="PROJ2"
						class="form-control" /></td>
					<td><input type="hidden" id="ACT2" name="ACT" /><input
						type="hidden" id="ID2" name="ID2" /></td>
				</tr>
				<tr>
					<td>ACCOUNT:</td>
					<td><input type="text" class="form-control" name="ACC"
						id="ACC2" /></td>
					<td>ACCOUNT TYPE:</td>
					<td><input type="text" class="form-control" name="ACCTP"
						id="ACCTP2" /></td>
				</tr>
				<tr>
					<td>PAID TO / FOR:</td>
					<td><input type="text" class="form-control" name="PARTY"
						id="PARTY2" /></td>
					<td>PAYMENT TYPE:</td>
					<td><input type="text" class="form-control" name="PARTYTP"
						id="PARTYTP2" /></td>
				</tr>
				<tr>
					<td>AMOUNT:</td>
					<td><input type="number" step="any" class="form-control"
						name="AMT" id="AMT2" /></td>
					<td>REMARKS:</td>
					<td><input type="text" class="form-control" name="REM"
						id="REM2" /></td>
				</tr>
				<tr>
					<td colspan="4">Are you sure! You Want to Delete this Record ? &nbsp; &nbsp;<input type="button" class="btn btn-danger"
						id="btnDEL" value="Delete" /></td>
				</tr>
			</table>
		</div>
		<hr />
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
function searchjqgrid() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("jqGrid");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
	  var x = document.querySelector('[name="SEAR"]:checked').value;
	  switch(x) {
	  case "PROJECT":
		  td = tr[i].getElementsByTagName("td")[1];
		    break;
		  case "PAIDTO":
			  td = tr[i].getElementsByTagName("td")[5];
		    break;
		  default:
		    alert("please select a option first");
	  }
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
</script>
	<script>
		$(document)
				.ready(
						function() {
							var pwd = $("#DAY-REP").width();
							$("#jqGrid").width(pwd + 100);
							$("#edt-dlg").dialog({
								autoOpen : false,
								modal : true,
								width : "60%",
								maxWidth : "568px",
								draggable : false,
								resizable : false,
								show : {
									effect : "explode",
									duration : 1000
								}
							});
							$("#del-dlg").dialog({
								autoOpen : false,
								modal : true,
								width : "60%",
								maxWidth : "568px",
								draggable : false,
								resizable : false,
								show : {
									effect : "explode",
									duration : 1000
								}
							});
							$("#ACT").val("ADD");
							$("#ACT1").val("EDIT");
							$("#ACT2").val("DEL");
							$("#btnPMT").click(
									function() {
										$.ajax({
											type : "POST",
											url : "DataCrud",
											data : {
												REF : $("#REF").val(),
												DATE : $("#DATE").val(),
												ACC : $("#ACC").val(),
												ACCTP : $("#ACCTP").val(),
												PARTY : $("#PARTY").val(),
												PARTYTP : $("#PARTYTP").val(),
												AMT : $("#AMT").val(),
												REM : $("#REM").val(),
												PROJ : $("#PROJ").val(),
												ACT : $("#ACT").val()
											},
											success : function(responseText) {
												alert(responseText);
												$('.ab').hide();
												$("#menu :input").prop(
														"disabled", false);
												$('.ab').find('input:text')
														.val('');
											}
										});
									});
							$("#lblPMT").click(function() {
								$('.ab').hide();
								$("#ADD_PMT").show();
								$("#menu :input").prop("disabled", true);
							});
							$("#lblPMT1").click(function() {
								$('.ab').hide();
								$("#EDT_PMT").show();
								$("#menu :input").prop("disabled", true);
							});
							$("#lblPMT2")
									.click(
											function() {
												$
														.ajax({
															type : "GET",
															url : "ViewData",
															success : function(
																	data) {
																$(
																		'#jqGrid tbody')
																		.empty();
																$("#jqGrid")
																		.append(
																				'<tbody>');
																var ndata = '';
																$
																		.each(
																				data,
																				function(
																						key,
																						value) {
																					ndata += '<tr>';
																					ndata += '<td nowrap>'
																							+ value.ID
																							+ '</td>';
																					ndata += '<td nowrap>'
																							+ value.PROJ
																							+ '</td>';
																					ndata += '<td nowrap>'
																							+ value.REF
																							+ '</td>';
																					ndata += '<td nowrap>'
																							+ value.DATE
																							+ '</td>';
																					ndata += '<td nowrap>'
																							+ value.ACC
																							+ '</td>';
																					ndata += '<td nowrap>'
																							+ value.PARTY
																							+ '</td>';
																					ndata += '<td nowrap>'
																							+ value.AMT
																							+ '</td>';
																					ndata += '<td nowrap>'
																							+ value.REM
																							+ '</td>';
																					ndata += '<td nowrap style="display:none;">'
																							+ value.ACCTP
																							+ '</td>';
																					ndata += '<td nowrap style="display:none;">'
																								+ value.PARTYTP
																								+ '</td>';
																					ndata += '<td nowrap><button class="btn btn-warning btn-xs btn1"><span class="glyphicon glyphicon-pencil"></span></button> &nbsp; &nbsp; <button class="btn btn-danger btn-xs btn2"><span class="glyphicon glyphicon-remove"></span></button></td>';
																				});
																$("#jqGrid")
																		.append(
																				ndata);
																$("#jqGrid")
																		.append(
																				'</tbody>');
																$('.ab').hide();
																$("#DAY-REP")
																		.show();
															},
															error : function(
																	resp) {
																alert(resp.responseText);
															}
														});
											});
							$("#btnCAN").click(function() {
								$('.ab').hide();
								$("#menu :input").prop("disabled", false);
								$('.ab').find('input:text').val('');
							});
							$("#btnCAN1").click(function() {
								$('.ab').hide();
								$("#menu :input").prop("disabled", false);
								$('.ab').find('input:text').val('');
							});

							$('#jqGrid')
									.on(
											'click',
											'.btn1',
											function() {
												var currow = $(this).closest(
														'tr');
												$("#ID1").val(
														currow.find('td:eq(0)')
																.text());
												$("#PROJ1").val(
														currow.find('td:eq(1)')
																.text());
												$("#REF1").val(
														currow.find('td:eq(2)')
																.text());
												$("#DATE1").val(
														currow.find('td:eq(3)')
																.text());
												$("#ACC1").val(
														currow.find('td:eq(4)')
																.text());
												$("#PARTY1").val(
														currow.find('td:eq(5)')
																.text());
												$("#AMT1").val(
														currow.find('td:eq(6)')
																.text());
												$("#REM1").val(
														currow.find('td:eq(7)')
																.text());
												$("#ACCTP1").val(
														currow.find('td:eq(8)')
																.text());
												$("#PARTYTP1").val(
														currow.find('td:eq(9)')
																.text());
												$("#edt-dlg").dialog('open');
											});
							$('#jqGrid')
									.on(
											'click',
											'.btn2',
											function() {
												var currow = $(this).closest(
														'tr');
												$("#ID2").val(
														currow.find('td:eq(0)')
																.text());
												$("#PROJ2").val(
														currow.find('td:eq(1)')
																.text());
												$("#REF2").val(
														currow.find('td:eq(2)')
																.text());
												$("#DATE2").val(
														currow.find('td:eq(3)')
																.text());
												$("#ACC2").val(
														currow.find('td:eq(4)')
																.text());
												$("#PARTY2").val(
														currow.find('td:eq(5)')
																.text());
												$("#AMT2").val(
														currow.find('td:eq(6)')
																.text());
												$("#REM2").val(
														currow.find('td:eq(7)')
																.text());
												$("#ACCTP2").val(
														currow.find('td:eq(8)')
																.text());
												$("#PARTYTP2").val(
														currow.find('td:eq(9)')
																.text());
												$("#del-dlg").dialog('open');
											});
							$("#btnEDT").click(function() {
								$.ajax({
									type : "POST",
									url : "DataCrud",
									data : {
										REF : $("#REF1").val(),
										DATE : $("#DATE1").val(),
										ACC : $("#ACC1").val(),
										ACCTP : $("#ACCTP1").val(),
										PARTY : $("#PARTY1").val(),
										PARTYTP : $("#PARTYTP1").val(),
										AMT : $("#AMT1").val(),
										REM : $("#REM1").val(),
										PROJ : $("#PROJ1").val(),
										ACT : $("#ACT1").val(),
										ID : $("#ID1").val()
									},
									success : function(responseText) {
										alert(responseText);
										$("#edt-dlg").dialog('close');
										$("#lblPMT2").click();
									}
								});
							});
							$("#btnDEL").click(function() {
								$.ajax({
									type : "POST",
									url : "DataCrud",
									data: {
										ACT : $("#ACT2").val(),
										ID : $("#ID2").val()
									},
									success : function(responseText) {
										alert(responseText);
										$("#del-dlg").dialog('close');
										$("#lblPMT2").click();
									},
									error: function(responseText) {
										alert(responseText);
									}
								});
							});
						});
	</script>
</body>
</html>
