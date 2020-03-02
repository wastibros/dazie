<%
    HttpSession sess = request.getSession();
    if(((String)sess.getAttribute("USER_TYPE")!=null)){
        String user_type = (String)sess.getAttribute("USER_TYPE");
        if(user_type.compareToIgnoreCase("TEACHER")==0){
            response.sendRedirect("messanger.jsp");
            return;
        }else{
            response.sendRedirect("messanger.jsp");
        }
    }



%>
<!DOCTYPE html>
<html  >
<head>
  <!-- Site made with Mobirise Website Builqder v4.11.3, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.11.3, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/mbr-92x92.jpg" type="image/x-icon">
  <meta name="description" content="">
  
  <title>Home</title>
  <link rel="stylesheet" href="assets/web/assets/mobirise-icons/mobirise-icons.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css"><link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
  
  
  
</head>
<body>
  <section class="menu cid-qTkzRZLJNu" once="menu" id="menu1-0">

    

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
                        Login</a>
                </li>
                <li class="nav-item dropdown"><a class="nav-link link text-white dropdown-toggle display-4" href="https://mobirise.com" aria-expanded="false" data-toggle="dropdown-submenu"><span class="mbri-user mbr-iconfont mbr-iconfont-btn"></span>
                        Register</a><div class="dropdown-menu"><a class="text-white dropdown-item display-4" href="registerStudent.jsp" aria-expanded="false">As a Student</a><a class="text-white dropdown-item display-4" href="registerTutor.jsp" aria-expanded="false">As a Tutor</a></div></li><li class="nav-item"><a class="nav-link link text-white display-4" href="faq.jsp"><span class="mbri-question mbr-iconfont mbr-iconfont-btn"></span>FAQ</a></li></ul>
            
        </div>
    </nav>
</section>

<section class="engine"><a href="https://mobirise.info/s">free bootstrap theme</a></section><section class="header15 cid-rFPcSGo0vl mbr-parallax-background" id="header15-8">

    

    <div class="mbr-overlay" style="opacity: 0.6; background-color: rgb(7, 59, 76);"></div>

    <div class="container align-right">
        <div class="row">
            <div class="mbr-white col-lg-8 col-md-7 content-container">
                <h1 class="mbr-section-title mbr-bold pb-3 mbr-fonts-style display-1">
                    Find a Tutor Instantly:</h1>
                <p class="mbr-text pb-3 mbr-fonts-style display-5">We provide a platform that allows you to search for and contact qualified tutors in a quick and convenient manner, so that you can begin to get the help that you require.
                </p>
            </div>
            <div class="col-lg-4 col-md-5">
                <div class="form-container">
                    <div class="media-container-column" data-form-type="formoid">
                        <!---Formbuilder Form--->
                        <form action="addGrind.jsp" method="POST" class="mbr-form form-with-styler">
                            <div class="row">
                                
                                <div hidden="hidden" data-form-alert-danger="" class="alert alert-danger col-12">
                                </div>
                            </div>
                            <div class="dragArea row">
                                <div class="col-md-12 form-group " data-for="level">
                                    <input type="text" name="level" placeholder="Level" data-form-field="Level" class="form-control px-3 display-7" id="level-header15-8"> <!-- put required="required" in before class --> 
                                </div>
                                
                                <div data-for="subject" class="col-md-12 form-group ">
                                    <input type="text" name="subject" placeholder="Subject" data-form-field="Subject" class="form-control px-3 display-7" id="subject-header15-8">
                                </div>
                                <div data-for="location" class="col-md-12 form-group ">
                                    <input name="location" placeholder="Location" data-form-field="Location" class="form-control px-3 display-7" id="location-header15-8">
                                </div>
                                <div class="col-md-12 input-group-btn"><button type="submit" class="btn btn-secondary btn-form display-4" href="searchTutor.html">Search for Tutor</button></div>
                            </div>
                        </form><!---Formbuilder Form--->
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</section>

<section class="carousel slide testimonials-slider cid-rHHQScQanu" data-interval="false" id="testimonials-slider1-18">
    
    

    

    <div class="container text-center">
        <h2 class="pb-5 mbr-fonts-style display-2">
            LATEST TUTORS TO JOIN</h2>

        <div class="carousel slide" role="listbox" data-pause="true" data-keyboard="false" data-ride="carousel" data-interval="5000">
            <div class="carousel-inner">
                
                
            <div class="carousel-item">
                    <div class="user col-md-8">
                        <div class="user_image">
                            <img src="assets/images/face3.jpg">
                        </div>
                        <div class="user_text pb-3">
                            <p class="mbr-fonts-style display-7">I am newly graduated with a BA in English and film studies and have been tutoring in various degrees for the last five years. I have a firm understanding of the English syllabus, having achieved an A1 myself.&nbsp;<br></p>
                        </div>
                        <div class="user_name mbr-bold pb-2 mbr-fonts-style display-7">
                            Alex
                        </div>
                        <div class="user_desk mbr-light mbr-fonts-style display-7">
                            ENGLISH</div>
                    </div>
                </div><div class="carousel-item">
                    <div class="user col-md-8">
                        <div class="user_image">
                            <img src="assets/images/face2.jpg">
                        </div>
                        <div class="user_text pb-3">
                            <p class="mbr-fonts-style display-7">I am a fully qualified Irish &amp; French Teacher/Tutor with 20 years school one to one teaching experience. I have taught Primary, Secondary and Third Level students.
<br></p>
                        </div>
                        <div class="user_name mbr-bold pb-2 mbr-fonts-style display-7">
                            Linda
                        </div>
                        <div class="user_desk mbr-light mbr-fonts-style display-7">
                            IRISH &amp; FRENCH</div>
                    </div>
                </div></div>

            <div class="carousel-controls">
                <a class="carousel-control-prev" role="button" data-slide="prev">
                  <span aria-hidden="true" class="mbri-arrow-prev mbr-iconfont"></span>
                  <span class="sr-only">Previous</span>
                </a>
                
                <a class="carousel-control-next" role="button" data-slide="next">
                  <span aria-hidden="true" class="mbri-arrow-next mbr-iconfont"></span>
                  <span class="sr-only">Next</span>
                </a>
            </div>
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
  <script src="assets/smoothscroll/smooth-scroll.js"></script>
  <script src="assets/tether/tether.min.js"></script>
  <script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
  <script src="assets/parallax/jarallax.min.js"></script>
  <script src="assets/bootstrapcarouselswipe/bootstrap-carousel-swipe.js"></script>
  <script src="assets/mbr-testimonials-slider/mbr-testimonials-slider.js"></script>
  <script src="assets/dropdown/js/nav-dropdown.js"></script>
  <script src="assets/dropdown/js/navbar-dropdown.js"></script>
  <script src="assets/theme/js/script.js"></script>
  
  
</body>
</html>