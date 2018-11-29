package com.nz.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//定义返回信息
		String message = "";
		// 检查是否是一个文件上传请求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			// 不是文件上传请求，就不进行文件上传操作
			return;
		} else{
			try {
				//是文件上传
				// 1、 创建一个DiskFileItemFactory工厂对象,用户创建FileItem
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 2、创建一个文件上传的处理器
				ServletFileUpload upload = new ServletFileUpload(factory);
				//3、接收文件上传表单中的所有请求
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem fileItem : items) {
					// 如果是普通控件，直接获取输入的值
					if (fileItem.isFormField()) {
						String name = fileItem.getString("UTF-8");
					} else {
						//获得上传文件的文件名，写入到指定的位置
						String fileName = fileItem.getName();
						message = "文件上传成功！";
						fileItem.write(new File("e:/"+fileName));
					}
				}
			} catch (Exception e) {
				message = "文件上传失败！";
				e.printStackTrace();
			}
		}
		request.setAttribute("message", message);
		//此时，刷新浏览器，不会弹出提示框让你确认是否重新提交表单
		//问，此种方式可以把request范围的属性传递过去吗？ContextPath是指的什么？
		response.sendRedirect(request.getContextPath() + "/result.jsp");
	}
}
