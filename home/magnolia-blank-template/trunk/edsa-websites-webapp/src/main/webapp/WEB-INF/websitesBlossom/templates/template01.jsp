<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="cms-taglib" prefix="cms" %>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="sv" lang="sv">
<head>
<title>${content.title}</title>
<style type="text/css">

	body { font-family: "Lucida Sans Unicode","Lucida Grande",Verdana,Arial,Helvetica,sans-serif; font-size: 13px; background-color: #DDDDDD; }
    a {color: #4040ff}
    a:visited {color: #4040ff;}
    #container {margin-left:50px; width:875px;}
    #logo {font-family:Georgia,'Times New Roman',Times,serif;font-size:46px;padding:50px 0px 8px 10px;background-color:#ffffff;}
    #menu ul {
        background:#313131;
        background:-moz-linear-gradient(center top ,#5D5Da0, #313160);
        background:-webkit-gradient(linear, left top, left bottom, from(#5D5Da0), to(#313160));
        height:30px;
        margin: 0 0 10px 0;
        padding:0 0 0 4px;
        font-size:14px;
        list-style:none;}
    #menu ul li {margin-top:0;float:left;display:inline}
    #menu ul li a {margin-top:4px;padding:5px 8px;color:#fff;text-decoration:none;display:block;outline:0 none;}
    #menu ul li a:hover {background:#fafafa;color:#4b4b4b}
    #content {background-color:white;padding:15px;margin-bottom:20px;-moz-border-radius-bottomleft:5px;-moz-border-radius-bottomright:5px;}
	#main { float:left; width: 625px; background-color: #ffffff;}
	#rightcolumn { float:left; width: 200px; background-color: #ffffff;margin-left:20px;}
    #copyright {padding:20px 15px 0 15px;clear:both;text-align:center;color: #737373;}

</style>
</head>
<body>
	<cms:mainBar adminButtonVisible="true" dialog="main-properties" label="Properties" />

    <div id="container">

        <div id="logo">Sample Template</div>

        <div id="menu">
            <cms:setNode var="sections" path="/sections" />
            <ul>
            <c:forEach items="${sections.children}" var="section">
                <li><a href="${pageContext.request.contextPath}${section.handle}.html">${section.title}</a></li>
            </c:forEach>
            </ul>
        </div>

        <div id="content">

            <div id="main">
                <cms:contentNodeIterator contentNodeCollectionName="main">
                    <cms:includeTemplate/>
                </cms:contentNodeIterator>
                <cms:newBar contentNodeCollectionName="main" paragraph="text"/>
            </div>

            <div id="rightcolumn">
                <cms:contentNodeIterator contentNodeCollectionName="right">
                    <cms:includeTemplate/>
                </cms:contentNodeIterator>
                <cms:newBar contentNodeCollectionName="right" paragraph="text"/>
            </div>

            <div id="copyright">Sample Template Copyright</div>

        </div>
    </div>
</body>
</html>
