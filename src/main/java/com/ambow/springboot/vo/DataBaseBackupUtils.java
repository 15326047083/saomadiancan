package com.ambow.springboot.vo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataBaseBackupUtils {

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return sdf.format(new Date());
	}

	/**
	 * 备份数据库
	 * @param backupDir 备份文件存放路径
	 * @param dbUser 数据库用户名
	 * @param dbPwd 数据库密码
	 * @param dbName 要备份的数据库名
	 * @throws Exception
	 */
	public static boolean backup(String backupDir, String dbUser, String dbPwd, String dbName) throws Exception {
		String savePath = backupDir + "backup-" + getCurrentTime() + ".sql";
		String[] execCMD = new String[] { "mysqldump", "-u" + dbUser, "-p" + dbPwd, dbName, "-r" + savePath,
				"--skip-lock-tables" };
		Process process = Runtime.getRuntime().exec(execCMD);

		int processComplete = process.waitFor();
		if (processComplete == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	

	/**
	 * 每天的10点进行一次备份  备份的文件放在C/数据库备份 当中，备份的文件命名为当天的时间
	 * @param
	 * @throws Exception
	 */

	@Scheduled(cron = "0 00 22 * * ? ")
	public  void  run() {
	String backupDir = "C:/数据库备份/";
	String dbUser = "root";
	String dbPwd = "leiyuan123.";
	String dbName = "saomadiancan";
	try {
		boolean flag = backup(backupDir, dbUser, dbPwd, dbName);
		System.out.println("success");
	} catch (Exception e) {
		System.out.println("fail");
	}


}
}
