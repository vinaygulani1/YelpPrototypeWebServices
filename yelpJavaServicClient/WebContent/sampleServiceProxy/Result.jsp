<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServiceProxyid" scope="session" class="Connection.ServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        Connection.Service getService10mtemp = sampleServiceProxyid.getService();
if(getService10mtemp == null){
%>
<%=getService10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String name_1id=  request.getParameter("name18");
            java.lang.String name_1idTemp = null;
        if(!name_1id.equals("")){
         name_1idTemp  = name_1id;
        }
        Connection.Review[] getAllReviews15mtemp = sampleServiceProxyid.getAllReviews(name_1idTemp);
if(getAllReviews15mtemp == null){
%>
<%=getAllReviews15mtemp %>
<%
}else{
        String tempreturnp16 = null;
        if(getAllReviews15mtemp != null){
        java.util.List listreturnp16= java.util.Arrays.asList(getAllReviews15mtemp);
        tempreturnp16 = listreturnp16.toString();
        }
        %>
        <%=tempreturnp16%>
        <%
}
break;
case 20:
        gotMethod = true;
        String fname_2id=  request.getParameter("fname23");
            java.lang.String fname_2idTemp = null;
        if(!fname_2id.equals("")){
         fname_2idTemp  = fname_2id;
        }
        String lname_3id=  request.getParameter("lname25");
            java.lang.String lname_3idTemp = null;
        if(!lname_3id.equals("")){
         lname_3idTemp  = lname_3id;
        }
        String name_4id=  request.getParameter("name27");
            java.lang.String name_4idTemp = null;
        if(!name_4id.equals("")){
         name_4idTemp  = name_4id;
        }
        boolean deleteReview20mtemp = sampleServiceProxyid.deleteReview(fname_2idTemp,lname_3idTemp,name_4idTemp);
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteReview20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
break;
case 29:
        gotMethod = true;
        String name_5id=  request.getParameter("name32");
            java.lang.String name_5idTemp = null;
        if(!name_5id.equals("")){
         name_5idTemp  = name_5id;
        }
        String rating_6id=  request.getParameter("rating34");
            java.lang.String rating_6idTemp = null;
        if(!rating_6id.equals("")){
         rating_6idTemp  = rating_6id;
        }
        String review_7id=  request.getParameter("review36");
            java.lang.String review_7idTemp = null;
        if(!review_7id.equals("")){
         review_7idTemp  = review_7id;
        }
        String fname_8id=  request.getParameter("fname38");
            java.lang.String fname_8idTemp = null;
        if(!fname_8id.equals("")){
         fname_8idTemp  = fname_8id;
        }
        String lname_9id=  request.getParameter("lname40");
            java.lang.String lname_9idTemp = null;
        if(!lname_9id.equals("")){
         lname_9idTemp  = lname_9id;
        }
        String description_10id=  request.getParameter("description42");
            java.lang.String description_10idTemp = null;
        if(!description_10id.equals("")){
         description_10idTemp  = description_10id;
        }
        boolean insertReview29mtemp = sampleServiceProxyid.insertReview(name_5idTemp,rating_6idTemp,review_7idTemp,fname_8idTemp,lname_9idTemp,description_10idTemp);
        String tempResultreturnp30 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertReview29mtemp));
        %>
        <%= tempResultreturnp30 %>
        <%
break;
case 44:
        gotMethod = true;
        String description_11id=  request.getParameter("description47");
            java.lang.String description_11idTemp = null;
        if(!description_11id.equals("")){
         description_11idTemp  = description_11id;
        }
        String rating_12id=  request.getParameter("rating49");
            java.lang.String rating_12idTemp = null;
        if(!rating_12id.equals("")){
         rating_12idTemp  = rating_12id;
        }
        String review_13id=  request.getParameter("review51");
            java.lang.String review_13idTemp = null;
        if(!review_13id.equals("")){
         review_13idTemp  = review_13id;
        }
        String fname_14id=  request.getParameter("fname53");
            java.lang.String fname_14idTemp = null;
        if(!fname_14id.equals("")){
         fname_14idTemp  = fname_14id;
        }
        String lname_15id=  request.getParameter("lname55");
            java.lang.String lname_15idTemp = null;
        if(!lname_15id.equals("")){
         lname_15idTemp  = lname_15id;
        }
        String name_16id=  request.getParameter("name57");
            java.lang.String name_16idTemp = null;
        if(!name_16id.equals("")){
         name_16idTemp  = name_16id;
        }
        boolean updateReview44mtemp = sampleServiceProxyid.updateReview(description_11idTemp,rating_12idTemp,review_13idTemp,fname_14idTemp,lname_15idTemp,name_16idTemp);
        String tempResultreturnp45 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateReview44mtemp));
        %>
        <%= tempResultreturnp45 %>
        <%
break;
case 59:
        gotMethod = true;
        String category_17id=  request.getParameter("category62");
            java.lang.String category_17idTemp = null;
        if(!category_17id.equals("")){
         category_17idTemp  = category_17id;
        }
        Connection.Category[] getCatNames59mtemp = sampleServiceProxyid.getCatNames(category_17idTemp);
if(getCatNames59mtemp == null){
%>
<%=getCatNames59mtemp %>
<%
}else{
        String tempreturnp60 = null;
        if(getCatNames59mtemp != null){
        java.util.List listreturnp60= java.util.Arrays.asList(getCatNames59mtemp);
        tempreturnp60 = listreturnp60.toString();
        }
        %>
        <%=tempreturnp60%>
        <%
}
break;
case 64:
        gotMethod = true;
        String email_18id=  request.getParameter("email67");
            java.lang.String email_18idTemp = null;
        if(!email_18id.equals("")){
         email_18idTemp  = email_18id;
        }
        String pswd_19id=  request.getParameter("pswd69");
            java.lang.String pswd_19idTemp = null;
        if(!pswd_19id.equals("")){
         pswd_19idTemp  = pswd_19id;
        }
        boolean signIn64mtemp = sampleServiceProxyid.signIn(email_18idTemp,pswd_19idTemp);
        String tempResultreturnp65 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signIn64mtemp));
        %>
        <%= tempResultreturnp65 %>
        <%
break;
case 71:
        gotMethod = true;
        String fname_20id=  request.getParameter("fname74");
            java.lang.String fname_20idTemp = null;
        if(!fname_20id.equals("")){
         fname_20idTemp  = fname_20id;
        }
        String lname_21id=  request.getParameter("lname76");
            java.lang.String lname_21idTemp = null;
        if(!lname_21id.equals("")){
         lname_21idTemp  = lname_21id;
        }
        String email_22id=  request.getParameter("email78");
            java.lang.String email_22idTemp = null;
        if(!email_22id.equals("")){
         email_22idTemp  = email_22id;
        }
        String pswd_23id=  request.getParameter("pswd80");
            java.lang.String pswd_23idTemp = null;
        if(!pswd_23id.equals("")){
         pswd_23idTemp  = pswd_23id;
        }
        boolean signUp71mtemp = sampleServiceProxyid.signUp(fname_20idTemp,lname_21idTemp,email_22idTemp,pswd_23idTemp);
        String tempResultreturnp72 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signUp71mtemp));
        %>
        <%= tempResultreturnp72 %>
        <%
break;
case 82:
        gotMethod = true;
        String email_24id=  request.getParameter("email85");
            java.lang.String email_24idTemp = null;
        if(!email_24id.equals("")){
         email_24idTemp  = email_24id;
        }
        String time_25id=  request.getParameter("time87");
            java.lang.String time_25idTemp = null;
        if(!time_25id.equals("")){
         time_25idTemp  = time_25id;
        }
        boolean setLastLoginTime82mtemp = sampleServiceProxyid.setLastLoginTime(email_24idTemp,time_25idTemp);
        String tempResultreturnp83 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(setLastLoginTime82mtemp));
        %>
        <%= tempResultreturnp83 %>
        <%
break;
case 89:
        gotMethod = true;
        String fname_26id=  request.getParameter("fname92");
            java.lang.String fname_26idTemp = null;
        if(!fname_26id.equals("")){
         fname_26idTemp  = fname_26id;
        }
        String lname_27id=  request.getParameter("lname94");
            java.lang.String lname_27idTemp = null;
        if(!lname_27id.equals("")){
         lname_27idTemp  = lname_27id;
        }
        Connection.Review[] getUserReviews89mtemp = sampleServiceProxyid.getUserReviews(fname_26idTemp,lname_27idTemp);
if(getUserReviews89mtemp == null){
%>
<%=getUserReviews89mtemp %>
<%
}else{
        String tempreturnp90 = null;
        if(getUserReviews89mtemp != null){
        java.util.List listreturnp90= java.util.Arrays.asList(getUserReviews89mtemp);
        tempreturnp90 = listreturnp90.toString();
        }
        %>
        <%=tempreturnp90%>
        <%
}
break;
case 96:
        gotMethod = true;
        String email_28id=  request.getParameter("email107");
            java.lang.String email_28idTemp = null;
        if(!email_28id.equals("")){
         email_28idTemp  = email_28id;
        }
        String pswd_29id=  request.getParameter("pswd109");
            java.lang.String pswd_29idTemp = null;
        if(!pswd_29id.equals("")){
         pswd_29idTemp  = pswd_29id;
        }
        Connection.UserDetails getUserDetails96mtemp = sampleServiceProxyid.getUserDetails(email_28idTemp,pswd_29idTemp);
if(getUserDetails96mtemp == null){
%>
<%=getUserDetails96mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">pswd:</TD>
<TD>
<%
if(getUserDetails96mtemp != null){
java.lang.String typepswd99 = getUserDetails96mtemp.getPswd();
        String tempResultpswd99 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepswd99));
        %>
        <%= tempResultpswd99 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lname:</TD>
<TD>
<%
if(getUserDetails96mtemp != null){
java.lang.String typelname101 = getUserDetails96mtemp.getLname();
        String tempResultlname101 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelname101));
        %>
        <%= tempResultlname101 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(getUserDetails96mtemp != null){
java.lang.String typeemail103 = getUserDetails96mtemp.getEmail();
        String tempResultemail103 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail103));
        %>
        <%= tempResultemail103 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fname:</TD>
<TD>
<%
if(getUserDetails96mtemp != null){
java.lang.String typefname105 = getUserDetails96mtemp.getFname();
        String tempResultfname105 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefname105));
        %>
        <%= tempResultfname105 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 111:
        gotMethod = true;
        String email_30id=  request.getParameter("email114");
            java.lang.String email_30idTemp = null;
        if(!email_30id.equals("")){
         email_30idTemp  = email_30id;
        }
        java.lang.String getLastLoginTime111mtemp = sampleServiceProxyid.getLastLoginTime(email_30idTemp);
if(getLastLoginTime111mtemp == null){
%>
<%=getLastLoginTime111mtemp %>
<%
}else{
        String tempResultreturnp112 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getLastLoginTime111mtemp));
        %>
        <%= tempResultreturnp112 %>
        <%
}
break;
case 116:
        gotMethod = true;
        String category_31id=  request.getParameter("category119");
            java.lang.String category_31idTemp = null;
        if(!category_31id.equals("")){
         category_31idTemp  = category_31id;
        }
        String name_32id=  request.getParameter("name121");
            java.lang.String name_32idTemp = null;
        if(!name_32id.equals("")){
         name_32idTemp  = name_32id;
        }
        boolean insertCategoryName116mtemp = sampleServiceProxyid.insertCategoryName(category_31idTemp,name_32idTemp);
        String tempResultreturnp117 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertCategoryName116mtemp));
        %>
        <%= tempResultreturnp117 %>
        <%
break;
case 123:
        gotMethod = true;
        String email_33id=  request.getParameter("email126");
            java.lang.String email_33idTemp = null;
        if(!email_33id.equals("")){
         email_33idTemp  = email_33id;
        }
        String dateTime_34id=  request.getParameter("dateTime128");
            java.lang.String dateTime_34idTemp = null;
        if(!dateTime_34id.equals("")){
         dateTime_34idTemp  = dateTime_34id;
        }
        boolean updateLastLoginTime123mtemp = sampleServiceProxyid.updateLastLoginTime(email_33idTemp,dateTime_34idTemp);
        String tempResultreturnp124 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateLastLoginTime123mtemp));
        %>
        <%= tempResultreturnp124 %>
        <%
break;
case 130:
        gotMethod = true;
        String category_35id=  request.getParameter("category133");
            java.lang.String category_35idTemp = null;
        if(!category_35id.equals("")){
         category_35idTemp  = category_35id;
        }
        String name_36id=  request.getParameter("name135");
            java.lang.String name_36idTemp = null;
        if(!name_36id.equals("")){
         name_36idTemp  = name_36id;
        }
        boolean isCategoryExists130mtemp = sampleServiceProxyid.isCategoryExists(category_35idTemp,name_36idTemp);
        String tempResultreturnp131 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(isCategoryExists130mtemp));
        %>
        <%= tempResultreturnp131 %>
        <%
break;
case 137:
        gotMethod = true;
        java.lang.String[] getDistinctCategories137mtemp = sampleServiceProxyid.getDistinctCategories();
if(getDistinctCategories137mtemp == null){
%>
<%=getDistinctCategories137mtemp %>
<%
}else{
        String tempreturnp138 = null;
        if(getDistinctCategories137mtemp != null){
        java.util.List listreturnp138= java.util.Arrays.asList(getDistinctCategories137mtemp);
        tempreturnp138 = listreturnp138.toString();
        }
        %>
        <%=tempreturnp138%>
        <%
}
break;
case 140:
        gotMethod = true;
        String email_37id=  request.getParameter("email143");
            java.lang.String email_37idTemp = null;
        if(!email_37id.equals("")){
         email_37idTemp  = email_37id;
        }
        String dateTime_38id=  request.getParameter("dateTime145");
            java.lang.String dateTime_38idTemp = null;
        if(!dateTime_38id.equals("")){
         dateTime_38idTemp  = dateTime_38id;
        }
        boolean insertLastLoginTime140mtemp = sampleServiceProxyid.insertLastLoginTime(email_37idTemp,dateTime_38idTemp);
        String tempResultreturnp141 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertLastLoginTime140mtemp));
        %>
        <%= tempResultreturnp141 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>