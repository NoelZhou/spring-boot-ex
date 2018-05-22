package com.swdegao.quartz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.swdegao.quartz.common.JDBConection;

public class JDBCTest {
	public static void main(String[] args) {
		Connection conn = new JDBConection().connection;
	    String sql = "SELECT \r\n" + 
	    		"			job.JOB_NAME as jobName,\r\n" + 
	    		"			job.JOB_GROUP as jobGroup,\r\n" + 
	    		"			job.DESCRIPTION as description,\r\n" + 
	    		"			job.JOB_CLASS_NAME as jobClassName,\r\n" + 
	    		"			cron.CRON_EXPRESSION as cronExpression,\r\n" + 
	    		"			tri.TRIGGER_NAME as triggerName,\r\n" + 
	    		"			tri.TRIGGER_STATE as triggerState,\r\n" + 
	    		"			tri.NEXT_FIRE_TIME as nextFireTime,\r\n" + 
	    		"			tri.PREV_FIRE_TIME as prevFireTime,\r\n" + 
	    		"			job.JOB_NAME as oldJobName,\r\n" + 
	    		"			job.JOB_GROUP as oldJobGroup\r\n" + 
	    		"		FROM qrtz_job_deta ils AS job \r\n" + 
	    		"		LEFT JOIN qrtz_triggers AS tri ON job.JOB_NAME = tri.JOB_NAME\r\n" + 
	    		"		LEFT JOIN qrtz_cron_triggers AS cron ON cron.TRIGGER_NAME = tri.TRIGGER_NAME \r\n" + 
	    		"		WHERE tri.TRIGGER_TYPE = 'CRON'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
