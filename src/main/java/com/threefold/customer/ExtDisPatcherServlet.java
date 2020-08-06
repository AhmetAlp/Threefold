package com.threefold.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.ContentCachingResponseWrapper;

import me.vcoder.httplogger.MultiReadHttpServletRequest;

@Component("dispatcherServlet")
public class ExtDisPatcherServlet extends DispatcherServlet {

	private static final long serialVersionUID = -322752061902118539L;

	@Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MultiReadHttpServletRequest requestWrapper = null;
        try {
            requestWrapper = new MultiReadHttpServletRequest(request);
            if (!(response instanceof ContentCachingResponseWrapper)) {
                ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
                super.doDispatch(requestWrapper, responseWrapper);
                responseWrapper.copyBodyToResponse();
            }else {
                super.doDispatch(requestWrapper, response);
            }
        } catch (Exception e) {
            super.doDispatch(request, response);
        }
    }
} 