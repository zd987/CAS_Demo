<%--

    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License.  You may obtain a
    copy of the License at the following location:

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page session="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<spring:theme code="mobile.custom.css.file" var="mobileCss" text="" />
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
	    <title>CAS &#8211; Central Authentication Service</title>
        <c:if test="${not empty requestScope['isMobile'] and not empty mobileCss}">
             <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
             <meta name="apple-mobile-web-app-capable" content="yes" />
             <meta name="apple-mobile-web-app-status-bar-style" content="black" />
             <!--<link type="text/css" rel="stylesheet" media="screen" href="<c:url value="/css/fss-framework-1.1.2.css" />" />
             <link type="text/css" rel="stylesheet" href="<c:url value="/css/fss-mobile-${requestScope['browserType']}-layout.css" />" />
             <link type="text/css" rel="stylesheet" href="${mobileCss}" />-->
        </c:if>
		<spring:theme code="standard.custom.css.file" var="customCssFile" />
        <link type="text/css" rel="stylesheet" href="<c:url value="${customCssFile}" />" />
        <link media="all" rel="stylesheet" href="/cas/css/memberprod.authreg-1.1.css" type="text/css">
        <link media="all" rel="stylesheet" href="/cas/css/alice.common.v1-1.4.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	    <link rel="icon" href="<c:url value="/favicon.ico" />" type="image/x-icon" />
	</head>
	<body id="cas" class="fl-theme-iphone">
    <header id="header">
		<div class="grid-990 header-wrap fn-clear">
			<figure class="fn-left" id="alipay-img-logo">
		       <a title="CAS Server Demo" href="http://localhost:8080/cas/" seed="alipayImgLogo-link" smartracker="on"><img alt="注册" src="/cas/images/logo.png" width="251" height="89"></a>
			</figure>
			<div class="global-toplink">
<!-- 				<a href="http://localhost:8080/cas/login" class="global-toplink-link" seed="global-header-login">登录</a> -->
<!--         		<em class="global-separator">-</em> -->
		        <a href="https://localhost:8443/cas/register.jsp" class="global-toplink-link" seed="global-header-register">注册</a>
<!-- 		        <em class="global-separator">|</em> -->
			</div>
		</div>
	</header>	
			
            <div id="content" class="fl-screenNavigator-scroll-container">
