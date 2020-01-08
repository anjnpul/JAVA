<script>
		$(document)
				.ready(
						function() {
							var pwd = $("#DAY-REP").width();
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