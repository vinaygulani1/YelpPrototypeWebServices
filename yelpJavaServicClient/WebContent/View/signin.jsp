<html>
  <head>
    <title>Login</title>

    <link rel='stylesheet' href='/stylesheets/style.css' />

  </head>
  <body class="body">
	<jsp:include page="header.html" />
<div class="wrap">
        
        <span id="page-content" class="offscreen">&nbsp;</span>
        
			<div class="super-container">
				<div id="alert-container">
    			</div>	
			
				<div class="login" id="gateway">
					<div class="clearfix layout-block layout-h layout-border login-block">
					
					<div class="column column-alpha ">
						
						<form action="SignIn" class="login-form" method="GET" name="login_form">
							<br>
							<h2>Sign In</h2>
							<p>Please enter your email id and password</p>
	                		
	                		<p>
                    		<label>Email Address</label>
                    		<input type="hidden" name="context" value="">
                    		<input tabindex="1" type="email" maxlength="64" size="20" class="input1" name="inputUsername" value="">
                			</p>
	                		
	                		<p>
                    		<label>Password</label>
                    		<input tabindex="2" autocomplete="off" type="password" size="20" class="input1" name="inputPassword">
                			</p>
	                		<br>
	                		<br>
	                		
	                		<p style="margin: 10px 0 20px; text-align: right;">
                    		
                			<button type="submit" class="ybtn ybtn-small">Sign in</button>
					</p>
                
						</form>	
					</div>
					
						<div class="column column-beta ">
            			<div class="login-to-signup"><br>
                		<h2>No Account Yet?</h2>
                		
                		<form action=signup.jsp method="get" >
 			         <input class="ybtn ybtn-primary" type="submit" value="SIGN UP">
 				 </form>
            			</div>

						</div>
					
					</div>
				</div>	
			
			</div>        


        
         			
  </div>
  </body>
 
</html>