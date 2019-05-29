package codetest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class TestInsert {

	public static Connection getConnection(String url,String username,String password){
		String driver="com.mysql.cj.jdbc.Driver";
		Connection conn=null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=(Connection)DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;		
	}

	
	public static void main(String args[])throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/mysql?useSSL=false&serverTimezone=GMT"; 
        String username = "test"; 
        String password = "test"; 
        
        Connection conn=getConnection(url, username, password);
        if (conn!=null) {
            System.out.println("��ȡ���ӳɹ�");
            insert(conn);
        }else {
            System.out.println("��ȡ����ʧ��");
        }
	}
	public static void insert(Connection conn) {
		// ��ʼʱ��
        Long begin = new Date().getTime();
        try
        {
        	// ��������Ϊ���Զ��ύ
            conn.setAutoCommit(false);
            PreparedStatement  pst = (PreparedStatement) conn.prepareStatement("select 1 from dull");//׼��ִ�����
            String prefix = "Insert into employees_1 values";
            StringBuffer suffix = new StringBuffer();
            for (int i = 1; i <= 1; i++) {
            	//ÿ�β����������ύ
//            	String sql = "Insert into employees_1 values ('" + i + "','test insert','0002'," + i +")";
            	//5W��һ���ύ
            	for (int j = 1; j <= 50000; j++) {
                    // ����SQL��׺
                    suffix.append("('" + j + "','Test Insert','0003'," + j % 100 +"),");
                }
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                
            	// ���ִ��SQL
                pst.addBatch(sql);
                // ִ�в���
                //System.out.println(sql);
                pst.executeUpdate(sql);
                // �ύ����
                conn.commit();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        // ����ʱ��
        Long end = new Date().getTime();
        // ��ʱ
        System.out.println("���뻨��ʱ�� : " + (end - begin) + " ms");
	}
}
