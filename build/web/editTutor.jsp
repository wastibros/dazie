
<%@page import="model.Tutor"%>
<%@page import="model.Subject"%>
<%@page import="dbmanager.TutorDbManager"%>
<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="dbmanager.StudentDbManager" %>
<%@page import="model.Location"%>
<html  >
<head>
  <!-- Site made with Mobirise Website Builder v4.11.3, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.11.3, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/mbr-92x92.jpg" type="image/x-icon">
  <meta name="description" content="Site Builder Description">
  
  <title>Edit Tutor Account</title>
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
  <section class="menu cid-rIcIbHVW8K" once="menu" id="menu1-1e">

    

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
            <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true"><li class="nav-item"><a class="nav-link link text-white display-4" href="index.jsp.html"><span class="mbri-home mbr-iconfont mbr-iconfont-btn"></span>Home</a></li><li class="nav-item">
                    <a class="nav-link link text-white display-4" href="addGrind.jsp"><span class="mbri-unlock mbr-iconfont mbr-iconfont-btn"></span>
                        Add Group Grind</a>
                </li>
                <li class="nav-item dropdown"><a class="nav-link link text-white dropdown-toggle display-4" href="https://mobirise.com" aria-expanded="false" data-toggle="dropdown-submenu"><span class="mbri-user mbr-iconfont mbr-iconfont-btn"></span>
                        Register</a><div class="dropdown-menu"><a class="text-white dropdown-item display-4" href="registerStudent.jsp" aria-expanded="false">As a Student</a><a class="text-white dropdown-item display-4" href="registerTutor.jsp" aria-expanded="false">As a Tutor</a></div></li><li class="nav-item"><a class="nav-link link text-white display-4" href="faq.jsp"><span class="mbri-question mbr-iconfont mbr-iconfont-btn"></span>FAQ</a></li></ul>
            
        </div>
    </nav>
</section>

<section class="engine"><a href="https://mobirise.info/j">website templates</a></section><section class="mbr-section form1 cid-rIcIbKaIka" id="form1-1f">

    

    
    <div class="container">
        <div class="row justify-content-center">
            <div class="title col-12 col-lg-8">
                <h2 class="mbr-section-title align-center pb-3 mbr-fonts-style display-2">Tutor Account</h2>
                <h3 class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-5">Please ensure to save changes.</h3>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row justify-content-center">
            <div class="media-container-column col-lg-8" data-form-type="formoid">
                <!---Formbuilder Form--->
                <%
                    Tutor tutor = TutorDbManager.getTutorInformation(session.getAttribute("email").toString());
                %>
                <form action="TutorServlet" method = "POST" class="mbr-form form-with-styler">
                    <input name="tutorId" type="hidden" value="<%= tutor.getTutorId() %>"
                    <div class="row">
                        
                        <div hidden="hidden" data-form-alert-danger="" class="alert alert-danger col-12">
                        </div>
                    </div>
                    <div class="dragArea row">
                        <div class="col-md-4  form-group" data-for="name">
                            <label for="name-form1-17" class="form-control-label mbr-fonts-style display-7">Name</label>
                            <input value="<%= tutor.getName()%>" type="text" name="name" data-form-field="Name" required="required" class="form-control display-7" id="name-form1-17">
                        </div>
                        <div class="col-md-4  form-group" data-for="email">
                            <label for="email-form1-17" class="form-control-label mbr-fonts-style display-7">Email</label>
                            <input value="<%= tutor.getEmail()%>" type="email" name="email" data-form-field="Email" required="required" class="form-control display-7" id="email-form1-17">
                        </div>
                        <div data-for="password" class="col-md-4  form-group">
                            <label for="password-form1-i" class="form-control-label mbr-fonts-style display-7">Password</label>
                            <input value="<%= tutor.getPassword()%>" type="text" name="password" data-form-field="Password" class="form-control display-7" id="password-form1-i">
                        </div>
                        
                        <div data-for="location" class="col-md-6 form-group">
                            <label for="location-form1-i" class="form-control-label mbr-fonts-style display-7">Location</label>
                            <select class="form-control" name="location">
                                <%
                                    List<Location> list = StudentDbManager.getAllLocations();
                                    for(Location location:list){
                                        if(location.getLocationId() == tutor.getLocationId()){
                                           out.print("<option selected='true' value='"+location.getLocationId()+"'>"+location.getLocation()+"</option>");
                                        
                                        }
                                        else{
                                           out.print("<option value='"+location.getLocationId()+"'>"+location.getLocation()+"</option>");
                                         
                                        }
                                    }
                                 %>
                            </select>
    
                         </div>
                        <div class="col-md-6  form-group" data-for="availability">
                            <label for="availability-form1-17" class="form-control-label mbr-fonts-style display-7">Availability</label>
                            <input  value="<%= tutor.getAvailability() %>" type="text" name="availability" data-form-field="Availability" class="form-control display-7" id="availability-form1-17">
                        </div>
                        
                        <div data-for="location" class="col-md-6 form-group">
                            <label for="location-form1-i" class="form-control-label mbr-fonts-style display-7">Subject</label>
                            <select multiple="" class="form-control" name="subject">
                                <%
                                    List<Subject> sList = TutorDbManager.getAllSubjects();
                                    List<Integer> subjectIds = TutorDbManager.getAllSubjects(tutor.getTutorId());
                                    for(Subject subject:sList){
                                        if(subjectIds.contains(subject.getSubjectId())){
                                            out.print("<option selected='true' value='"+subject.getSubject()+"'>"+subject.getSubject()+"</option>");
                                    
                                        }
                                        else{
                                            out.print("<option value='"+subject.getSubject()+"'>"+subject.getSubject()+"</option>");
                                    
                                        }
                                        
                                    }
                                 %>
                            </select>
    
                         </div>
                        
                        
                        <div data-for="description" class="col-md-12 form-group">
                            <label for="description-form1-17" class="form-control-label mbr-fonts-style display-7">Description</label>
                            <textarea name="description" data-form-field="Message" class="form-control display-7" placeholder="Please include relevent qualifications and experience." id="description-form1-17"><%= tutor.getDescription() %></textarea>
                            
                            
                        </div>
                        <div class="col-md-12 input-group-btn align-center"><button type="submit" value="Submit" class="btn btn-primary btn-form display-4">REGISTER</button></div>
                    </div>
                </form><!---Formbuilder Form--->
            </div>
        </div>
    </div>
</section>

<section once="footers" class="cid-rIcIbLRLiN" id="footer7-1g">

    

    

    <div class="container">
        <div class="media-container-row align-center mbr-white">
            <div class="row row-links">
                <ul class="foot-menu">
                    
                    
                    
                    
                    
                <li class="foot-menu-item mbr-fonts-style display-7">
                        <a class="text-white mbr-bold" href="#" target="_blank">About us</a>
                    </li><li class="foot-menu-item mbr-fonts-style display-7">
                        <a class="text-white mbr-bold" href="#" target="_blank">About us</a>
                    </li><li class="foot-menu-item mbr-fonts-style display-7">
                        <a class="text-white mbr-bold" href="#" target="_blank">About us</a>
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
                    � Copyright 2019 FINDAGRIND - All Rights Reserved
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