
<%@page import="model.Grind"%>
<%@page import="dbmanager.TutorDbManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Tutor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  >
<head>
  <!-- Site made with Mobirise Website Builder v4.11.3, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.11.3, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/mbr-92x92.jpg" type="image/x-icon">
  <meta name="description" content="Site Generator Description">
  
  <title>Tutor Search Results</title>
  <link rel="stylesheet" href="assets/web/assets/mobirise-icons/mobirise-icons.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css"><link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
  
  
  
</head>
<body>
  <section class="menu cid-qTkzRZLJNu" once="menu" id="menu1-j">

    

    <nav class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <div class="hamburger">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>
        </button>
        <div class="menu-logo">
            <div class="navbar-brand">
                <span class="navbar-logo">
                    <a href="index.jsp">
                         <img src="assets/images/mbr-92x92.jpg" alt="Mobirise" title="" style="height: 3.8rem;">
                    </a>
                </span>
                <span class="navbar-caption-wrap"><a class="navbar-caption text-white display-4" href="index.jsp"><p>FIND A GRIND</p></a></span>
            </div>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true"><li class="nav-item"><a class="nav-link link text-white display-4" href="index.jsp"><span class="mbri-home mbr-iconfont mbr-iconfont-btn"></span>Home</a></li><li class="nav-item">
                    <a class="nav-link link text-white display-4" href="login.jsp"><span class="mbri-unlock mbr-iconfont mbr-iconfont-btn"></span>
                        Logout</a>
                </li>
                <li class="nav-item dropdown"><a class="nav-link link text-white dropdown-toggle display-4" href="https://mobirise.com" aria-expanded="false" data-toggle="dropdown-submenu"><span class="mbri-user mbr-iconfont mbr-iconfont-btn"></span>
                        Register</a><div class="dropdown-menu"><a class="text-white dropdown-item display-4" href="editStudent.jsp" aria-expanded="false">Update Information</a></div></li><li class="nav-item"><a class="nav-link link text-white display-4" href="faq.jsp"><span class="mbri-question mbr-iconfont mbr-iconfont-btn"></span>FAQ</a></li></ul>
            
        </div>
    </nav>
</section>

<section class="engine"><a href="https://mobirise.info/k">how to develop free website</a></section><section class="mbr-section form4 cid-rIca46jzUu" id="form4-1d">

    

    
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="google-map"><iframe frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/place?key=AIzaSyCy9r70T3NYf3PhvVflTo0_zdif2_IoIYs&amp;q=place_id:ChIJI8O7gCOQREgRkVJeg_BLik0" allowfullscreen=""></iframe></div>
            </div>
            <div class="col-md-6">
                
                <div>
                    <div class="icon-block pb-3 align-left">
                        
                        <h4 class="icon-block__title align-left mbr-fonts-style display-5">Search &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</h4>
                    </div>
                    
                </div>
                <div data-form-type="formoid">
                    <!---Formbuilder Form--->
                    <form action="SearchServlet" method="POST" class="mbr-form form-with-styler">
                        <div class="row">
                            
                            <div hidden="hidden" data-form-alert-danger="" class="alert alert-danger col-12">
                            </div>
                        </div>
                        <div class="dragArea row">
                            <div class="col-md-6  form-group" data-for="subject">
                                <input type="text" name="subject" placeholder="Subject" data-form-field="Subject" class="form-control input display-7" id="subject-form4-1d">
                            </div>
                            <div data-for="location" class="col-md-6  form-group">
                                <input type="text" name="location" placeholder="Location" data-form-field="Location" class="form-control input display-7" id="location-form4-1d">
                            </div>
                            
                            <div data-for="req" class="col-md-12 form-group">
                            <label for="req-form1-" class="form-control-label mbr-fonts-style display-7">Requirement</label>
                            <select class="form-control" name="req">
                                <option value="1">One on One</option>
                                <option value="2">Group Grinds Classes</option>
                            </select>
    
                         </div>
                            
                            
                            <div class="col-md-12 input-group-btn  mt-2 align-center"><button type="submit" class="btn btn-primary btn-form display-4">SEARCH</button></div>
                        </div>
                    </form><!---Formbuilder Form--->
                </div>
            </div>
        </div>
    </div>
</section>

<section class="services4 cid-rFTB4Pk6HP" xmlns="http://www.w3.org/1999/html" id="services4-p">
 
    <div class="container">
        <div class="row">
            <!--Card-1-->
            <% //https://www.geeksforgeeks.org/getattribute-passing-data-from-server-to-jsp/
                if(request.getAttribute("data") != null){
            ArrayList<Tutor> list = (ArrayList<Tutor>)request.getAttribute("data");
            for(Tutor tutor: list){
                //From Mobirise template
            out.print("<div class='card p-3 col-12'>");
                out.print("<div class='card-wrapper media-container-row media-container-row'>");
                    out.print("<div class='card-box'>");
                        out.print("<div class='row'>");
                            out.print("<div class='col-12 col-md-12 col-lg-4'>");
                                out.print("<div class='wrapper'>");
                                    
                                    out.print("<div class='mbr-figure' style='width: 65%;'>");
                                        out.print("<img src='assets/images/mbr-192x192.jpeg' alt='Mobirise' title=''>");
                                    out.print("</div>");
                                out.print("</div>");
                            out.print("</div>");
                            out.print("<div class='col-12 col-md-7 col-lg-5'>");
                                out.print("<div class='wrapper col-left'>");
                                    
                                    out.print("<h4 class='card-title mbr-fonts-style display-5'>");
                                        out.print(tutor.getName()+"</h4>");
                                        String subj = "";
                                        for(String sub:TutorDbManager.searchSubjectWithTutor(tutor.getTutorId())){
                                            subj += sub+",";
                                        }
                                    out.print("<p class='mbr-text mbr-fonts-style pt-3 display-7'></p><p><strong>Subject: </strong>"+subj);
out.print("<br><strong>Location:</strong> "+tutor.getLocation());
out.print("<br><strong>Availability:</strong> "+tutor.getAvailability());
out.print("<br><strong>Description:</strong> "+tutor.getDescription()+"....</p><p></p><p></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em><strong> &nbsp;VIEW</strong></em>&nbsp;<br></p><p></p><p></p>");
                                out.print("</div>");
                            out.print("</div>");
                            out.print("<div class='col-12 col-md-5 col-lg-3'>");
                                out.print("<div class='wrapper border_wrapper'>");
                                    
                                    out.print("<div class='mbr-section-btn col-right align-center'><a href='messanger.jsp?id"+tutor.getTutorId()+"' class='btn btn-warning-outline m-0 display-4'>Contact</a></div>");
                                out.print("</div>");
                            out.print("</div>");
                        out.print("</div>");
                    out.print("</div>");
                out.print("</div>");
            out.print("</div>");
            }
                }
                
                if(request.getAttribute("gdata") != null){
            ArrayList<Grind> list = (ArrayList<Grind>)request.getAttribute("gdata");
            for(Grind grind: list){
                //From Mobirise template
            out.print("<div class='card p-3 col-12'>");
                out.print("<div class='card-wrapper media-container-row media-container-row'>");
                    out.print("<div class='card-box'>");
                        out.print("<div class='row'>");
                            out.print("<div class='col-12 col-md-12 col-lg-4'>");
                                out.print("<div class='wrapper'>");
                                    
                                    out.print("<div class='mbr-figure' style='width: 65%;'>");
                                        out.print("<img src='assets/images/4.png' alt='Mobirise' title=''>");
                                    out.print("</div>");
                                out.print("</div>");
                            out.print("</div>");
                            out.print("<div class='col-12 col-md-7 col-lg-5'>");
                                out.print("<div class='wrapper col-left'>");
                                    
                                    out.print("<h4 class='card-title mbr-fonts-style display-5'>");
                                        out.print(grind.getName()+"</h4>");
                                        
out.print("<p class='mbr-text mbr-fonts-style pt-3 display-7'></p><p><strong>Subject: </strong>"+grind.getSubject());
out.print("<br><strong>Location:</strong> "+grind.getLocation());
out.print("<br><strong>Building:</strong> "+grind.getGLocation());
out.print("<br><strong>Date:</strong> "+grind.getDate());
out.print("<br><strong>Time:</strong> "+grind.getTime());
out.print("<br><strong>Price:</strong> "+grind.getPrice());
out.print("<br><strong>Capacity:</strong> "+grind.getCapacity());
                                out.print("</div>");
                            out.print("</div>");
                            out.print("<div class='col-12 col-md-5 col-lg-3'>");
                                out.print("<div class='wrapper border_wrapper'>");
                                    
                                    out.print("<div class='mbr-section-btn col-right align-center'><a action='' class='btn btn-warning-outline m-0 display-4'>Join</a></div>");
                                out.print("</div>");
                            out.print("</div>");
                        out.print("</div>");
                    out.print("</div>");
                out.print("</div>");
            out.print("</div>");
            }
                }
              %>
              

<form action="">
    <input type="text" name="integer" value="1"/>
    <input type="submit" value="submit" />
</form>
        </div>
    </div>
</section>

<section once="footers" class="cid-rFTzwXlkTi" id="footer7-l">

    

    

    <div class="container">
        <div class="media-container-row align-center mbr-white">
            <div class="row row-links">
                <ul class="foot-menu">
                    
                    
                    
                    
                    
                <li class="foot-menu-item mbr-fonts-style display-7">
                        <a class="text-white mbr-bold" href="#" target="_blank">About us</a>
                    </li><li class="foot-menu-item mbr-fonts-style display-7">
                        <a class="text-white mbr-bold" href="#" target="_blank">Services</a>
                    </li><li class="foot-menu-item mbr-fonts-style display-7">
                        <a class="text-white mbr-bold" href="#" target="_blank">Get In Touch</a>
                    </li><li class="foot-menu-item mbr-fonts-style display-7">
                    </li></ul>
            </div>
            <div class="row social-row">
                <div class="social-list align-right pb-2">
                    
                    
                    
                    
                    
                    
                <div class="soc-item">
                        <a href="https://twitter.com/mobirise" target="_blank">
                            <span class="socicon-twitter socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.facebook.com/pages/Mobirise/1616226671953247" target="_blank">
                            <span class="socicon-facebook socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.youtube.com/c/mobirise" target="_blank">
                            <span class="socicon-youtube socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://instagram.com/mobirise" target="_blank">
                            <span class="socicon-instagram socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://plus.google.com/u/0/+Mobirise" target="_blank">
                            <span class="socicon-googleplus socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.behance.net/Mobirise" target="_blank">
                            <span class="socicon-behance socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div></div>
            </div>
            <div class="row row-copirayt">
                <p class="mbr-text mb-0 mbr-fonts-style mbr-white align-center display-7">
                    © Copyright 2019 FINDAGRIND - All Rights Reserved
                </p>
            </div>
        </div>
    </div>
</section>


  <script src="assets/web/assets/jquery/jquery.min.js"></script>
  <script src="assets/popper/popper.min.js"></script>
  <script src="assets/bootstrap/js/bootstrap.min.js"></script>
  <script src="assets/tether/tether.min.js"></script>
  <script src="assets/smoothscroll/smooth-scroll.js"></script>
  <script src="assets/dropdown/js/nav-dropdown.js"></script>
  <script src="assets/dropdown/js/navbar-dropdown.js"></script>
  <script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
  <script src="assets/theme/js/script.js"></script>
  
  
</body>
</html>
