<template>
  <footer class="site-footer">
    <div class="container">
      <div class="row">
        <div class="col-sm-12 col-md-6">
          <h6>About</h6>
          <p class="text-justify"> Welcome to Castles of Japan, your ultimate guide to exploring the rich history and
            cultural heritage of Japan's majestic castles. Our mission is to provide comprehensive information, stunning
            imagery, and captivating stories about these iconic landmarks that have stood the test of time.</p>
          <p>Whether you're a history enthusiast, an avid traveler, or simply curious about Japan's architectural wonders,
            we're here to inspire and educate you on the fascinating world of Japanese castles.</p>
        </div>

        <div class="col-xs-6 col-md-3">
          <h6>Categories</h6>
          <ul class="footer-links">
            <li><a href="#">Our Mission</a></li>
            <li><a href="#">Join the Team</a></li>
            <li><a href="#">Have a Question?</a></li>
            <li><a href="#">Sign up for Premium</a></li>
            <li><a href="#">Partners</a></li>
          </ul>
        </div>

        <div class="col-xs-6 col-md-3">
          <h6>Quick Links</h6>
          <ul class="footer-links">
            <li><a href="#">About Us</a></li>
            <li><a href="#">Contact Us</a></li>
            <li><a href="#">Contribute</a></li>
            <li><a href="#">Community Outreach</a></li>
          </ul>
        </div>
      </div>
      <hr>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-md-8 col-sm-6 col-xs-12">
          <p class="copyright-text">Copyright &copy; 2024 All Rights Reserved by
            <a href="#">Foxtrot Enterprise</a>.
          </p>
        </div>

        <div class="col-md-4 col-sm-6 col-xs-12 text-right">
          <ul class="social-icons">
            <i class="pi pi-facebook"></i>
            <i class="pi pi-twitter"></i>
            <i class="pi pi-reddit"></i>
            <i class="pi pi-linkedin"></i>
          </ul>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
export default {

}
</script>

<style scoped>
.site-footer {
   
   border-top: 2px solid #8BBAB1;
   background-color: #193144;
   padding: 45px 0 20px;
   font-size: 15px;
   line-height: 24px;
   color: #737373;
   width: 100vw;
 }

 .site-footer hr {
   border-top-color: #8BBAB1;
   opacity: 0.5
 }

 .site-footer hr.small {
   margin: 20px
 }

 .site-footer h6 {
   color: #FFFDF1;
   font-size: 16px;
   text-transform: uppercase;
   margin-top: 5px;
   letter-spacing: 2px
 }

 .site-footer a {
   color: #737373;
 }

 .pi-facebook:hover {
   color: #FFFDF1;

 }

 .pi-twitter:hover {
   color: #FFFDF1;
 }

 .pi-reddit:hover {
   color: #FFFDF1;
 }

 .pi-linkedin:hover {
   color: #FFFDF1;
 }

 .site-footer a:hover {
   color: #FFFDF1;
 }

 .footer-links {
   padding-left: 0;
   list-style: none
 }

 .footer-links li {
   display: block
 }

 .footer-links a {
   color: #737373;
   text-decoration: none;
 }

 .footer-links a:active,
 .footer-links a:focus,
 .footer-links a:hover {
   color: #FFFDF1;
   text-decoration: none;
 }

 .footer-links.inline li {
   display: inline-block
 }

 .site-footer .social-icons {
   display: flex;
   justify-content: flex-end;
   width: 25vw;
   justify-content: space-evenly;
 }

 .copyright-text {
   margin: 0
 }</style>
