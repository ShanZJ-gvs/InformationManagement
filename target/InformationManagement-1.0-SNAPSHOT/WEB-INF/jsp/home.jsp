<%--
  Created by IntelliJ IDEA.
  User: 单子健
  Date: 2021/9/2
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>图书管理系统</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="assets/css/untitled-1.css">
    <link rel="stylesheet" href="assets/css/untitled.css">

    <script>
        function show() {

            <%--/*******---更改用户名称----*********/--%>
            <%--$.post({--%>
            <%--    url:"${pageContext.request.contextPath}/getUnameByUser",--%>
            <%--    data:{},--%>
            <%--    dataType:"json",--%>
            <%--    success:function (json) {--%>

            <%--       --%>

            <%--    }--%>
            <%--})--%>
            <%--/**************---************/--%>




            /*******---顶部的card----*********/
            $.post({
                url:"${pageContext.request.contextPath}/nav",
                data:{},
                dataType:"json",
                success:function (json) {

                    $("#booknum").html(json[0]);
                    $("#usernum").html(json[1]);
                    $("#borrownum").html(json[2]);
                    $("#overnum").html(json[3]);

                }
            })
            /***********************/


            /*******---最下面的的canvas--******/
            $.post({
                url:"${pageContext.request.contextPath}/waitout",
                data:{},
                dataType:"json",
                success:function (json) {
                    var html = "";
                    var j = 1;
                    for (var i=0;i<json.length;i++)
                    {

                        html+="<li class='list-group-item'><div class='row align-items-center no-gutters'>"+
                            "<div class='col mr-2'><h6 class='mb-0'><strong>"+json[i].bookname+"</strong></h6><span class='text-xs'>"+json[i].starttime+"</span></div>"+
                            "<div class='col-auto'><div class='custom-control custom-checkbox'>"+
                            "<input class='custom-control-input' type='checkbox' id='formCheck-"+j+"'><label class='custom-control-label' for='formCheck-"+j+"'></label></div>"+
                            "</div></div></li>"
                        j = j+1;
                            /*<li class="list-group-item">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <h6 class="mb-0"><strong>《百年孤独》</strong></h6><span class="text-xs">10:30 AM</span>
                                    </div>
                                    <div class="col-auto">
                                        <div class="custom-control custom-checkbox"><input class="custom-control-input" type="checkbox" id="formCheck-1"><label class="custom-control-label" for="formCheck-1"></label></div>
                                    </div>
                                </div>
                            </li>*/

                    };

                    $("#card3").html(html);
                }
            })
            /**********************************/


            /*******---左边的canvas--******/
            $.post({
                url:"${pageContext.request.contextPath}/permonth",
                data:{},
                dataType:"json",
                success:function (json) {

                var canvas = document.getElementById('canvas');
                var myChart = new Chart(canvas , {
                type: 'line',  // 图表的类型
                data: {
                    labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"], //坐标值
                    datasets:[{
                        label:"Earnings",
                        fill:true,
                        data:[json[0],json[1],json[2],json[3],json[4],json[5],json[6],json[7],json[8],json[9],json[10],json[11]],
                        backgroundColor:"rgba(78, 115, 223, 0.05)",
                        borderColor:"rgba(78, 115, 223, 1)"
                    }]
                },
                option:{
                    maintainAspectRatio:false,
                    legend:{display:false,position:top,reverse:false},
                    title:{},
                    scales:{
                        xAxes:[{
                            gridLines: {
                                color:"rgb(234, 236, 244)",
                                zeroLineColor:"rgb(234, 236, 244)",
                                drawBorder:false,
                                drawTicks:false,
                                borderDash:[2],
                                zeroLineBorderDash:[2],
                                drawOnChartArea:false},
                            ticks:{
                                fontColor:"#858796",
                                padding:20}
                        }],
                        yAxes:[{
                            gridLines:{
                                color:"rgb(234, 236, 244)",
                                zeroLineColor:"rgb(234, 236, 244)",
                                drawBorder:false,
                                drawTicks:false,
                                borderDash:[2],
                                zeroLineBorderDash:[2]},
                            ticks:{
                                fontColor:"#858796",
                                padding:20}
                        }],
                        },

                }
            })
                }
            })
            /**********************************/


            /*******--------右边边的canvas---------******/
            $.post({
                url:"${pageContext.request.contextPath}/bookindex",
                data:{},
                dataType:"json",
                success:function (json) {

                    var canvas2 = document.getElementById('canvas2');
                    var myChart2 = new Chart(canvas2 , {
                        type: 'doughnut',  // 图表的类型
                        data: {
                            labels: [ "借出" , "逾期" , "剩余" ],
                            datasets:[{
                                label:"",
                                data:[ json[1], json[2], json[0] ],
                                backgroundColor:[ "#4e73df" , "#1cc88a" , "#36b9cc" ],
                                borderColor:[ "#ffffff", "#ffffff" , "#ffffff" ]
                            }]
                        },
                        option:{
                            maintainAspectRatio:false,
                            legend:{ display :false},
                            title:{},
                        }
                    })
                }
            })
            /**********************************/



        }



    </script>
</head>
<body id="page-top" onpageshow="show()">
<div id="wrapper">
    <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
        <div class="container-fluid d-flex flex-column p-0">
            <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="${pageContext.request.contextPath}/tohome">
                <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-laugh-wink"></i></div>
                <div class="sidebar-brand-text mx-3"><span>HELLO,${uuid.getUname()}</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light" id="accordionSidebar">
                <li class="nav-item" role="presentation">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/tobookinf"><i class="fas fa-book-open"></i><span style="margin-left: 4px;">图书库</span></a>
                    <a class="nav-link active" href="${pageContext.request.contextPath}/toborrow"><i class="fas fa-grip-lines"></i><span style="filter: blur(0px) brightness(100%);margin-left: 3px;">历史借阅</span></a>
                    <a class="nav-link active" href="${pageContext.request.contextPath}/touser"><i class="fas fa-user-cog"></i><span>用户管理</span></a>
                    <a class="nav-link active" href="${pageContext.request.contextPath}/tomessage"><i class="fas fa-clipboard-list"></i><span style="margin-left: 2px;">&nbsp;消息处理</span></a>
                    <a class="nav-link active" href="${pageContext.request.contextPath}/touserwant"><i class="fas fa-user-clock" style="width: 17px;"></i><span>增库申请</span></a></li>
            </ul>
            <div class="text-center d-none d-md-inline"><button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button></div>
        </div>
    </nav>
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
                <div class="container-fluid"><button class="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button"><i class="fas fa-bars"></i></button>
                    <form class="form-inline d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group"><input class="bg-light form-control border-0 small" type="text" placeholder="Search for ...">
                            <div class="input-group-append"><button class="btn btn-primary py-0" type="button" style="margin: 0px;margin-left: 3px;"><i class="fas fa-search"></i></button></div>
                        </div>
                    </form>
                    <ul class="nav navbar-nav flex-nowrap ml-auto">
                        <li class="nav-item dropdown d-sm-none no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-search"></i></a>
                            <div class="dropdown-menu dropdown-menu-right p-3 animated--grow-in" role="menu" aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto navbar-search w-100">
                                    <div class="input-group"><input class="bg-light form-control border-0 small" type="text" placeholder="Search for ...">
                                        <div class="input-group-append"><button class="btn btn-primary py-0" type="button"><i class="fas fa-search"></i></button></div>
                                    </div>
                                </form>
                            </div>
                        </li>
                        <li class="nav-item dropdown no-arrow mx-1" role="presentation">
                            <div class="nav-item dropdown no-arrow"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button"><span class="badge badge-danger badge-counter">3+</span><i class="fas fa-bell fa-fw"></i></button>
                                <div class="dropdown-menu dropdown-menu-right dropdown-list dropdown-menu-right animated--grow-in"
                                     role="menu">
                                    <h6 class="dropdown-header">alerts center</h6>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="mr-3">
                                            <div class="bg-primary icon-circle"><i class="fas fa-file-alt text-white"></i></div>
                                        </div>
                                        <div><span class="small text-gray-500">December 12, 2019</span>
                                            <p>A new monthly report is ready to download!</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="mr-3">
                                            <div class="bg-success icon-circle"><i class="fas fa-donate text-white"></i></div>
                                        </div>
                                        <div><span class="small text-gray-500">December 7, 2019</span>
                                            <p>$290.29 has been deposited into your account!</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="mr-3">
                                            <div class="bg-warning icon-circle"><i class="fas fa-exclamation-triangle text-white"></i></div>
                                        </div>
                                        <div><span class="small text-gray-500">December 2, 2019</span>
                                            <p>Spending Alert: We've noticed unusually high spending for your account.</p>
                                        </div>
                                    </a><a class="text-center dropdown-item small text-gray-500" href="#">Show All Alerts</a></div>
                            </div>
                        </li>
                        <li class="nav-item dropdown no-arrow mx-1" role="presentation">
                            <div class="nav-item dropdown no-arrow"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button"><i class="fas fa-envelope fa-fw"></i><span class="badge badge-danger badge-counter">7</span></button>
                                <div class="dropdown-menu dropdown-menu-right dropdown-list dropdown-menu-right animated--grow-in"
                                     role="menu">
                                    <h6 class="dropdown-header">alerts center</h6>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="assets/img/avatars/avatar4.jpeg">
                                            <div class="bg-success status-indicator"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate"><span>Hi there! I am wondering if you can help me with a problem I've been having.</span></div>
                                            <p class="small text-gray-500 mb-0">Emily Fowler - 58m</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="assets/img/avatars/avatar2.jpeg">
                                            <div class="status-indicator"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate"><span>I have the photos that you ordered last month!</span></div>
                                            <p class="small text-gray-500 mb-0">Jae Chun - 1d</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="assets/img/avatars/avatar3.jpeg">
                                            <div class="bg-warning status-indicator"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate"><span>Last month's report looks great, I am very happy with the progress so far, keep up the good work!</span></div>
                                            <p class="small text-gray-500 mb-0">Morgan Alvarez - 2d</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="assets/img/avatars/avatar5.jpeg">
                                            <div class="bg-success status-indicator"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate"><span>Am I a good boy? The reason I ask is because someone told me that people say this to all dogs, even if they aren't good...</span></div>
                                            <p class="small text-gray-500 mb-0">Chicken the Dog · 2w</p>
                                        </div>
                                    </a><a class="text-center dropdown-item small text-gray-500" href="#">Show All Alerts</a></div>
                            </div>
                            <div class="shadow dropdown-list dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown"></div>
                        </li>
                        <div class="d-none d-sm-block topbar-divider"></div>
                        <li class="nav-item dropdown no-arrow" role="presentation">
                            <div class="nav-item dropdown no-arrow"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button"><span class="d-none d-lg-inline mr-2 text-gray-600 small">Valerie Luna</span><img class="border rounded-circle img-profile" src="assets/img/avatars/touxiang.png"></button>
                                <div class="dropdown-menu shadow dropdown-menu-right animated--grow-in" role="menu"><a class="dropdown-item" role="presentation" href="#"><i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Profile</a><a class="dropdown-item" role="presentation" href="#"><i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Settings</a>
                                    <a class="dropdown-item" role="presentation" href="#"><i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Activity log</a>
                                    <div class="dropdown-divider"></div><a class="dropdown-item" role="presentation" href="#"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Logout</a></div>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="container-fluid">
                <div class="d-sm-flex justify-content-between align-items-center mb-4">
                    <h3 class="text-dark mb-0">Admin仪表</h3><a class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#"><i class="fas fa-download fa-sm text-white-50"></i>&nbsp;Generate Report</a></div>
                <div class="row">
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-primary py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-uppercase text-primary font-weight-bold text-xs mb-1"><span>图书数量</span></div>
                                        <div class="text-dark font-weight-bold h5 mb-0"><span id="booknum">0</span></div>
                                    </div>
                                    <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-success py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-uppercase text-success font-weight-bold text-xs mb-1"><span>用户数量</span></div>
                                        <div class="text-dark font-weight-bold h5 mb-0"><span id="usernum">0</span></div>
                                    </div>
                                    <div class="col-auto"><i class="fas fa-dollar-sign fa-2x text-gray-300"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-info py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-uppercase text-info font-weight-bold text-xs mb-1"><span>借阅次数</span></div>
                                        <div class="row no-gutters align-items-center">
                                            <div class="col-auto">
                                                <div class="text-dark font-weight-bold h5 mb-0 mr-3"><span id="borrownum">0</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-auto"><i class="fas fa-clipboard-list fa-2x text-gray-300"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-warning py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-uppercase text-warning font-weight-bold text-xs mb-1"><span>当前逾期</span></div>
                                        <div class="text-dark font-weight-bold h5 mb-0"><span id="overnum" >0</span></div>
                                    </div>
                                    <div class="col-auto"><i class="fas fa-comments fa-2x text-gray-300"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-7 col-xl-8">
                        <div class="card shadow mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <h6 class="text-primary font-weight-bold m-0">每月借阅量</h6>
                                <div class="dropdown no-arrow"><button class="btn btn-link btn-sm dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button"><i class="fas fa-ellipsis-v text-gray-400"></i></button>
                                    <div class="dropdown-menu shadow dropdown-menu-right animated--fade-in"
                                         role="menu">
                                        <p class="text-center dropdown-header">dropdown header:</p><a class="dropdown-item" role="presentation" href="#">&nbsp;Action</a><a class="dropdown-item" role="presentation" href="#">&nbsp;Another action</a>
                                        <div class="dropdown-divider"></div><a class="dropdown-item" role="presentation" href="#">&nbsp;Something else here</a></div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="chart-area" id="permonth">


                                    <canvas id="canvas"></canvas>


                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5 col-xl-4">
                        <div class="card shadow mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <h6 class="text-primary font-weight-bold m-0">图书库</h6>
                                <div class="dropdown no-arrow"><button class="btn btn-link btn-sm dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button"><i class="fas fa-ellipsis-v text-gray-400"></i></button>
                                    <div class="dropdown-menu shadow dropdown-menu-right animated--fade-in"
                                         role="menu">
                                        <p class="text-center dropdown-header">dropdown header:</p><a class="dropdown-item" role="presentation" href="#">&nbsp;Action</a><a class="dropdown-item" role="presentation" href="#">&nbsp;Another action</a>
                                        <div class="dropdown-divider"></div><a class="dropdown-item" role="presentation" href="#">&nbsp;Something else here</a></div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="chart-area" id="bookinf" >
<%--
                                    <canvas id="canvas2" data-bs-chart="{&quot;type :doughnut&quot;,&quot;data&quot;:{&quot;labels&quot;:[&quot;Direct&quot;,&quot;Social&quot;,&quot;Referral&quot;],&quot;datasets&quot;:[{&quot;label&quot;:&quot;&quot;,&quot;backgroundColor&quot;:[&quot;#4e73df&quot;,&quot;#1cc88a&quot;,&quot;#36b9cc&quot;],&quot;borderColor&quot;:[&quot;#ffffff&quot;,&quot;#ffffff&quot;,&quot;#ffffff&quot;],&quot;data&quot;:[&quot;50&quot;,&quot;30&quot;,&quot;15&quot;]}]},&quot;options&quot;:{&quot;maintainAspectRatio&quot;:false,&quot;legend&quot;:{&quot;display&quot;:false},&quot;title&quot;:{}}}"></canvas>
--%>
                                    <canvas id="canvas2"></canvas>

                                </div>
                                <div class="text-center small mt-4">
                                    <span class="mr-2">
                                        <i class="fas fa-circle text-primary"></i>&nbsp;借出</span><span class="mr-2"><i class="fas fa-circle text-success"></i>&nbsp;逾期</span><span class="mr-2"><i class="fas fa-circle text-info"></i>&nbsp;剩余</span></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6 mb-4">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <div class="row">
                                <div class="col">
                                    <h6 class="text-primary font-weight-bold m-0">借出处理</h6>
                                </div>
                                <div class="col-xl-2 offset-xl-3"><button class="btn btn-outline-primary" type="button"><i class="fa fa-check"></i></button></div>
                                <div class="col-xl-2"><button class="btn btn-outline-primary" type="button"><i class="fa fa-times"></i></button></div>
                            </div>
                            </div>
                            <ul class="list-group list-group-flush" id="card3">
                                <li class="list-group-item">
                                    <div class="row align-items-center no-gutters">
                                        <div class="col mr-2">
                                            <h6 class="mb-0"><strong>《百年孤独》</strong></h6><span class="text-xs">10:30 AM</span>
                                        </div>
                                        <div class="col-auto">
                                            <div class="custom-control custom-checkbox"><input class="custom-control-input" type="checkbox" id="formCheck-1"><label class="custom-control-label" for="formCheck-1"></label></div>
                                        </div>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="row align-items-center no-gutters">
                                        <div class="col mr-2">
                                            <h6 class="mb-0"><strong>《JAVA核心编程技术卷1》</strong></h6><span class="text-xs">11:30 AM</span></div>
                                        <div class="col-auto">
                                            <div class="custom-control custom-checkbox"><input class="custom-control-input" type="checkbox" id="formCheck-2"><label class="custom-control-label" for="formCheck-2"></label></div>
                                        </div>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="row align-items-center no-gutters">
                                        <div class="col mr-2">
                                            <h6 class="mb-0"><strong>《Linux就该这么学》</strong></h6><span class="text-xs">12:30 AM</span></div>
                                        <div class="col-auto">
                                            <div class="custom-control custom-checkbox"><input class="custom-control-input" type="checkbox" id="formCheck-3"><label class="custom-control-label" for="formCheck-3"></label></div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © Gvssimux 2020</span></div>
            </div>
        </footer>
    </div><a class="text-center border rounded d-inline d-xl-flex justify-content-xl-center align-items-xl-center scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/chart.min.js"></script>
<script src="assets/js/bs-charts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="assets/js/theme.js"></script>
</body>
</html>
