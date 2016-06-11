<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta name="Description" content="Information architecture, Web Design, Web Standards." />
<meta name="Keywords" content="your, keywords" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="Distribution" content="Global" />
<meta name="Author" content="Erwin Aligam - ealigam@gmail.com" />
<meta name="Robots" content="index,follow" />

<link rel="stylesheet" href="images/Envision.css" type="text/css" />

<title>Fictio</title>
	
</head>

<body>
<!-- wrap(边框,头) starts here -->
<div id="wrap">
		
		<!--header -->
		<div id="header">			
				
			<h1 id="logo-text"><a href="index.html">Fictio</a></h1>		
			<p id="slogan">竹杖芒鞋轻胜马,谁怕?一蓑烟雨任平生</p>		
			
			<div id="header-links">
			<p>
				<a href="index.html">主页</a> | 
				<a href="index.html">联系我</a> | 
				<a href="index.html">位置地图</a>			
			</p>		
		</div>		
						
		</div>
		
		<!-- menu -->	
		<div  id="menu">
			<ul>
				<li id="current"><a href="index.html">主页</a></li>
				<li><a href="index.html">收藏</a></li>
				<li><a href="index.html">下载</a></li>
				<li><a href="index.html">Services</a></li>
				<li><a href="sample.jsp">测试模版</a></li>
				<li class="last"><a href="index.html">关于</a></li>		
			</ul>
		</div>					
			
		<!-- content-wrap(内容边框) starts here -->
		<div id="content-wrap">
				
			<div id="sidebar">
			
				<h3>搜索</h3>	
				<form action="#" class="searchform">
					<p>
					<input name="search_query" class="textbox" type="text" />
  					<input name="search" class="button" value="试试看" type="submit" />
					</p>			
				</form>	
					
				<h3>常用链接</h3>
				<ul class="sidemenu">				
					<li><a href="index.html">我的随笔</a></li>
					<li><a href="#TemplateInfo">我的收藏</a></li>
					<li><a href="#SampleTags">我的标签</a></li>
					<li><a href="#" title="Web Templates">更多链接</a></li>
				</ul>
				
			
				<h3>常用外链</h3>
				<ul class="sidemenu">
					<li><a href="http://www.squidfingers.com/patterns/">Squidfingers</a></li>
					<li><a href="http://www.alistapart.com">Alistapart</a></li>					
				   	<li><a href="#">CSS Mania</a></li>
				</ul>
			
				<h3>热点头条</h3>
                <ul class="sidemenu">
                    <li><a href="#" title="Website Templates">
                    <strong>DreamTemplate</strong></a> <br /> Over 6,000+ Premium Web Templates</li>
                    <li><a href="#" title="WordPress Themes">
                    <strong>ThemeLayouts</strong></a> <br /> Premium WordPress &amp; Joomla Themes</li>
                    <li><a href="#" title="Website Hosting">
                    <strong>ImHosted.com</strong></a> <br /> Affordable Web Hosting Provider</li>
                </ul>
				
				<h3>Wise Words</h3>
				<div class="left-box">
					<p>&quot;Evaluation of the past is the first step toward 
					vision for the future.&quot; </p>
					
					<p class="align-right">- Chris Widener</p>
				</div>	
				
				<h3>扩展支持</h3>
				<div class="left-box">
					<p>If you are interested in supporting my work and would like to contribute, you are
					welcome to make a small donation through the 
					<a href="http://www.cssmoban.com/">donate link</a> on my website - it will 
					be a great help and will surely be appreciated.</p>
				</div>							
								
			</div>
				
			<div id="main">
				
				<a name="TemplateInfo"></a>
				<h2><a href="index.html">Template Info</a></h2>
				
                <p><strong>Envision</strong> is a free, W3C-compliant, CSS-based website template
                by <a href="http://www.cssmoban.com/">styleshout.com</a>. This work is
                distributed under the <a rel="license" href="http://creativecommons.org/licenses/by/2.5/">
                Creative Commons Attribution 2.5  License</a>, which means that you are free to
                use and modify it for any purpose. All I ask is that you give me credit by including a <strong>link back</strong> to
                <a href="http://www.cssmoban.com/">my website</a>.
                </p>

                <p>
                You can find more of my free template designs at <a href="http://www.cssmoban.com/">my website</a>.
                For premium commercial designs, you can check out
                <a href="#" title="Website Templates">DreamTemplate.com</a>.
                </p>
				
				<p class="post-footer align-right">					
					<a href="index.html" class="readmore">Read more</a>
					<a href="index.html" class="comments">Comments (7)</a>
					<span class="date">Oct 01, 2006</span>	
				</p>
			
				<a name="SampleTags"></a>
				<h2><a href="index.html">样式标签</a></h2>
				
				<h3>Code</h3>				
				<p><code>
				code-sample { <br />
				font-weight: bold;<br />
				font-style: italic;<br />				
				}		
				</code></p>	
				<p class="post-footer align-right">					
					<a href="sampleTag.jsp" class="readmore">Read more</a>
					<a href="index.html" class="comments">Comments (7)</a>
					<span class="date">Oct 01, 2006</span>	
				</p>
								
				<h3>联系我</h3>
				<form action="#">			
				<p>			
				<label>Name</label>
				<input name="dname" value="Your Name" type="text" size="30" />
				<label>Email</label>
				<input name="demail" value="Your Email" type="text" size="30" />
				<label>Your Comments</label>
				<textarea rows="5" cols="5"></textarea>
				<br />	
				<input class="button" type="submit" value="确定"/>		
				</p>		
				</form>				
				<br />	
			</div>
		
		<!-- content-wrap ends here -->	
		</div>
					
		<!--footer(页脚) starts here-->
		<div id="footer">			
            <p>
		    &copy; 2016 <strong>Ficito</strong>
            &nbsp;&nbsp;&nbsp;&nbsp;
		    <a href="https://fictio.tuchong.com/" title="photowebsite">个人影展</a> from <a href="https://fictio.tuchong.com/">图虫摄影网</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
		    <a href="index.jsp">Home</a> |
   	        <a href="index.html">Sitemap</a> |
	        <a href="index.html">RSS Feed</a> |
            <a href="http://validator.w3.org/check?uri=referer">XHTML</a> |
		    <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a>
   	    </p>
				
		</div>	
<!-- wrap ends here -->
</div>

</body>
</html>
