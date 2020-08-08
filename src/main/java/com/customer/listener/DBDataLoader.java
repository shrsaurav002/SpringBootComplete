/*
 * package com.customer.listener;
 * 
 * import java.io.File; import java.sql.Connection; import
 * java.sql.PreparedStatement; import java.sql.ResultSet;
 * 
 * import javax.servlet.ServletContext; import
 * javax.servlet.ServletContextEvent; import
 * javax.servlet.ServletContextListener; import
 * javax.servlet.annotation.WebListener; import javax.sql.DataSource;
 * 
 * import org.apache.commons.io.FileUtils; import
 * org.springframework.context.ApplicationContext; import
 * org.springframework.core.io.ByteArrayResource; import
 * org.springframework.jdbc.datasource.init.ScriptUtils; import
 * org.springframework.util.ResourceUtils; import
 * org.springframework.web.context.support.WebApplicationContextUtils;
 * 
 * @WebListener public class DBDataLoader implements ServletContextListener {
 * 
 * @Override public void contextInitialized(ServletContextEvent arg0) {
 * ServletContext servletContext = arg0.getServletContext(); ApplicationContext
 * applicationContext =
 * WebApplicationContextUtils.getWebApplicationContext(servletContext);
 * System.out.println("Listener"); try { File file =
 * ResourceUtils.getFile("classpath:/db/script1.sql"); String content =
 * FileUtils.readFileToString(file); Connection conn = null; try { DataSource
 * dataSource = (DataSource) applicationContext.getBean("dataSource"); conn =
 * dataSource.getConnection();
 * 
 * boolean execute = false; try { PreparedStatement ps =
 * conn.prepareStatement("select username from user_login_tbl"); ResultSet rs =
 * ps.executeQuery(); if (!rs.next()) { execute = true; } } catch (Exception e)
 * { System.out.println(e.getMessage()); execute = true; } if (execute) {
 * conn.setAutoCommit(false); ScriptUtils.executeSqlScript(conn, new
 * ByteArrayResource(content.getBytes()));
 * System.out.println("Script Ran Successfully"); conn.commit(); }else {
 * System.out.println("No need to creating table with script"); } } catch
 * (Exception e) { System.out.println(e.getMessage()); if (conn != null) { try {
 * conn.rollback(); conn.close(); } catch (Exception e2) { e2.printStackTrace();
 * } } } } catch (Exception e) { System.out.println(e.getMessage()); }
 * 
 * }
 * 
 * @Override public void contextDestroyed(ServletContextEvent arg0) { } }
 */